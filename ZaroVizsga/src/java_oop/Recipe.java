package java_oop;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private int servings;

    public Recipe(String name, int servings) {
        this.name = name;
        this.servings = Math.max(1, servings);
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredient != null) {
            ingredients.add(ingredient);
        }
    }

    public int calculateTotalCalories() {
        throw new UnsupportedOperationException();
    }

    public int calculateCaloriesPerServing() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public int getServings() {
        return servings;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Recipe: ").append(name).append("\n");
        result.append("Servings: ").append(servings).append("\n");
        result.append("Ingredients:\n");
        for (Ingredient ingredient : ingredients) {
            result.append("- ").append(ingredient.toString()).append("\n");
        }
        result.append("Total Calories: ").append(calculateTotalCalories()).append(", Calories per Serving: ").append(calculateCaloriesPerServing());
        return result.toString();
    }
}
