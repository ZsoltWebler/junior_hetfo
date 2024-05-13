import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Song> songs = new ArrayList<>();

        songs.add(new Song("Bad Attitude", 240, "Deep Purple"));
        songs.add(new Song("Terraplane Blues", 300, "Eric Clapton"));
        songs.add(new Song("Crazy Country Hop", 320, "Eric Clapton"));


        Playlist playlist = new Playlist(songs);

        System.out.println(playlist.findByLengthGreaterThan(5));

        playlist.totalPlayTime();

        playlist.removeSong(new Song("Crazy Country Hop", 320, "Eric Clapton"));

        System.out.println(playlist);

        playlist.addSong(new Song("Crazy Country Hop", 320, "Eric Clapton"));

        System.out.println(playlist);

        new Song("Bad Attitude", 240, null);
    }
}