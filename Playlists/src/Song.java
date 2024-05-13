import java.util.Objects;

public class Song {

    private String name;
    private long lengthInSeconds;
    private String artist;


    public Song(String name, long lengthInSeconds, String artist) {
        checkParameters(name, lengthInSeconds, artist);
        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    private void checkParameters(String name, long lengthInSeconds, String artist) {
        if ((name == null || name.isBlank()) || (artist == null || artist.isBlank()) || lengthInSeconds <= 0) {
            throw new RuntimeException();
        }
    }

    public String getName() {
        return name;
    }

    public long getLengthInSeconds() {
        return lengthInSeconds;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", lengthInSeconds=" + lengthInSeconds +
                ", artist='" + artist + '\'' +
                '}';
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
}
