package me.cookie9161.pokemons.pokemons;

public class Level extends Thread {
    private static final int MAX_LEVEL = 100;
    private static final int MIN_LEVEL = 1;
    public static final int[] EXPERIENCE_LEVELS = {
            1, 8, 27, 64, 125, 216, 343, 512, 729, 1000, 1331, 1728, 2197, 2744, 3375, 4096, 4913, 5832, 6859, 8000,
            9261, 10648, 12167, 13824, 15625, 17576, 19683, 21952, 24389, 27000, 29791, 32768, 35937, 39304, 42875,
            46656, 50653, 54872, 59319, 64000, 68921, 74088, 79507, 85184, 91125, 97336, 103823, 110592, 117649, 125000,
            132651, 140608, 148877, 157464, 166375, 175616, 185193, 195112, 205379, 216000, 226981, 238328, 250047,
            262144, 274625, 287496, 300763, 314432, 328509, 343000, 357911, 373248, 389017, 405224, 421875, 438976,
            456533, 474552, 493039, 512000, 531441, 551368, 571787, 592704, 614125, 636056, 658503, 681472, 704969,
            729000, 753571, 778688, 804357, 830584, 857375, 884736, 912673, 941192, 970299
    };

    @Override
    public void run() {
        super.run();
    }

    public static int getLevel(int experience) {
        int level = MIN_LEVEL;
        while (experience >= getExperienceForLevel(level)) {
            level++;
        }
        return level;
    }

    private static int getExperienceForLevel(int level) {
        if (level < MIN_LEVEL || level > MAX_LEVEL) {
            throw new IllegalArgumentException("Level must be between 1 and 100");
        }
        return EXPERIENCE_LEVELS[level - 1];
    }
}
