package practice.zeneiadok;

import java.util.Objects;

public class Song {

    private final int minutes;
    private final int seconds;
    private final String artist;
    private final String title;

    public Song(int minutes, int seconds, String artist, String title) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.artist = artist;
        this.title = title;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public long getPlayTimeInSeconds() {
        return minutes * 60 + seconds;
    }

    @Override
    public String toString() {
        return "Song{" +
                "minutes=" + minutes +
                ", seconds=" + seconds +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return minutes == song.minutes && seconds == song.seconds && Objects.equals(artist, song.artist) && Objects.equals(title, song.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, seconds, artist, title);
    }
}
