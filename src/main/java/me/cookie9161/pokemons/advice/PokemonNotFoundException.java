package me.cookie9161.pokemons.advice;

public class PokemonNotFoundException extends Throwable{
    public PokemonNotFoundException(Long id) {
        super("Could not find a pokemon with id: " + id);
    }

    public PokemonNotFoundException(String name) {
        super("Could not find a pokemon with name: " + name);
    }
}
