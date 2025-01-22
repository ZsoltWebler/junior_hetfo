package java_io;

import java.util.Objects;

public class Book {
    private final String name;
    private final String author;
    private final double userRating;
    private final long reviews;
    private final int price;
    private final int year;
    private final Genre genre;

    public Book(String name, String author, double userRating, long reviews, int price, int year, Genre genre) {
        this.name = name;
        this.author = author;
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getUserRating() {
        return userRating;
    }

    public long getReviews() {
        return reviews;
    }

    public int getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", userRating=" + userRating +
                ", reviews=" + reviews +
                ", price=" + price +
                ", year=" + year +
                ", genre=" + genre +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.userRating, userRating) == 0 && reviews == book.reviews && price == book.price && year == book.year && Objects.equals(name, book.name) && Objects.equals(author, book.author) && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, userRating, reviews, price, year, genre);
    }
}
