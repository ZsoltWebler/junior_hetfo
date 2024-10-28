package emitter;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<EmitterInfo> emitterInfos = readModel(new File("src/emitter/jel.txt"));
        System.out.print("2. feladat\n" +
                "Adja meg a jel sorszámát!");

        int line = readLine();

        if (line < 0 || line > emitterInfos.size()) {
            throw new IllegalArgumentException("Line number is invalid!");
        }

        System.out.println(emitterInfos.get(line - 1).getCoordinate());

        System.out.println(ellapsedIsSeconds(LocalTime.of(6, 30, 23), LocalTime.of(7, 31, 24)));

        ellapsed(emitterInfos.get(0).getTimestamp(), emitterInfos.get(emitterInfos.size() - 1).getTimestamp());

        rectangleHull(emitterInfos);

        System.out.println(travelledPath(emitterInfos));
    }

    public static double travelledPath(List<EmitterInfo> emitterInfos){

        double path = 0;

        EmitterInfo prev = null;
        for(EmitterInfo emitterInfo: emitterInfos){
            if(prev != null){

                path += Coordinate.distance(prev.getCoordinate(),emitterInfo.getCoordinate());

            }
            prev = emitterInfo;
        }

        return path;
    }


    public static void rectangleHull(List<EmitterInfo> emitterInfos) {

        Optional<Coordinate> minX = emitterInfos.stream().map(EmitterInfo::getCoordinate).min(Comparator.comparingInt(Coordinate::getX));
        Optional<Coordinate> minY = emitterInfos.stream().map(EmitterInfo::getCoordinate).min(Comparator.comparingInt(Coordinate::getY));
        Optional<Coordinate> maxX = emitterInfos.stream().map(EmitterInfo::getCoordinate).max(Comparator.comparingInt(Coordinate::getX));
        Optional<Coordinate> maxY = emitterInfos.stream().map(EmitterInfo::getCoordinate).max(Comparator.comparingInt(Coordinate::getY));


        System.out.println("("+minX.get().getX()+","+minY.get().getY()+")");
        System.out.println("("+maxX.get().getX()+","+maxY.get().getY()+")");

    }

    public static long ellapsedIsSeconds(LocalTime from, LocalTime to) {
        return Duration.between(from, to).getSeconds();
    }

    public static void ellapsed(LocalTime from, LocalTime to) {
        Duration between = Duration.between(from, to);
        System.out.println(between.toHoursPart() + ":" + between.toMinutesPart() + ":" + between.toSecondsPart());
    }

    private static int readLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<EmitterInfo> readModel(File file) {

        List<EmitterInfo> emitterInfos = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                String[] values = line.split(" ");
                EmitterInfo emitterInfo = new EmitterInfo(
                        Integer.parseInt(values[0]),
                        Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]),
                        Integer.parseInt(values[3]),
                        Integer.parseInt(values[4])
                );

                emitterInfos.add(emitterInfo);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        return emitterInfos;

    }


}