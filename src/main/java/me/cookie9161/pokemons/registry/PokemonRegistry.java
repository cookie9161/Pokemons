package me.cookie9161.pokemons.registry;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import me.cookie9161.pokemons.model.pokemons.Pokemon;

import java.util.Optional;
import java.util.Set;

public class PokemonRegistry {
    private final Set<Pokemon> pokemons;

    public PokemonRegistry() {
        this.pokemons = Sets.newHashSet();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        pokemons.remove(pokemon);
    }

    public ImmutableSet<Pokemon> getPokemons() {
        return ImmutableSet.copyOf(pokemons);
    }

    public Optional<Pokemon> getPokemon(String name) {
        return pokemons.stream()
                .filter(pokemon -> pokemon.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
