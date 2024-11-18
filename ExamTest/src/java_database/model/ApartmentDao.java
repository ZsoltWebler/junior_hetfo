package java_database.model;

import java.util.Objects;

public class ApartmentDao {

    private int apartmentId;
    private final String city;
    private final String address;
    private final double area;
    private final int price;
    private final boolean reserved;


    public ApartmentDao(String city, String address, double area, int price, boolean reserved) {
        this.city = city;
        this.address = address;
        this.area = area;
        this.price = price;
        this.reserved = reserved;
    }

    public ApartmentDao(int apartmentId, String city, String address, double area, int price, boolean reserved) {
        this.apartmentId = apartmentId;
        this.city = city;
        this.address = address;
        this.area = area;
        this.price = price;
        this.reserved = reserved;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public boolean isReserved() {
        return reserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentDao apartment = (ApartmentDao) o;
        return apartmentId == apartment.apartmentId && Double.compare(apartment.area, area) == 0 && price == apartment.price && reserved == apartment.reserved && Objects.equals(city, apartment.city) && Objects.equals(address, apartment.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartmentId, city, address, area, price, reserved);
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + apartmentId +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", reserved=" + reserved +
                '}';
    }
}
