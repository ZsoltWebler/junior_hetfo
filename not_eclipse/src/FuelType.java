public enum FuelType {
    REGULAR_GASOLINE,
    PREMIUM_GASOLINE,
    DIESEL,
    E85,
    NATURAL_GAS,
    UNKNOWN;


public static FuelType parseFuelType(String fuelType) {
    switch (fuelType) {
        case "X":
            return FuelType.REGULAR_GASOLINE;
        case "Z":
            return FuelType.PREMIUM_GASOLINE;
        case "D":
            return FuelType.DIESEL;
        case "E":
            return FuelType.E85;
        case "N":
            return FuelType.NATURAL_GAS;
        default:
            return FuelType.UNKNOWN;
    }
}}