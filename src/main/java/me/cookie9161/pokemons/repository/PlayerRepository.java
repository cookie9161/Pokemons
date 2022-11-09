package me.cookie9161.pokemons.repository;

import com.google.common.collect.ImmutableSet;
import me.cookie9161.pokemons.model.player.Player;

import java.util.Optional;

public interface PlayerRepository {
    void addPlayer(Player player);
    void removePlayer(Player player);
    ImmutableSet<Player> getPlayers();
    Optional<Player> getPlayer(String name);
}
