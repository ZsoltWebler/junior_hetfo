package java_collections.tests;

import java_collections.Pokedex;
import java_collections.Pokemon;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PokedexTest {


    @Test
    void getPokemonByNameReturnsCorrectPokemon() {
        Pokedex pokedex = new Pokedex();
        Pokemon pikachu = pokedex.getPokemonByName("Bulbasaur");
        assertEquals("Bulbasaur", pikachu.getName());
    }

    @Test
    void getPokemonByNameThrowsExceptionIfNotFound() {
        Pokedex pokedex = new Pokedex();
        assertThrows(NoSuchElementException.class, () -> pokedex.getPokemonByName("Unknown"));
    }

    @Test
    void findStrongestPokemonReturnsCorrectPokemon() {
        Pokedex pokedex = new Pokedex();
        Pokemon strongest = pokedex.findStrongestPokemon();
        assertEquals("CharizardMega Charizard X", strongest.getName());
    }

    @Test
    void findWeakestPokemonReturnsCorrectPokemon() {
        Pokedex pokedex = new Pokedex();
        Pokemon weakest = pokedex.findWeakestPokemon();
        assertEquals("Caterpie", weakest.getName());
    }

    @Test
    void getAllPokemonWithoutSecondTypeReturnsCorrectList() {
        throw new UnsupportedOperationException();
    }

    @Test
    void getAllPokemonByMainTypeReturnsCorrectList() {
        throw new UnsupportedOperationException();
    }

    @Test
    void getAllPokemonGroupedByMainTypeReturnsCorrectMap() {
        throw new UnsupportedOperationException();
    }


}
