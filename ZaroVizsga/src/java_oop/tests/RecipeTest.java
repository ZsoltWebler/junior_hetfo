package java_oop.tests;

import java_oop.Ingredient;
import java_oop.Recipe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeTest {

    @Test
    void constructorInitializesFieldsCorrectly() {
        Recipe recipe = new Recipe("Cake", 4);
        assertEquals("Cake", recipe.getName());
        assertEquals(4, recipe.getServings());
        assertTrue(recipe.getIngredients().isEmpty());
    }

    @Test
    void constructorSetsServingsToOneIfNegative() {
        Recipe recipe = new Recipe("Cake", -2);
        assertEquals(1, recipe.getServings());
    }

    @Test
    void addIngredientAddsNonNullIngredient() {
        Recipe recipe = new Recipe("Cake", 4);
        Ingredient ingredient = new Ingredient("Sugar", 100, 50);
        recipe.addIngredient(ingredient);
        assertEquals(1, recipe.getIngredients().size());
        assertEquals(ingredient, recipe.getIngredients().get(0));
    }

    @Test
    void addIngredientDoesNotAddNullIngredient() {
        Recipe recipe = new Recipe("Cake", 4);
        recipe.addIngredient(null);
        assertTrue(recipe.getIngredients().isEmpty());
    }

    @Test
    void calculateTotalCaloriesReturnsCorrectValue() {
        throw new UnsupportedOperationException();
    }

    @Test
    void calculateCaloriesPerServingReturnsCorrectValue() {
        throw new UnsupportedOperationException();
    }

}
