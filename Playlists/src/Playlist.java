import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist {

    private final List<Song> songList;

    public Playlist(List<Song> songList) {
        this.songList = songList;
    }

    public boolean addSong(Song song) {
        return songList.add(song);
    }

    public boolean removeSong(Song song) {
        return songList.remove(song);
    }

    public List<Song> findByLengthGreaterThan(int minute) {

        List<Song> songs = new ArrayList<>();

        for (Song song : songList) {
            if (song.getLengthInSeconds() > minute * 60L) {
                songs.add(song);
            }
        }
        return songs;
    }

    public void totalPlayTime() {

        long totalPlayTimeInSec = 0;

        for (Song song : songList) {
            totalPlayTimeInSec += song.getLengthInSeconds();
        }

        long minute = totalPlayTimeInSec / 60;
        long seconds = totalPlayTimeInSec - (minute * 60L);

        System.out.println("TotalPlayTime: " + minute + " min, " + seconds + " seconds.");
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songList=" + songList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(songList, playlist.songList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songList);
    }
}
