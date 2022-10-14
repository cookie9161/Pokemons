package me.cookie9161.pokemons.player;

import me.cookie9161.pokemons.pokemons.Pokemon;

import java.util.List;

public class Player {
    private final String name;
    private List<Pokemon> pokemons;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon){
        pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon){
        pokemons.remove(pokemon);
    }

    public Pokemon getPokemon(int index){
        return pokemons.get(index);
    }

    public Pokemon getPokemon(String name){
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equals(name)) {
                return pokemon;
            }
        }
        return null;
    }

}
