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

    private Messages() {
    }

    public static void sendMessage(String message, Object... args) {
        System.out.printf(message, args);
    }
}
