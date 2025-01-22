package java_collections;

import java.util.ArrayList;
import java.util.List;

public final class PokemonDatabase {

    private static final List<Pokemon> pokemons = new ArrayList<>(List.of(

            new Pokemon(1, "Bulbasaur", "Grass", "Poison", 318, 45, 49, 49, 65, 65, 45),
            new Pokemon(2, "Ivysaur", "Grass", "Poison", 405, 60, 62, 63, 80, 80, 60),
            new Pokemon(3, "Venusaur", "Grass", "Poison", 525, 80, 82, 83, 100, 100, 80),
            new Pokemon(3, "VenusaurMega Venusaur", "Grass", "Poison", 625, 80, 100, 123, 122, 120, 80),
            new Pokemon(4, "Charmander", "Fire", null, 309, 39, 52, 43, 60, 50, 65),
            new Pokemon(5, "Charmeleon", "Fire", null, 405, 58, 64, 58, 80, 65, 80),
            new Pokemon(6, "Charizard", "Fire", "Flying", 534, 78, 84, 78, 109, 85, 100),
            new Pokemon(6, "CharizardMega Charizard X", "Fire", "Dragon", 634, 78, 130, 111, 130, 85, 100),
            new Pokemon(6, "CharizardMega Charizard Y", "Fire", "Flying", 634, 78, 104, 78, 159, 115, 100),
            new Pokemon(7, "Squirtle", "Water", null, 314, 44, 48, 65, 50, 64, 43),
            new Pokemon(8, "Wartortle", "Water", null, 405, 59, 63, 80, 65, 80, 58),
            new Pokemon(9, "Blastoise", "Water", null, 530, 79, 83, 100, 85, 105, 78),
            new Pokemon(9, "BlastoiseMega Blastoise", "Water", null, 630, 79, 103, 120, 135, 115, 78),
            new Pokemon(10, "Caterpie", "Bug", null, 195, 45, 30, 35, 20, 20, 45),
            new Pokemon(11, "Metapod", "Bug", null, 205, 50, 20, 55, 25, 25, 30),
            new Pokemon(12, "Butterfree", "Bug", "Flying", 395, 60, 45, 50, 90, 80, 70),
            new Pokemon(13, "Weedle", "Bug", "Poison", 195, 40, 35, 30, 20, 20, 50),
            new Pokemon(14, "Kakuna", "Bug", "Poison", 205, 45, 25, 50, 25, 25, 35),
            new Pokemon(15, "Beedrill", "Bug", "Poison", 395, 65, 90, 40, 45, 80, 75),
            new Pokemon(15, "BeedrillMega Beedrill", "Bug", "Poison", 495, 65, 150, 40, 15, 80, 145),
            new Pokemon(16, "Pidgey", "Normal", "Flying", 251, 40, 45, 40, 35, 35, 56),
            new Pokemon(17, "Pidgeotto", "Normal", "Flying", 349, 63, 60, 55, 50, 50, 71),
            new Pokemon(18, "Pidgeot", "Normal", "Flying", 479, 83, 80, 75, 70, 70, 101),
            new Pokemon(18, "PidgeotMega Pidgeot", "Normal", "Flying", 579, 83, 80, 80, 135, 80, 121),
            new Pokemon(19, "Rattata", "Normal", null, 253, 30, 56, 35, 25, 35, 72),
            new Pokemon(20, "Raticate", "Normal", null, 413, 55, 81, 60, 50, 70, 97)));


    public static List<Pokemon> getPokemons(){
        return pokemons;
    }

}


