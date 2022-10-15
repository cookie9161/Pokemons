package me.cookie9161.pokemons.dao;

import me.cookie9161.pokemons.pokemons.Attack;
import me.cookie9161.pokemons.pokemons.ElementsType;
import me.cookie9161.pokemons.pokemons.Pokemon;

import java.util.ArrayList;

// TODO maybe add resources folder with data of Pokemon and Attacks?
public class PokemonDAO {
    private final Pokemon[] pokemons = {
            new Pokemon("Bulbasaur", ElementsType.GRASS, 49, 20,
                    new ArrayList<Attack>() {{
                        add(new Attack("Tackle", ElementsType.NORMAL, 70));
                        add(new Attack("Vine Whip", ElementsType.GRASS, 100));
                        add(new Attack("Razor Leaf", ElementsType.GRASS, 90));
                        add(new Attack("Solar Beam", ElementsType.GRASS, 100));
                    }}),
    };
}
