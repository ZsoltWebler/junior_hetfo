public enum FuelName {
    COAL,
    PETROLEUM,
    NATURAL_GAS,
    UNKNOWN;

    public static FuelName parseFuelName(String s){
        switch (s.toUpperCase()){
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
