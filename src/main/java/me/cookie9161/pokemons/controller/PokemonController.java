package me.cookie9161.pokemons.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.cookie9161.pokemons.model.pokemons.Pokemon;
import me.cookie9161.pokemons.advice.PokemonNotFoundException;
import me.cookie9161.pokemons.service.PokemonService;
import me.cookie9161.pokemons.util.Messages;
import org.springframework.hateoas.CollectionModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController  {
    private final PokemonService pokemonService;

    @GetMapping("/pokemons/{name}")
    public EntityModel<Pokemon> getPokemonByName(@PathVariable("name") String name) throws PokemonNotFoundException {
        log.info("Searching for pokemon {}", name);

        Pokemon pokemon = pokemonService.getPokemon(name)
                .orElseThrow(() -> new PokemonNotFoundException(name));

        log.info("Pokemon {} has been found", pokemon.getName());
        return EntityModel.of(pokemon,
                linkTo(methodOn(PokemonController.class)
                        .getPokemonByName(pokemon.getName()))
                        .withSelfRel(),
                linkTo(methodOn(PokemonController.class)
                        .all())
                        .withRel("pokemons")
                );
        //return ResponseEntity.of(resultPokemon);
    }

    @GetMapping("/id/{id}")
    public EntityModel<Pokemon> getPokemonById(@PathVariable("id") Long id) throws PokemonNotFoundException{
        log.info("Searching for pokemon with id: {}",id);

        Pokemon pokemon = pokemonService.getPokemon(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));

        log.info("Found pokemon by id {}", id);

        return EntityModel.of(pokemon,
                linkTo(methodOn(PokemonController.class)
                        .getPokemonById(pokemon.getId()))
                        .withSelfRel(),
                linkTo(methodOn(PokemonController.class)
                        .all())
                        .withRel("pokemons"));

//        return ResponseEntity.of(resultPokemon);
    }

    @GetMapping("/pokemons")
    public CollectionModel<EntityModel<Pokemon>> all() {
        log.info("Searching for all pokemons");
        List<EntityModel<Pokemon>> pokemons = pokemonService.getAllPokemons()
                .stream()
                .map(pokemon -> {
                    try {
                        return EntityModel.of(pokemon,
                                linkTo(methodOn(PokemonController.class)
                                        .getPokemonById(pokemon.getId()))
                                        .withSelfRel(),
                                linkTo(methodOn(PokemonController.class)
                                        .all())
                                        .withRel("pokemons"));
                    } catch (PokemonNotFoundException exception) {
                        throw new RuntimeException(exception);
                    }
                })
                .toList();
        return CollectionModel.of(pokemons, linkTo(methodOn(PokemonController.class).all()).withSelfRel());
    }

    @PostMapping("/create")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        Optional<Pokemon> pokemonNameToCheck = pokemonService.getPokemon(pokemon.getName());
        if (pokemonNameToCheck.isPresent()){
            log.warn(Messages.POKEMON_NAME_ALREADY_DEFINED, pokemonNameToCheck.get().getName(), pokemonNameToCheck.get().getId());
            return ResponseEntity.of(pokemonNameToCheck);
        }

        Optional<Pokemon> pokemonIdToCheck = pokemonService.getPokemon(pokemon.getId());
        if (pokemonIdToCheck.isPresent()){
            log.warn(Messages.POKEMON_ID_ALREADY_EXISTS, pokemonIdToCheck.get().getId(), pokemonIdToCheck.get().getName());
            return ResponseEntity.of(pokemonIdToCheck);
        }

        Pokemon createdPokemon = pokemonService.createPokemon(pokemon);
        log.info(Messages.CREATING_POKEMON, createdPokemon.getName(), createdPokemon.getId());
        return ResponseEntity.created(URI.create("/" + createdPokemon.getId())).body(createdPokemon);
    }
}
