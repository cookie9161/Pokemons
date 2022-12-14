package me.cookie9161.pokemons.model.pokemons;


import lombok.extern.slf4j.Slf4j;
import me.cookie9161.pokemons.model.potion.Potion;
import me.cookie9161.pokemons.model.potion.PotionType;
import me.cookie9161.pokemons.repository.impl.InMemoryPokemonRepository;
import me.cookie9161.pokemons.util.Messages;
import me.cookie9161.pokemons.util.RNG;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Slf4j
@Getter
@Setter
public class Pokemon {
    private static final double RNG_DEVIATION = 0.15;
    private static final double WEAK_ATTACK_MULTIPLIER = 0.5;
    private static final double STRONG_ATTACK_MULTIPLIER = 1.25;

    private static final InMemoryPokemonRepository IN_MEMORY_POKEMON_REPOSITORY = new InMemoryPokemonRepository();

    private final String name;
    private final ElementsType type;

    private int hp;
    private int basePokemonPower;
    private int experience;
    private int maxHp;
    private int level;

    private List<Attack> pokemonAttacks;

    //TODO maybe add luck to constructor?
    public Pokemon(String name, ElementsType elementsType, int hp, int basePokemonPower, List<Attack> pokemonAttacks) {
        this.name = name;
        this.type = elementsType;
        this.hp = Math.max(hp, 1);
        this.basePokemonPower = Math.max(basePokemonPower, 1);
        this.experience = 0;
        this.maxHp = hp;
        this.pokemonAttacks = pokemonAttacks;
        this.level = Level.getLevel(experience);
    }

    public Optional<Pokemon> getPokemon(String name) {
        Optional<Pokemon> optionalPokemon = IN_MEMORY_POKEMON_REPOSITORY.getPokemon(name);
        if (optionalPokemon.isEmpty()) {
            log.error(Messages.POKEMON_NOT_FOUND.formatted(name));
        }
        return optionalPokemon;
    }

//TODO add attack accuracy to the method and implement attackPower to calculate damage (divide by 10 and multiply by PokemonPower)
    private void attack(Attack chosenAttack, Pokemon target, int pokemonPower) {
        Messages.sendMessage(Messages.POKEMON_USE_ATTACK, this.name, chosenAttack.getName());

        int damage = getAttackMultiplier(chosenAttack.getType(), target.getType(), pokemonPower);

        int interval = (int) (damage * RNG_DEVIATION);

        damage = RNG.getRandomNumberWithinRange(damage - interval, damage + interval);

        if (RNG.isHit(chosenAttack.getAccuracy())) {
            target.setHp(Math.max(target.getHp() - damage, 0));
            Messages.sendMessage(Messages.ATTACK_HIT);
        } else {
            Messages.sendMessage(Messages.ATTACK_MISS);
        }
    }

    private int getAttackMultiplier(ElementsType attackElementsType, ElementsType targetPokemonElementsType, int pokemonPower) {
        if (this.type.isWeakAgainst(targetPokemonElementsType) || attackElementsType.isWeakAgainst(targetPokemonElementsType)) {
            return (int) (pokemonPower * WEAK_ATTACK_MULTIPLIER);
        } else if (this.type.isStrongAgainst(targetPokemonElementsType) || attackElementsType.isStrongAgainst(targetPokemonElementsType)) {
            return (int) (pokemonPower * STRONG_ATTACK_MULTIPLIER);
        }
        return pokemonPower;
    }

    public void attack(Attack chosenAttack, Pokemon target) {
        attack(chosenAttack, target, this.basePokemonPower);
    }

    public void heal(int hpAmount) {
        if (!isKnockedOut()) {
            this.setHp(Math.min(this.getHp() + hpAmount, this.getMaxHp()));
        } else {
            Messages.sendMessage(Messages.POKEMON_KNOCKED_OUT, this.getName());
        }
    }

    public void revive(Potion revivePotion){
        if (!isKnockedOut()){
            return;
        }

        if (revivePotion.getPotionType().equals(PotionType.REVIVE)){
            this.setHp(revivePotion.getPotionType().getHpIncreaseAmount());
        } else {
            Messages.sendMessage(Messages.WRONG_POTION_TO_REVIVE);
        }
    }

    public boolean isKnockedOut() {
        return this.getHp() == 0;
    }

    public void levelUp() {
        if (this.level >= Level.getLevel(this.getExperience())) {
            this.level = Level.getLevel(this.getExperience());
            this.setMaxHp(this.getMaxHp() + 10);
            this.setHp(this.getMaxHp());
            this.setBasePokemonPower(this.getBasePokemonPower() + 5);
        }
    }

}