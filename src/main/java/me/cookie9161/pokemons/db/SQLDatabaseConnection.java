package me.cookie9161.pokemons.db;

import me.cookie9161.pokemons.util.Messages;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class SQLDatabaseConnection {
    protected static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    protected static final Logger LOGGER = LoggerFactory.getLogger(SQLDatabaseConnection.class);

    public abstract void connect();
    public abstract void disconnect();
    public abstract Connection getConnection();

    public final void executeUpdate(String query) {
        if (StringUtils.isBlank(query)) {
            return;
        }

        EXECUTOR_SERVICE.submit(() -> {
            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(query);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException exception) {
                LOGGER.error(Messages.SQL_QUERY_FAIL.formatted(query), exception);
            }
        });
    }

    public final Optional<CompletableFuture<ResultSet>> executeQuery(String query) {
        if (StringUtils.isBlank(query)) {
            return Optional.empty();
        }

        return Optional.of(CompletableFuture.supplyAsync(() -> {
            try {
                PreparedStatement preparedStatement = getConnection().prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
                preparedStatement.close();
                return resultSet;
            } catch (SQLException exception){
                LOGGER.error(Messages.SQL_QUERY_FAIL.formatted(query), exception);
                return null;
            }
        }, EXECUTOR_SERVICE));
    }
}
