package pokemons;


public class Pokemon {
    final String name;
    final ElementsType type;
    Integer hp;
    Integer baseAttackPower;

    public Pokemon(String name, ElementsType type, Integer hp, Integer baseAttackPower) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.baseAttackPower = baseAttackPower;
    }


}
