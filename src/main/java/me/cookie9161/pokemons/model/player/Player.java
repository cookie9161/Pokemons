package me.cookie9161.pokemons.model.player;

import lombok.Getter;
import lombok.Setter;
import me.cookie9161.pokemons.model.pokemons.Pokemon;
import me.cookie9161.pokemons.repository.impl.InMemoryPlayerRepository;

import java.util.List;

@Setter
@Getter
public class Player {
    private static final InMemoryPlayerRepository PLAYER_REGISTRY = new InMemoryPlayerRepository();

    private final String name;
    private List<Pokemon> pokemons;

    private Player(String name) {
        this.name = name;
    }

    public static Player getOrCreatePlayer(String name) {
        return PLAYER_REGISTRY.getPlayer(name)
                .orElseGet(() -> {
                    Player player = new Player(name);
                    PLAYER_REGISTRY.addPlayer(player);
                    return player;
                });
    }
}
