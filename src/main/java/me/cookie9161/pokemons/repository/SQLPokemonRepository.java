package me.cookie9161.pokemons.repository;

import me.cookie9161.pokemons.model.pokemons.Pokemon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("pokemonRepository")
public interface SQLPokemonRepository extends CrudRepository<Pokemon, Long> {
    Pokemon findByName(String name);
    List<Pokemon> findAll();

    @Override
    @Query(nativeQuery = true, value = "SELECT COUNT(*) > 0 FROM pokemon WHERE id=:id")
    boolean existsById(@Param("id") final Long id);
}
