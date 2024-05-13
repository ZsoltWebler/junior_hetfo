import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist {
    private final List<Song> songs;

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song remove) {
        for (Song song : songs) {
            if (song.equals(remove)) {
                songs.remove(remove);
            }
        }
    }

    public List<Song> findByLengthGreaterThan(int mins) {
        long lenghtInSeconds = mins * 60;
        List<Song> songsLonger = new ArrayList<>();
        for (Song song : songs) {
            if (song.getLengthInSeconds() > lenghtInSeconds) {
                songsLonger.add(song);
            }
        }
        return songsLonger;
    }

    public void totalPlaytime() {
        long totalLenght = 0;
        for (Song song : songs) {
            totalLenght += song.getLengthInSeconds();
        }
        long minuteCount = 0;
        for (long i = 0; i == totalLenght; i++) {
            if(i%60 == 0){
                minuteCount += 1;
            }
        }
        long remainingSeconds = totalLenght - minuteCount*60;
        System.out.println("Total playtime: "+ minuteCount +" mins, " + remainingSeconds + "seconds");
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songs=" + songs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songs);
    }
}
