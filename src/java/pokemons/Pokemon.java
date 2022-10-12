package java.pokemons;


public class Pokemon {
    final String name;
    final Type type;
    Integer hp;
    Integer baseAttackPower;

    public Pokemon(String name, Type type, Integer hp, Integer baseAttackPower) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.baseAttackPower = baseAttackPower;
    }


}
