package practice.carrier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private final String carrier;
    private final LocalDateTime localDateTime;
    private final String address;

    public Order(String carrier, LocalDateTime localDateTime, String address) {
        this.carrier = carrier;
        this.localDateTime = localDateTime;
        this.address = address;
    }

    public String getCarrier() {
        return carrier;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(carrier, order.carrier) && Objects.equals(localDateTime, order.localDateTime) && Objects.equals(address, order.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrier, localDateTime, address);
    }

    @Override
    public String toString() {
        return "Order{" +
                "carrier='" + carrier + '\'' +
                ", date=" + localDateTime +
                ", address='" + address + '\'' +
                '}';
    }
}
