package me.cookie9161.pokemons.model.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.cookie9161.pokemons.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "player")
public class Player extends BaseEntity {
    private String name;
}