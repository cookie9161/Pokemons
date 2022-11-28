package me.cookie9161.pokemons.repository;

import me.cookie9161.pokemons.model.player.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SQLPlayerRepository extends CrudRepository<Player, Long> {
}
