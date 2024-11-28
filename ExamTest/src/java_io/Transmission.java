package java_io;

public enum Transmission {
    AUTOMATIC,
    MANUAL;

    public static Transmission of(String transmissionString) {
        if (transmissionString.equalsIgnoreCase(AUTOMATIC.name())) {
            return AUTOMATIC;
        } else {
            return MANUAL;
        }
    }
}

