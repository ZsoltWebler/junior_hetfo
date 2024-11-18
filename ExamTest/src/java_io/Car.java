package java_io;


import java.util.Objects;

public class Car {

    private final String name;
    private final int year;
    private final int price;
    private final int drivenKilometers;
    private final FuelType fuelType;
    private final Transmission transmission;

    public Car(String name, int year, int price, int drivenKilometers, FuelType fuelType, Transmission transmission) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.drivenKilometers = drivenKilometers;
        this.fuelType = fuelType;
        this.transmission = transmission;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getDrivenKilometers() {
        return drivenKilometers;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", drivenKilometers=" + drivenKilometers +
                ", fuelType=" + fuelType +
                ", transmission=" + transmission +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && price == car.price && drivenKilometers == car.drivenKilometers && Objects.equals(name, car.name) && fuelType == car.fuelType && transmission == car.transmission;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, price, drivenKilometers, fuelType, transmission);
    }
}
