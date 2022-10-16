package me.cookie9161.pokemons.model.player;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class PlayerInput {
    private final Scanner scanner;

    public PlayerInput() {
        scanner = new Scanner(System.in);
    }

    public String awaitInput() {
        return scanner.nextLine();
    }
}
