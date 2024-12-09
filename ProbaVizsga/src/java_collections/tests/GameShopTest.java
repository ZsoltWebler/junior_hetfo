package java_collections.tests;

import java_collections.Developer;
import java_collections.Game;
import java_collections.GameDatabase;
import java_collections.GameShop;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShopTest {

    private final List<Game> games = new GameDatabase().getGames();
    private final GameShop gameShop = new GameShop(games);

    @Test
    public void testListOfDistinctDevelopers() {

        List<Developer> actual = gameShop.listOfDistinctDevelopers();

        assertEquals(57, actual.size());
        assertEquals(new HashSet<>(actual).size(), actual.size());

    }


    @Test
    public void testDeveloperWithMostGame() {
        Developer actual = gameShop.developerWithMostGame();
        Developer expected = new Developer("Dark Water Studios Ltd");

        assertEquals(expected, actual);
    }


}
