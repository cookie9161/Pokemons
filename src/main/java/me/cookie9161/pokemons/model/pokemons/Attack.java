package me.cookie9161.pokemons.model.pokemons;

import lombok.Getter;

@Getter
public class Attack{
    private final String name;
    private final ElementsType type;
    private final int baseDamage;
    private final int accuracy;

    public Attack(String name, ElementsType elementsType, int baseDamage, int accuracy) {
        this.name = name;
        this.type = elementsType;
        this.baseDamage = baseDamage;
        this.accuracy = accuracy;
    }
}