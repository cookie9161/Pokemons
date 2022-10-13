package pokemons;

public enum ElementsType {
    ELECTRIC,
    FIRE,
    WATER,
    ROCK;

    public boolean isStrongAgainst(ElementsType enemyPokemonType){
        return switch (this) {
            case FIRE -> enemyPokemonType.equals(ROCK);
            case WATER -> enemyPokemonType.equals(FIRE);
            case ELECTRIC -> enemyPokemonType.equals(WATER);
            case ROCK -> enemyPokemonType.equals(ELECTRIC);
        };
    }

    public boolean isWeakAgainst(ElementsType enemyPokemonType){
        return switch (this) {
            case FIRE -> enemyPokemonType.equals(WATER);
            case WATER -> enemyPokemonType.equals(ELECTRIC);
            case ELECTRIC -> enemyPokemonType.equals(ROCK);
            case ROCK -> enemyPokemonType.equals(FIRE);
        };
    }
}
