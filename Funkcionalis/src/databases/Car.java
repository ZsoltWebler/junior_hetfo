package databases;


import java.util.Objects;

public class Car {
    private final String name;
    private final int year;
    private final int sellingPrice;
    private final int kmDriven;
    private final String fuel;
    private final String sellerType;
    private final String transmission;
    private final String owner;

    public Car(String name, int year, int sellingPrice, int kmDriven, String fuel, String sellerType, String transmission, String owner) {
        this.name = name;
        this.year = year;
        this.sellingPrice = sellingPrice;
        this.kmDriven = kmDriven;
        this.fuel = fuel;
        this.sellerType = sellerType;
        this.transmission = transmission;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public String getFuel() {
        return fuel;
    }

    public String getSellerType() {
        return sellerType;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", sellingPrice=" + sellingPrice +
                ", kmDriven=" + kmDriven +
                ", fuel='" + fuel + '\'' +
                ", sellerType='" + sellerType + '\'' +
                ", transmission='" + transmission + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && sellingPrice == car.sellingPrice && kmDriven == car.kmDriven && Objects.equals(name, car.name) && Objects.equals(fuel, car.fuel) && Objects.equals(sellerType, car.sellerType) && Objects.equals(transmission, car.transmission) && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, sellingPrice, kmDriven, fuel, sellerType, transmission, owner);
    }
}
