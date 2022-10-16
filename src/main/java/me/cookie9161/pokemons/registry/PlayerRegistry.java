package me.cookie9161.pokemons.registry;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import me.cookie9161.pokemons.model.player.Player;

import java.util.Optional;
import java.util.Set;

public class PlayerRegistry {
    private final Set<Player> players;

    public PlayerRegistry() {
        this.players = Sets.newHashSet();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public ImmutableSet<Player> getPlayers () {
        return ImmutableSet.copyOf(players);
    }

    public Optional<Player> getPlayer(String name) {
        return players.stream()
                .filter(player -> player.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
