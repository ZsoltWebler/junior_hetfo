package java_oop;

public class Car {

    private final String identifier;
    private final String manufacturer;
    private final String model;
    private final double price;
    private final boolean isAvailable;

    public Car(String identifier, String manufacturer, String model, double price, boolean isAvailable) {
        this.identifier = (identifier.toUpperCase() + "0000000000").substring(0, 10);
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getNetPrice(Vat vat) {
        return getPrice() + (getPrice() * vat.VAT_RATE) / 100;
    }

}
