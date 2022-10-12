package Pokemons;

public enum Type {
    ELECTRIC{
        public boolean strongAgainst(Type other){
            return other == WATER;
        }
    },
    FIRE{
        public boolean strongAgainst(Type other){
            return other == ROCK;
        }
    },
    WATER{
        public boolean strongAgainst(Type other){
            return other == FIRE;
        }
    },
    ROCK{
        public boolean strongAgainst(Type other){
            return other == ELECTRIC;
        }
    }
}
