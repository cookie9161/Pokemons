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
            case NORMAL -> enemyPokemonType.equals(NORMAL);
            case FIGHTING -> enemyPokemonType.equals(NORMAL) || enemyPokemonType.equals(ROCK)
                    || enemyPokemonType.equals(STEEL) || enemyPokemonType.equals(ICE) || enemyPokemonType.equals(DARK);
            case FLYING -> enemyPokemonType.equals(FIGHTING) || enemyPokemonType.equals(BUG)
                    || enemyPokemonType.equals(GRASS);
            case POISON -> enemyPokemonType.equals(GRASS) || enemyPokemonType.equals(FAIRY);
            case GROUND -> enemyPokemonType.equals(POISON) || enemyPokemonType.equals(ROCK)
                    || enemyPokemonType.equals(STEEL) || enemyPokemonType.equals(FIRE)
                    || enemyPokemonType.equals(ELECTRIC);
            case ROCK -> enemyPokemonType.equals(FLYING) || enemyPokemonType.equals(BUG)
                    || enemyPokemonType.equals(FIRE) || enemyPokemonType.equals(ICE);
            case BUG -> enemyPokemonType.equals(GRASS) || enemyPokemonType.equals(PSYCHIC)
                    || enemyPokemonType.equals(DARK);
            case GHOST, DARK -> enemyPokemonType.equals(GHOST) || enemyPokemonType.equals(PSYCHIC);
            case STEEL -> enemyPokemonType.equals(ROCK) || enemyPokemonType.equals(ICE)
                    || enemyPokemonType.equals(FAIRY);
            case FIRE -> enemyPokemonType.equals(BUG) || enemyPokemonType.equals(STEEL)
                    || enemyPokemonType.equals(ICE) || enemyPokemonType.equals(GRASS);
            case WATER -> enemyPokemonType.equals(GROUND) || enemyPokemonType.equals(ROCK)
                    || enemyPokemonType.equals(FIRE);
            case GRASS -> enemyPokemonType.equals(GROUND) || enemyPokemonType.equals(ROCK)
                    || enemyPokemonType.equals(WATER);
            case ELECTRIC -> enemyPokemonType.equals(FLYING) || enemyPokemonType.equals(WATER);
            case PSYCHIC -> enemyPokemonType.equals(FIGHTING) || enemyPokemonType.equals(POISON);
            case ICE -> enemyPokemonType.equals(FLYING) || enemyPokemonType.equals(GROUND)
                    || enemyPokemonType.equals(GRASS) || enemyPokemonType.equals(DRAGON);
            case DRAGON -> enemyPokemonType.equals(DRAGON);
            case FAIRY -> enemyPokemonType.equals(FIGHTING) || enemyPokemonType.equals(DRAGON)
                    || enemyPokemonType.equals(DARK);
        };
    }

    public boolean isWeakAgainst(ElementsType enemyPokemonType){
        return switch (this) {
            case NORMAL -> enemyPokemonType.equals(GHOST) || enemyPokemonType.equals(ROCK)
                    || enemyPokemonType.equals(STEEL);
            case FIGHTING -> enemyPokemonType.equals(FLYING) || enemyPokemonType.equals(PSYCHIC)
                    || enemyPokemonType.equals(FAIRY) || enemyPokemonType.equals(BUG) || enemyPokemonType.equals(POISON)
                    || enemyPokemonType.equals(GHOST);
            case FLYING -> enemyPokemonType.equals(ROCK) || enemyPokemonType.equals(ELECTRIC)
                    || enemyPokemonType.equals(STEEL);
            case POISON -> enemyPokemonType.equals(GROUND) || enemyPokemonType.equals(POISON)
                    || enemyPokemonType.equals(ROCK) || enemyPokemonType.equals(GHOST)
                    || enemyPokemonType.equals(STEEL);
            case GROUND -> enemyPokemonType.equals(FLYING) || enemyPokemonType.equals(GRASS)
                    || enemyPokemonType.equals(BUG);
            case ROCK -> enemyPokemonType.equals(FIGHTING) || enemyPokemonType.equals(GROUND)
                    || enemyPokemonType.equals(STEEL);
            case BUG -> enemyPokemonType.equals(FIGHTING) || enemyPokemonType.equals(FLYING)
                    || enemyPokemonType.equals(POISON) || enemyPokemonType.equals(GHOST)
                    || enemyPokemonType.equals(STEEL) || enemyPokemonType.equals(FAIRY) ||enemyPokemonType.equals(FIRE);
            case GHOST -> enemyPokemonType.equals(DARK) || enemyPokemonType.equals(NORMAL);
            case STEEL -> enemyPokemonType.equals(FIRE) || enemyPokemonType.equals(WATER)
                    || enemyPokemonType.equals(ELECTRIC) || enemyPokemonType.equals(STEEL);
            case FIRE -> enemyPokemonType.equals(WATER) || enemyPokemonType.equals(ROCK)
                    || enemyPokemonType.equals(FIRE) || enemyPokemonType.equals(DRAGON);
            case WATER -> enemyPokemonType.equals(GRASS) || enemyPokemonType.equals(DRAGON)
                    || enemyPokemonType.equals(WATER);
            case GRASS -> enemyPokemonType.equals(FLYING) || enemyPokemonType.equals(POISON)
                    || enemyPokemonType.equals(BUG) || enemyPokemonType.equals(STEEL) || enemyPokemonType.equals(FIRE)
                    || enemyPokemonType.equals(GRASS) || enemyPokemonType.equals(DRAGON);
            case ELECTRIC -> enemyPokemonType.equals(GROUND) || enemyPokemonType.equals(ELECTRIC)
                    || enemyPokemonType.equals(GRASS) || enemyPokemonType.equals(DRAGON);
            case PSYCHIC -> enemyPokemonType.equals(STEEL) || enemyPokemonType.equals(DARK)
                    || enemyPokemonType.equals(PSYCHIC);
            case ICE -> enemyPokemonType.equals(STEEL) || enemyPokemonType.equals(FIRE)
                    || enemyPokemonType.equals(WATER) || enemyPokemonType.equals(ICE);
            case DRAGON -> enemyPokemonType.equals(STEEL) || enemyPokemonType.equals(FAIRY);
            case DARK -> enemyPokemonType.equals(FIGHTING) || enemyPokemonType.equals(DARK)
                    || enemyPokemonType.equals(FAIRY);
            case FAIRY -> enemyPokemonType.equals(POISON) || enemyPokemonType.equals(STEEL)
                    || enemyPokemonType.equals(FIRE);
        };
    }
}
