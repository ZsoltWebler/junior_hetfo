public enum FuelName {
    COAL,
    PETROLEUM,
    NATURAL_GAS;

    public static FuelName parseFuelName(String s){
        if(s.equals("Coal")){
            return COAL;
        }
        if(s.equals("Petroleum")){
            return PETROLEUM;
        }
        if(s.equals("Natural Gas")){
            return NATURAL_GAS;
        }
        return null;
    }
}
