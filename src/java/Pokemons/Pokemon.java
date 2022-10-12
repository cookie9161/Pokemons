package Pokemons;

import java.util.LinkedList;

public class Pokemon {
    final String name;
    final Type type;
    Integer hp;
    Integer baseAttackPower;
    LinkedList<Attack> attacks;

    public Pokemon(String name, Type type, Integer hp, Integer baseAttackPower, LinkedList<Attack> attacks) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.baseAttackPower = baseAttackPower;
        this.attacks = attacks;
    }
}
