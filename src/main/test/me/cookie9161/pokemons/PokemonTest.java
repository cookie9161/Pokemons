//package me.cookie9161.pokemons;
//
//import me.cookie9161.pokemons.model.pokemons.Attack;
//import me.cookie9161.pokemons.model.pokemons.ElementsType;
//import me.cookie9161.pokemons.model.pokemons.Pokemon;
//import me.cookie9161.pokemons.model.potion.Potion;
//import me.cookie9161.pokemons.model.potion.PotionType;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.List;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class PokemonTest {
//
//    private Pokemon testeePokemon;
//    private Pokemon testeePokemon2;
//    private Potion mockSmallHealPotion;
//
//    @BeforeEach
//    public void setUp() {
//        Attack testAttack = new Attack("Lol", ElementsType.ELECTRIC, 5, 90);
//
//        testeePokemon = new Pokemon("Pikachu", ElementsType.ELECTRIC, 100, 100, List.of(testAttack));
//        testeePokemon2 = new Pokemon("Pikachu", ElementsType.ELECTRIC, 100, 100, null);
//
//        mockSmallHealPotion = new Potion(PotionType.SMALL_HEAL);
//    }
//
//    @Test
//    public void attack_reductionOfHp() {
//        //GIVEN
//        final int hpAtTheBeginning = testeePokemon2.getHp();
//
//        //WHEN
//        testeePokemon.attack(testeePokemon.getPokemonAttacks().get(0), testeePokemon2);
//        int hpAfterFirstAttack = testeePokemon2.getHp();
//
//        testeePokemon.attack(testeePokemon.getPokemonAttacks().get(0), testeePokemon2);
//        int hpAfterSecondAttack = testeePokemon2.getHp();
//
//        //THEN
//        // equals in case attack missed
//        assertThat(hpAfterFirstAttack <= hpAtTheBeginning).isTrue();
//        assertThat(hpAfterSecondAttack <= hpAfterFirstAttack).isTrue();
//    }
//
//    @Test
//    public void heal_increaseOfHpViaSmallPotion() {
//        //GIVEN
//        final int hpAtTheBeginning = testeePokemon.getMaxHp();
//        final int healValue = mockSmallHealPotion.getPotionType().getHpIncreaseAmount();
//        final int attackValue = 30;
//
//        //WHEN
//        testeePokemon.setHp(hpAtTheBeginning - attackValue);
//        final int pokemonHpAfterAttack = testeePokemon.getHp();
//        testeePokemon.heal(healValue);
//        final int pokemonHpAfterHeal = testeePokemon.getHp();
//
//        //THEN
//        assertThat(pokemonHpAfterHeal == pokemonHpAfterAttack + healValue).isTrue();
//    }
//
//    @Test
//    public void heal_knockedDownPokemon() {
//        //GIVEN
//        final int healValue = mockSmallHealPotion.getPotionType().getHpIncreaseAmount();
//        int pokemonHpAfterHeal;
//
//        //WHEN
//        testeePokemon.setHp(0);
//        testeePokemon.heal(healValue);
//        pokemonHpAfterHeal = testeePokemon.getHp();
//
//        //THEN
//        assertThat(pokemonHpAfterHeal > 0).isFalse();
//        assertThat(pokemonHpAfterHeal == 0).isTrue();
//    }
//}
