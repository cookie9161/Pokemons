package me.cookie9161.pokemons.screen;

import me.cookie9161.pokemons.player.PlayerInput;
import me.cookie9161.pokemons.util.Messages;


public class MainScreen {
    private final PlayerInput playerInput;


    public MainScreen() {
        playerInput = new PlayerInput();
    }

    public void welcomePlayerPack() {
        Messages.sendMessage(Messages.PLAYER_INTRODUCTION);
        Messages.sendMessage(Messages.PLAYER_CHOSE_FIRST_POKEMON, playerInput.awaitInput());
    }

}
