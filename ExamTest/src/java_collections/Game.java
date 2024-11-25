package java_collections;

import java.util.List;
import java.util.Objects;

public class Game {

    private final String name;
    private final double price;
    private final int positiveReviewCount;
    private final int negativeReviewCount;
    private final Developer developer;
    private final List<Genre> genres;

    public Game(String name, double price, int positiveReviewCount, int negativeReviewCount, Developer developer, List<Genre> genres) {
        this.name = name;
        this.price = price;
        this.positiveReviewCount = positiveReviewCount;
        this.negativeReviewCount = negativeReviewCount;
        this.developer = developer;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPositiveReviewCount() {
        return positiveReviewCount;
    }

    public int getNegativeReviewCount() {
        return negativeReviewCount;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Double.compare(game.price, price) == 0 && positiveReviewCount == game.positiveReviewCount && negativeReviewCount == game.negativeReviewCount && Objects.equals(name, game.name) && Objects.equals(developer, game.developer) && Objects.equals(genres, game.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, positiveReviewCount, negativeReviewCount, developer, genres);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", positiveReviewCount=" + positiveReviewCount +
                ", negativeReviewCount=" + negativeReviewCount +
                ", developer=" + developer +
                ", genres=" + genres +
                '}';
    }
}