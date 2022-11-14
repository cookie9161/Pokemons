package me.cookie9161.pokemons.model.pokemons;

public enum ElementsType {
    ELECTRIC,
    FIRE,
    WATER,
    ROCK,
    GRASS,
    GROUND,
    FLYING,
    POISON,
    PSYCHIC,
    FIGHTING,
    NORMAL,
    GHOST,
    ICE,
    DRAGON,
    DARK,
    STEEL,
    FAIRY,
    BUG;

    //TODO create a method isSuperStrongAgainst and implement it to attack method in Pokemon class
    public boolean isStrongAgainst(ElementsType enemyPokemonType){
        return switch (this) {
            case NORMAL -> false;
            case FIGHTING -> enemyPokemonElementComparison(enemyPokemonType, NORMAL, ROCK, STEEL, ICE, DARK);
            case FLYING -> enemyPokemonElementComparison(enemyPokemonType, FIGHTING, BUG, GRASS);
            case POISON -> enemyPokemonElementComparison(enemyPokemonType, GRASS, FAIRY);
            case GROUND -> enemyPokemonElementComparison(enemyPokemonType, POISON, ROCK, STEEL, FIRE, ELECTRIC);
            case ROCK -> enemyPokemonElementComparison(enemyPokemonType, FLYING, BUG, FIRE, ICE);
            case BUG -> enemyPokemonElementComparison(enemyPokemonType, GRASS, PSYCHIC, DARK);
            case GHOST, DARK -> enemyPokemonElementComparison(enemyPokemonType, GHOST, PSYCHIC);
            case STEEL -> enemyPokemonElementComparison(enemyPokemonType, ROCK, ICE, FAIRY);
            case FIRE -> enemyPokemonElementComparison(enemyPokemonType, BUG, STEEL, ICE, GRASS);
            case WATER -> enemyPokemonElementComparison(enemyPokemonType, GROUND, ROCK, FIRE);
            case GRASS -> enemyPokemonElementComparison(enemyPokemonType, GROUND, ROCK, WATER);
            case ELECTRIC -> enemyPokemonElementComparison(enemyPokemonType, FLYING, WATER);
            case PSYCHIC -> enemyPokemonElementComparison(enemyPokemonType, FIGHTING, POISON);
            case ICE -> enemyPokemonElementComparison(enemyPokemonType, FLYING, GROUND, GRASS, DRAGON);
            case DRAGON -> enemyPokemonElementComparison(enemyPokemonType, DRAGON);
            case FAIRY -> enemyPokemonElementComparison(enemyPokemonType, FIGHTING, DRAGON, DARK);
        };
    }

    public boolean isWeakAgainst(ElementsType enemyPokemonType){
        return switch (this) {
            case NORMAL -> enemyPokemonElementComparison(enemyPokemonType, GHOST, ROCK, STEEL);
            case FIGHTING -> enemyPokemonElementComparison(enemyPokemonType, FLYING, FAIRY, PSYCHIC, BUG, GHOST, POISON);
            case FLYING -> enemyPokemonElementComparison(enemyPokemonType, ROCK, STEEL, ELECTRIC);
            case POISON -> enemyPokemonElementComparison(enemyPokemonType, GROUND, POISON, ROCK, GHOST, STEEL);
            case GROUND -> enemyPokemonElementComparison(enemyPokemonType, FLYING, GRASS, BUG);
            case ROCK -> enemyPokemonElementComparison(enemyPokemonType, FIGHTING, GROUND, STEEL);
            case BUG -> enemyPokemonElementComparison(enemyPokemonType, FIGHTING, FLYING, POISON, GHOST, STEEL, FAIRY, FIRE);
            case GHOST -> enemyPokemonElementComparison(enemyPokemonType, DARK, NORMAL);
            case STEEL -> enemyPokemonElementComparison(enemyPokemonType, FIRE, WATER, ELECTRIC, STEEL);
            case FIRE -> enemyPokemonElementComparison(enemyPokemonType, WATER, ROCK, FIRE, DRAGON);
            case WATER -> enemyPokemonElementComparison(enemyPokemonType, GRASS, DRAGON, WATER);
            case GRASS -> enemyPokemonElementComparison(enemyPokemonType, FLYING, POISON, BUG, STEEL, FIRE, GRASS, DRAGON);
            case ELECTRIC -> enemyPokemonElementComparison(enemyPokemonType, GRASS, GROUND, ELECTRIC, DRAGON);
            case PSYCHIC -> enemyPokemonElementComparison(enemyPokemonType, STEEL, DARK, PSYCHIC);
            case ICE -> enemyPokemonElementComparison(enemyPokemonType, STEEL, FIRE, WATER, ICE);
            case DRAGON -> enemyPokemonElementComparison(enemyPokemonType, STEEL, FAIRY);
            case DARK -> enemyPokemonElementComparison(enemyPokemonType, FIGHTING, DARK, FAIRY);
            case FAIRY -> enemyPokemonElementComparison(enemyPokemonType, POISON, STEEL, FIRE);
        };
    }

    private boolean enemyPokemonElementComparison(ElementsType enemyPokemonType, ElementsType... elementsTypesToCompare) {
        for (ElementsType elementsType : elementsTypesToCompare) {
            if (enemyPokemonType.equals(elementsType)) {
                return true;
            }
        }
        return false;
    }
}
