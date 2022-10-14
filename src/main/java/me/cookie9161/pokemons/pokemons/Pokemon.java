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
    private static final double STRONG_ATTACK_MULTIPLIER = 1.5;

    private final String name;
    private final ElementsType type;

    private int hp;
    private int baseAttackPower;
    private int experience;
    private int maxHp;
    private int level;

    private List<Attack> pokemonAttacks;

    public Pokemon(String name, ElementsType elementsType, int hp, int baseAttackPower, List<Attack> pokemonAttacks) {
        this.name = name;
        this.type = elementsType;
        this.hp = Math.max(hp, 1);
        this.baseAttackPower = Math.max(baseAttackPower, 1);
        this.experience = 0;
        this.maxHp = hp;
        this.pokemonAttacks = pokemonAttacks;
        this.level = Level.getLevel(experience);
    }

    private void attack(Attack chosenAttack, Pokemon target, int baseDamage) {
        int damage = getAttackMultiplier(chosenAttack.getType(), target.getType(), baseDamage);

        int interval = (int) (damage * RNG_DEVIATION);

        damage = RNG.getRandomNumberWithinRange(damage - interval, damage + interval);

        target.setHp(Math.max(target.getHp() - damage, 0));
    }

    private int getAttackMultiplier(ElementsType attackElementsType, ElementsType targetPokemonElementsType, int baseDamage) {
        if (this.type.isWeakAgainst(targetPokemonElementsType) || attackElementsType.isWeakAgainst(targetPokemonElementsType)) {
            return (int) (baseDamage * WEAK_ATTACK_MULTIPLIER);
        } else if (this.type.isStrongAgainst(targetPokemonElementsType) || attackElementsType.isStrongAgainst(targetPokemonElementsType)) {
            return (int) (baseDamage * STRONG_ATTACK_MULTIPLIER);
        }
        return baseDamage;
    }

    public void attack(Attack chosenAttack, Pokemon target) {
        attack(chosenAttack, target, this.baseAttackPower);
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
            this.setBaseAttackPower(this.getBaseAttackPower() + 5);
        }
    }
}