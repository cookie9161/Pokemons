package me.cookie9161.pokemons.service;

import me.cookie9161.pokemons.model.pokemons.Pokemon;
import org.springframework.hateoas.CollectionModel;

import java.util.List;
import java.util.Optional;

public interface PokemonService {
    Optional<Pokemon> getPokemon(String name);

    Optional<Pokemon> getPokemon(Long id);

    List<Pokemon> getAllPokemons();

    Pokemon createPokemon(Pokemon pokemon);
//    void attack(Attack chosenAttack, Pokemon target);
//    void heal(int hpAmount);
//    void revive(Potion revivePotion);
//    boolean isKnockedOut();
//    void levelUp();
}
