package practice.zeneiadok;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Radio {

    private final int radioId;
    private final List<Song> songs;

    public Radio(int radioId, List<Song> songs) {
        this.radioId = radioId;
        this.songs = songs;
    }

    public int getRadioId() {
        return radioId;
    }

    public List<Song> getSongs() {
        return songs;
    }


    public long getTotalPlayTime() {

        return songs.stream().collect(Collectors.summingLong(Song::getPlayTimeInSeconds)) / 60L;
    }

    public long songCount() {
        return songs.size();

    }

    public Song longestSong() {
        return songs.stream().max(Comparator.comparingLong(Song::getPlayTimeInSeconds)).orElseThrow();
    }

    public Song shortestSong() {
        return songs.stream().min(Comparator.comparingLong(Song::getPlayTimeInSeconds)).orElseThrow();
    }

    public String mostPlayedArtist() {

        Map<String, Long> collect = songs
                .stream()
                .collect(Collectors.groupingBy(Song::getArtist, Collectors.counting()));

        return songs
                .stream()
                .collect(Collectors.groupingBy(Song::getArtist, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }

    public Song playedAt(int hour, int minutes) {

        long playAtInSeconds = hour * 3600L + minutes * 60L;

        long sumSongTime = 0;
        for(Song song: songs){

            sumSongTime+=song.getPlayTimeInSeconds();
            if(sumSongTime>=playAtInSeconds){
                return song;
            }

        }
        return null;

    }

    public List<Song> playedByArtist(String artist){

        return songs.stream().filter(song -> song.getArtist().equals(artist)).toList();


    }


    @Override
    public String toString() {
        return "Radio{" +
                "radioId=" + radioId +
                ", songs=" + songs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Radio radio = (Radio) o;
        return radioId == radio.radioId && Objects.equals(songs, radio.songs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radioId, songs);
    }
}
