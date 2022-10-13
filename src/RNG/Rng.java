package RNG;

public class Rng {
    public static int getARoll(int min, int max) {
        return (int) Math.ceil(Math.random() * (max - min + 1) + min);
    }
}
