import java.util.Objects;

public class Car {
    private final String name;
    private final int year;
    private final long selling_price;
    private final long km_driven;
    private final String fuel;
    private final String seller_type;
    private final String transmission;
    private final String owner;

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public long getSelling_price() {
        return selling_price;
    }

    public long getKm_driven() {
        return km_driven;
    }

    public String getFuel() {
        return fuel;
    }

    public String getSeller_type() {
        return seller_type;
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
                ", selling_price=" + selling_price +
                ", km_driven=" + km_driven +
                ", fuel='" + fuel + '\'' +
                ", seller_type='" + seller_type + '\'' +
                ", transmission='" + transmission + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    public Car(String name, int year, long selling_price, long km_driven, String fuel, String seller_type, String transmission, String owner) {
        this.name = name;
        this.year = year;
        this.selling_price = selling_price;
        this.km_driven = km_driven;
        this.fuel = fuel;
        this.seller_type = seller_type;
        this.transmission = transmission;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && selling_price == car.selling_price && km_driven == car.km_driven && Objects.equals(name, car.name) && Objects.equals(fuel, car.fuel) && Objects.equals(seller_type, car.seller_type) && Objects.equals(transmission, car.transmission) && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, selling_price, km_driven, fuel, seller_type, transmission, owner);
    }
}
