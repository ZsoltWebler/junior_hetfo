import java.util.Objects;

public class Song {
    private final String name;
    private final long lengthInSeconds;
    private final String artist;

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    public Song(String name, long lengthInSeconds, String artist) {
        if (name == null || artist == null || lengthInSeconds < 1) {
            throw new RuntimeException();
        }
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return lengthInSeconds == song.lengthInSeconds && Objects.equals(name, song.name) && Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lengthInSeconds, artist);
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", lengthInSeconds=" + lengthInSeconds +
                ", artist='" + artist + '\'' +
                '}';
    }
}
