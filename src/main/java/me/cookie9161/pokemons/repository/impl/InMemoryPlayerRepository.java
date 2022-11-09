package me.cookie9161.pokemons.repository.impl;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import me.cookie9161.pokemons.model.player.Player;
import me.cookie9161.pokemons.repository.PlayerRepository;

import java.util.Optional;
import java.util.Set;

public class InMemoryPlayerRepository implements PlayerRepository {
    private final Set<Player> players;

    public InMemoryPlayerRepository() {
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
