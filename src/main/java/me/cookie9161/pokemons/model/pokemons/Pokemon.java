package me.cookie9161.pokemons.model.pokemons;



import lombok.*;
import lombok.extern.slf4j.Slf4j;
import me.cookie9161.pokemons.model.BaseEntity;
import me.cookie9161.pokemons.model.potion.Potion;
import me.cookie9161.pokemons.model.potion.PotionType;
import me.cookie9161.pokemons.util.Messages;
import me.cookie9161.pokemons.util.RNG;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pokemon")
public class Pokemon extends BaseEntity {
//    private static final double RNG_DEVIATION = 0.15;
//    private static final double WEAK_ATTACK_MULTIPLIER = 0.5;
//    private static final double STRONG_ATTACK_MULTIPLIER = 1.25;

    private String name;
//    private final ElementsType type;
//
//    private int hp;
//    private int basePokemonPower;
//    private int experience;
//    private int maxHp;
//    private int level;

    //TODO maybe add luck to constructor?
//    public Pokemon(String name) {
//        this.name = name;
//        this.type = elementsType;
//        this.hp = Math.max(hp, 1);
//        this.basePokemonPower = Math.max(basePokemonPower, 1);
//        this.experience = 0;
//        this.maxHp = hp;
//        this.pokemonAttacks = pokemonAttacks;
//        this.level = Level.getLevel(experience);
//    }


}