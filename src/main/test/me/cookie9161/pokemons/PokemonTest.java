package me.cookie9161.pokemons;

import me.cookie9161.pokemons.model.pokemons.Attack;
import me.cookie9161.pokemons.model.pokemons.ElementsType;
import me.cookie9161.pokemons.model.pokemons.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class PokemonTest {

    private Pokemon testeePokemon;
    private Pokemon testeePokemon2;

    @BeforeEach
    public void setUp() {
        testeePokemon = new Pokemon("Pikachu", ElementsType.ELECTRIC, 100, 100, List.of(new Attack("Lol", ElementsType.ELECTRIC, 5, 90)));
        testeePokemon2 = new Pokemon("Pikachu", ElementsType.ELECTRIC, 100, 100, null);
    }

    @Test
    public void attack_reductionOfHp() {
        //GIVEN
        final int hpAtTheBeginning = testeePokemon2.getHp();

        //WHEN
        testeePokemon.attack(testeePokemon.getPokemonAttacks().get(0), testeePokemon2);
        int hpAfterFirstAttack = testeePokemon2.getHp();

        testeePokemon.attack(testeePokemon2.getPokemonAttacks().get(0), testeePokemon2);
        int hpAfterSecondAttack = testeePokemon2.getHp();

        //THEN
        // equals in case attack missed
        assertThat(hpAfterFirstAttack <= hpAtTheBeginning).isTrue();
        assertThat(hpAfterSecondAttack <= hpAfterFirstAttack).isTrue();
    }
}
