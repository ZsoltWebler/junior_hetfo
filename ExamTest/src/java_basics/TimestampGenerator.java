package java_basics;

public class TimestampGenerator {

    public static String generateTimeStampDayAccuracy(int year, int month, int day) {

        String timeStamp = String.format("%s%s%s", year, month, day);

        if (month > 12 && month < 1 || day < 1 || day > 31) {
            throw new IllegalArgumentException();
        }

        return timeStamp;

    }

}
