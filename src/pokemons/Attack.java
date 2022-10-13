package pokemons;

public class Attack{
    private final String name;
    private final ElementsType type;
    private final int baseDamage;

    public Attack(String name, ElementsType type, int baseDamage) {
        this.name = name;
        this.type = type;
        this.baseDamage = baseDamage;
    }

    public String getName() {
        return name;
    }

    public ElementsType getType() {
        return type;
    }

    public int getBaseDamage() {
        return baseDamage;
    }
}