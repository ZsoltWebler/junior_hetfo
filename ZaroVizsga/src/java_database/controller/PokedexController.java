package java_database.controller;

import java_database.model.PokemonDao;
import java_database.repository.PokemonRepository;
import java_database.view.Pokedex;

public class PokedexController {


    public PokedexController(){
        PokemonRepository pokemonRepository = new PokemonRepository();

        Pokedex pokedex = new Pokedex(pokemonRepository);
        pokedex.setVisible(true);
    }



}
