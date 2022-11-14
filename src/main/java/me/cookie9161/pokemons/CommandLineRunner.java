package me.cookie9161.pokemons;

import me.cookie9161.pokemons.db.PostgresDatabaseConnection;

public class CommandLineRunner {

    public CommandLineRunner() {
//        MainScreen mainScreen = new MainScreen();
//        mainScreen.welcomePlayerPack();

        PostgresDatabaseConnection connection = new PostgresDatabaseConnection();

        connection.connect();

        connection.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Pokemons" +
                        "(id SERIAL PRIMARY KEY, " +
                        "name VARCHAR(100) NOT NULL, " +
                        "elements_Type VARCHAR(50) NOT NULL, " +
                        "hp INT NOT NULL, " +
                        "base_Pokemon_Power INT NOT NULL);"
        );

    }
}
