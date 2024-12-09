package java_oop.tests;

import java_oop.Character;
import java_oop.Item;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CharacterTest {


    @Test
    public void doAttackTest() {
        Character character = new Character(10,10,10, Set.of(
                new Item(5,5,5),
                new Item(5,5,10),
                new Item(5,5,15)
        ));

        assertEquals(25,character.doAttack());
    }

    @Test
    public void doMagicTest() {
        fail();
    }


}
