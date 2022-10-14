package me.cookie9161.pokemons.util;

import java.util.concurrent.ThreadLocalRandom;

public class RNG {

    private RNG() {
    }

    public static int getRandomNumberWithinRange(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
