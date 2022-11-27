package me.cookie9161.pokemons.model.potion;

public enum PotionType {
    SMALL_HEAL ("Small heal", 15),
    BIG_HEAL ("Big heal", 45),
    REVIVE ("Revive", 10);

    private final String healPotionName;
    private final int hpIncreaseAmount;

    PotionType(String healPotionName, int hpIncreaseAmount) {
        this.healPotionName = healPotionName;
        this.hpIncreaseAmount = hpIncreaseAmount;
    }

    public String getHealPotionName() {
        return healPotionName;
    }

    public int getHpIncreaseAmount() {
        return hpIncreaseAmount;
    }
}
