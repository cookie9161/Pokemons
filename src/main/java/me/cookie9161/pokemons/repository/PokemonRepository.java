package me.cookie9161.pokemons.repository;

import com.google.common.collect.ImmutableSet;
import me.cookie9161.pokemons.model.pokemons.Pokemon;

import java.util.Optional;

public interface PokemonRepository {
    void addPokemon(Pokemon pokemon);
    void removePokemon(Pokemon pokemon);
    ImmutableSet<Pokemon> getPokemons();
    Optional<Pokemon> getPokemon(String name);
}
