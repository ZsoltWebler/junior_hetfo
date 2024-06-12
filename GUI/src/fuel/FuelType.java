package fuel;

public enum FuelType {

	REGULAR_GASOLINE, // X
	PREMIUM_GASOLINE, // Z
	DIESEL, // D
	E85, // E
	NATURAL_GAS, // N
	UNKNOWN;

	public static FuelType parseFuelType(String s) {
		switch (s.toUpperCase()) {
		case "X": {
			return REGULAR_GASOLINE;
		}
		case "Z": {
			return PREMIUM_GASOLINE;
		}
		case "D": {
			return DIESEL;
		}
		case "E": {
			return E85;
		}
		case "N": {
			return NATURAL_GAS;
		}
		default:
			return UNKNOWN;
		}
	}
}
