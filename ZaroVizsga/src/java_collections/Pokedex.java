package java_collections;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pokedex {

    private final List<Pokemon> pokemons = PokemonDatabase.getPokemons();

    public final Pokemon getPokemonByName(String name) {
        return pokemons.stream().filter(pokemon -> pokemon.getType2().equals(name)).findFirst().orElseThrow();
    }

    public final Pokemon findStrongestPokemon() {
        return pokemons.stream().min(Comparator.comparingInt(Pokemon::getTotal)).orElseThrow();
    }

    public final Pokemon findWeakestPokemon() {
        return pokemons.stream().min(Comparator.comparingInt(Pokemon::getTotal)).orElseThrow();
    }

    public final List<Pokemon> getAllPokemonWithoutSecondType() {
        throw new UnsupportedOperationException();
    }

    public final List<Pokemon> getAllPokemonByMainType(String type) {
        throw new UnsupportedOperationException();    }

    public final Map<String, List<Pokemon>> getAllPokemonGroupedByMainType() {
        throw new UnsupportedOperationException();    }


}


