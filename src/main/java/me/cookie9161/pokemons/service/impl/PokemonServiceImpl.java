package me.cookie9161.pokemons.service.impl;

import lombok.RequiredArgsConstructor;
import me.cookie9161.pokemons.model.pokemons.Attack;
import me.cookie9161.pokemons.model.pokemons.ElementsType;
import me.cookie9161.pokemons.model.pokemons.Pokemon;
import me.cookie9161.pokemons.model.potion.Potion;
import me.cookie9161.pokemons.repository.SQLPokemonRepository;
import me.cookie9161.pokemons.service.PokemonService;
import me.cookie9161.pokemons.util.Messages;
import me.cookie9161.pokemons.util.RNG;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service("pokemonService")
public class PokemonServiceImpl implements PokemonService {
    private final SQLPokemonRepository pokemonRepository;

    @Override
    public Optional<Pokemon> getPokemon(String name) {
        return Optional.ofNullable(pokemonRepository.findByName(name));
    }

    @Override
    public Optional<Pokemon> getPokemon(Long id) {
        return pokemonRepository.findById(id);
    }

    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }
//
//    private void attack(Attack chosenAttack, Pokemon target, int pokemonPower) {
//        Messages.sendMessage(Messages.POKEMON_USE_ATTACK, this.name, chosenAttack.getName());
//
//        int damage = getAttackMultiplier(chosenAttack.getType(), target.getType(), pokemonPower);
//
//        int interval = (int) (damage * RNG_DEVIATION);
//
//        damage = RNG.getRandomNumberWithinRange(damage - interval, damage + interval);
//
//        if (RNG.isHit(chosenAttack.getAccuracy())) {
//            target.setHp(Math.max(target.getHp() - damage, 0));
//            Messages.sendMessage(Messages.ATTACK_HIT);
//        } else {
//            Messages.sendMessage(Messages.ATTACK_MISS);
//        }
//    }
//
//    private int getAttackMultiplier(ElementsType attackElementsType, ElementsType targetPokemonElementsType, int pokemonPower) {
//        if (this.type.isWeakAgainst(targetPokemonElementsType) || attackElementsType.isWeakAgainst(targetPokemonElementsType)) {
//            return (int) (pokemonPower * WEAK_ATTACK_MULTIPLIER);
//        } else if (this.type.isStrongAgainst(targetPokemonElementsType) || attackElementsType.isStrongAgainst(targetPokemonElementsType)) {
//            return (int) (pokemonPower * STRONG_ATTACK_MULTIPLIER);
//        }
//        return pokemonPower;
//    }
//
//    @Override
//    public void attack(Attack chosenAttack, Pokemon target) {
//        attack(chosenAttack, target, this.basePokemonPower);
//    }
//
//    @Override
//    public void heal(int hpAmount) {
//
//    }
//
//    @Override
//    public void revive(Potion revivePotion) {
//
//    }
//
//    @Override
//    public boolean isKnockedOut() {
//        return false;
//    }
//
//    @Override
//    public void levelUp() {
//
//    }
}
