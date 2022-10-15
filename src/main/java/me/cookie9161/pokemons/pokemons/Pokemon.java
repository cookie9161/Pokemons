package me.cookie9161.pokemons.pokemons;


import me.cookie9161.pokemons.util.RNG;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pokemon {
    private static final double RNG_DEVIATION = 0.15;
    private static final double WEAK_ATTACK_MULTIPLIER = 0.5;
    private static final double STRONG_ATTACK_MULTIPLIER = 1.25;

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

    //TODO add attack accuracy to the method and implement attackPower to calculate damage (divide by 10 and multiply by PokemonPower)
    private void attack(Attack chosenAttack, Pokemon target, int pokemonPower) {
        int damage = getAttackMultiplier(chosenAttack.getType(), target.getType(), pokemonPower);

        int interval = (int) (damage * RNG_DEVIATION);

        damage = RNG.getRandomNumberWithinRange(damage - interval, damage + interval);

        target.setHp(Math.max(target.getHp() - damage, 0));
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
        this.setHp(Math.min(this.getHp() + hpAmount, this.getMaxHp()));
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