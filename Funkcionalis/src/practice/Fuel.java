package practice;

public enum Fuel {
    COAL,
    PETROLEUM,
    NATURAL_GAS,
    UNKNOWN;

    public static Fuel parseFuel(String s) {
        switch (s.toUpperCase()) {
            case "COAL":
                return COAL;
            case "PETROLEUM":
                return PETROLEUM;
            case "NATURAL GAS":
                return NATURAL_GAS;
            default:
                return UNKNOWN;
        }
    }
}
