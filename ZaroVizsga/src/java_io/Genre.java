package java_io;

public enum Genre {
    FICTION,
    NON_FICTION,
    UNKNOWN;

    public static Genre parseGenre(String value) {


        if (value.equals("Non Fiction")) {
            return NON_FICTION;
        }
        if (value.equals("Fiction")) {
            return FICTION;
        }
        return UNKNOWN;

    }
}
