package me.cookie9161.pokemons.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import me.cookie9161.pokemons.util.Messages;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class PostgresDatabaseConnection extends SQLDatabaseConnection {
    private static final String POOL_NAME = "pokemon-pool";

    private HikariDataSource hikariDataSource;

    @Override
    public void connect() {
        try {
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setJdbcUrl("jdbc:postgresql://localhost:5432/Pokemons");
            hikariConfig.setUsername("postgres");
            hikariConfig.setPassword("postgres");
            hikariConfig.setPoolName(POOL_NAME);
            hikariConfig.setMinimumIdle(5);
            hikariConfig.setMaximumPoolSize(10);
            hikariConfig.setMaxLifetime(1800000);
            hikariConfig.setConnectionTimeout(30000);
            hikariConfig.setIdleTimeout(600000);
            hikariConfig.setLeakDetectionThreshold(60000);
            hikariConfig.setAutoCommit(true);

            hikariDataSource = new HikariDataSource(hikariConfig);
        } catch (Exception exception) {
            log.error(Messages.FAILED_TO_CONNECT, exception);
        }
    }

    @Override
    public Connection getConnection() {
        try {
            return hikariDataSource.getConnection();
        } catch (SQLException exception) {
            log.error(Messages.FAILED_TO_CREATE_POOL, exception);
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void disconnect() {
        if (hikariDataSource != null && !hikariDataSource.isClosed()) {
            hikariDataSource.close();
        }
    }

    @Override
    public boolean isInitialized() {
        return hikariDataSource != null;
    }
}