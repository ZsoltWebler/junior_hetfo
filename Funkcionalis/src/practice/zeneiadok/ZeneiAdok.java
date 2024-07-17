package practice.zeneiadok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ZeneiAdok {
    public static void main(String[] args) {


        Map<Integer, List<Song>> integerListMap = readModel();


       integerListMap.entrySet().stream().map(integerListEntry -> {
            return new Radio(integerListEntry.getKey(), integerListEntry.getValue());
        }).forEach(radio -> {
           System.out.println(radio.getRadioId() + " Total playtime: " + radio.getTotalPlayTime() + " minutes");
           System.out.println(radio.getRadioId() + " Song count : " + radio.songCount() + " ");
           System.out.println(radio.getRadioId() + " Longest song : " + radio.longestSong() + " ");
           System.out.println(radio.getRadioId() + " Shorest song : " + radio.shortestSong() + " ");
           System.out.println(radio.getRadioId() + " Most played artist : " + radio.mostPlayedArtist() + " ");
           System.out.println(radio.getRadioId() + " Played at 0:7 : " + radio.playedAt(0,7) + " ");
           System.out.println(radio.getRadioId() + " Played by Frank Zappa: " + radio.playedByArtist("Frank Zappa") + " ");
               }
       );


    }

    private static Map<Integer,List<Song>> readModel() {

        Map<Integer,List<Song>> songs = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File("W:\\Webler\\Materials\\Git\\junior_hetfo\\junior_hetfo\\Funkcionalis\\src\\practice\\zeneiadok\\musor.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(" ",4);

                String[] artistAndTitle = values[3].split(":");
                Song song = new Song(Integer.parseInt(values[1]), Integer.parseInt(values[2]), artistAndTitle[0], artistAndTitle[1]);

                if(!songs.containsKey(Integer.parseInt(values[0]))){
                    songs.put(Integer.parseInt(values[0]),new ArrayList<>());
                }
                songs.get(Integer.parseInt(values[0])).add(song);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return songs;
    }

}
