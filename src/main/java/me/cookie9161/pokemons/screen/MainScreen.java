package me.cookie9161.pokemons.screen;

import me.cookie9161.pokemons.player.Player;

import java.util.Scanner;

public class MainScreen {
    private Scanner input;
    private String playerName;
    private Player player;

    public MainScreen() {
    }

    public void welcomePlayerPack() {
        System.out.println(playerIntroduction());

        this.playerInput();
        playerName = this.getPlayerInput();
        System.out.printf("Hello %s!\n", playerName);
        player = createPlayer();
    }

    public void playerInput() {
        input = new Scanner(System.in);
    }

    public String getPlayerInput() {
        return input.nextLine();
    }

    private Player createPlayer() {
        return new Player(playerName);
    }

    public Player getPlayer() {
        return player;
    }

    private String playerIntroduction() {
        return """
                Welcome to the world of Pokemon!
                My name is Oak! People call me the Pokemon Prof!
                This world is inhabited by creatures called Pokemon!
                For some people, Pokemon are pets. Others use them for fights.
                Myself... I study Pokemon as a profession.
                First, what is your name?""";
    }

    private String playerChoseFirstPokemon(){
        return """
                Great! Now, %s, let's choose your first Pokemon!
                Here are some Pokemon you can choose from:""";
    }
}
