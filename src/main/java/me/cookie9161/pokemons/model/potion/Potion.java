package me.cookie9161.pokemons.model.potion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Potion {
    private final PotionType potionType;

    public Potion(PotionType potionType) {
        this.potionType = potionType;
    }
}
