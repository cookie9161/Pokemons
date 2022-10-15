package me.cookie9161.pokemons.player;

import lombok.Getter;
import lombok.Setter;
import me.cookie9161.pokemons.pokemons.Pokemon;
import me.cookie9161.pokemons.pokemons.PokemonRegistry;

import java.util.List;

@Setter
@Getter
public class Player {
    private static final PlayerRegistry playerRegistry = new PlayerRegistry();

    private final String name;
    private List<Pokemon> pokemons;


    private Player(String name) {
        this.name = name;
    }

    public static Player getOrCreatePlayer(String name) {
        return playerRegistry.getPlayer(name)
                .orElseGet(() -> {
                    Player player = new Player(name);
                    playerRegistry.addPlayer(player);
                    return player;
                });
    }
}
