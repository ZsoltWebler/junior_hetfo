package java_oop.tests;

import java_oop.Ingredient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientTest {
    @Test
    void constructorInitializesFieldsCorrectly() {
        Ingredient ingredient = new Ingredient("Sugar", 100, 50);
        assertEquals("Sugar", ingredient.getName());
        assertEquals(100, ingredient.getCalories());
        assertEquals(50, ingredient.getWeight());
    }

    @Test
    void constructorSetsCaloriesToZeroIfNegative() {
        Ingredient ingredient = new Ingredient("Sugar", -10, 50);
        assertEquals(0, ingredient.getCalories());
    }

    @Test
    void constructorSetsWeightToZeroIfNegative() {
        Ingredient ingredient = new Ingredient("Sugar", 100, -20);
        assertEquals(0, ingredient.getWeight());
    }
}
