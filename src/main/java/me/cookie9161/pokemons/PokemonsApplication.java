package me.cookie9161.pokemons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class PokemonsApplication implements CommandLineRunner {
    public static void main(String... args) {
        SpringApplication.run(PokemonsApplication.class, args);
    }

    @Override
    public void run(String... args){
        new me.cookie9161.pokemons.CommandLineRunner();
    }
}
