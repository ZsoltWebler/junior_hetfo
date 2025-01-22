package java_oop;

public class Ingredient {
    private String name;
    private int calories;
    private int weight;

    public Ingredient(String name, int calories, int weight) {
        this.name = name;
        this.calories = Math.max(1, calories);
        this.weight = Math.min(0, weight);
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", weight=" + weight +
                '}';
    }
}