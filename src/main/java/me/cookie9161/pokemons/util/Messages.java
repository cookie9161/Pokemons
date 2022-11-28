package me.cookie9161.pokemons.util;

public class Messages {
    public static final String PLAYER_INTRODUCTION =
            """
            Welcome to the world of Pokemon!
            My name is Oak! People call me the Pokemon Prof!
            This world is inhabited by creatures called Pokemon!
            For some people, Pokemon are pets. Others use them for fights.
            Myself... I study Pokemon as a profession.
            
            First, please enter your name:
            """;

    public static final String PLAYER_CHOSE_FIRST_POKEMON =
            """
            Great! Now, %s, let's choose your first Pokemon!
            
            Here are some Pokemon you can choose from:""";

    public static final String POKEMON_USE_ATTACK =
            """
            %s used %s!
            """;

    public static final String ATTACK_HIT =
            """
            It's super effective!
            """;

    public static final String ATTACK_MISS =
            """
            It missed!
            """;

    public static final String POKEMON_NOT_FOUND =
            """
            Pokemon {} doesn't exist
            """;

    public static final String POKEMON_NAME_ALREADY_DEFINED =
            """
            Pokemon {} already exists with id {}
            """;

     public static final String POKEMON_ID_ALREADY_EXISTS =
            """
            ID {} is already taken by Pokemon {}
            """;


    public static final String POKEMON_KNOCKED_OUT =
            """
            Pokemon %s is knocked out!
            """;

    public static final String SQL_QUERY_FAIL =
            """
            Failed to execute query: %s
            """;

    public static final String FAILED_TO_CONNECT =
            """
            Failed to connect to database!
            """;

    public static final String FAILED_TO_CREATE_POOL =
            """
            Failed to create a pool!
            """;

    public static final String WRONG_POTION_TO_REVIVE =
            """
            Used wrong potion to revive
            """;

    public static final String CREATING_POKEMON =
            """
            Creating Pokemon {} with id {}
            """;

    public static final String SEARCHING_POKEMON =
            """
            Searching for pokemon {}
            """;

    private Messages() {
    }

    public static void sendMessage(String message, Object... args) {
        System.out.printf(message, args);
    }
}
