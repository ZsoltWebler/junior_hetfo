package property_tax;

import java.util.Objects;

public class Property {

    private final int taxNumber;
    private final String street;
    private final String houseNumber;
    private final String taxRate;
    private final int area;

    public Property(int taxNumber, String street, String houseNumber, String taxRate, int area) {
        this.taxNumber = taxNumber;
        this.street = street;
        this.houseNumber = houseNumber;
        this.taxRate = taxRate;
        this.area = area;
    }

    public int getTaxNumber() {
        return taxNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public int getArea() {
        return area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return taxNumber == property.taxNumber && area == property.area && Objects.equals(street, property.street) && Objects.equals(houseNumber, property.houseNumber) && Objects.equals(taxRate, property.taxRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taxNumber, street, houseNumber, taxRate, area);
    }

    @Override
    public String toString() {
        return "Property{" +
                "taxNumber=" + taxNumber +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", taxRate='" + taxRate + '\'' +
                ", area=" + area +
                '}';
    }
}
