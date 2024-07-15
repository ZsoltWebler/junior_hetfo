
import java.util.Objects;

public class Movie {

    private final int rank;
    private final int releaseYear;
    private final String duration;
    private final String ageLimit;
    private final double imdbRating;
    private final int metaScore;
    private final String description;
    private final String name;


    public Movie(int rank, int releaseYear, String duration, String ageLimit, double imdbRating, int metaScore,
                 String description, String name) {
        super();
        this.rank = rank;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.ageLimit = ageLimit;
        this.imdbRating = imdbRating;
        this.metaScore = metaScore;
        this.description = description;
        this.name = name;
    }


    public int getRank() {
        return rank;
    }


    public int getReleaseYear() {
        return releaseYear;
    }


    public String getDuration() {
        return duration;
    }


    public String getAgeLimit() {
        return ageLimit;
    }


    public double getImdbRating() {
        return imdbRating;
    }


    public int getMetaScore() {
        return metaScore;
    }


    public String getDescription() {
        return description;
    }


    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Movie [rank=" + rank + ", releaseYear=" + releaseYear + ", duration=" + duration + ", ageLimit="
                + ageLimit + ", imdbRating=" + imdbRating + ", metaScore=" + metaScore + ", description=" + description
                + ", name=" + name + "]";
    }


    @Override
    public int hashCode() {
        return Objects.hash(ageLimit, description, duration, imdbRating, metaScore, name, rank, releaseYear);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        return Objects.equals(ageLimit, other.ageLimit) && Objects.equals(description, other.description)
                && Objects.equals(duration, other.duration)
                && Double.doubleToLongBits(imdbRating) == Double.doubleToLongBits(other.imdbRating)
                && metaScore == other.metaScore && Objects.equals(name, other.name) && rank == other.rank
                && releaseYear == other.releaseYear;
    }





}

