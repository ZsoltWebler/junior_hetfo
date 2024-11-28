package java_io;

public enum FuelType {
    PETROL,
    DIESEL,
    CNG,
    LPG,
    ELECTRIC,
    UNKNOWN;

    public static FuelType of(String fuelTypeString) {

        switch (fuelTypeString.toUpperCase()) {
            case "PETROL":
                return PETROL;
            case "DIESEL":
                return DIESEL;
            case "CNG":
                return CNG;
            case "LPG":
                return LPG;
            case "ELECTRIC":
                return ELECTRIC;
            default:
                return UNKNOWN;
        }

    }
}
