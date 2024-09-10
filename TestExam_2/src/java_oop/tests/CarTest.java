package java_oop.tests;

import org.junit.jupiter.api.Test;
import java_oop.Car;
import java_oop.Vat;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    public void testIdentifierMustBeUppercase() {
        String expectedId = "ID00000000";
        Car car = new Car("id", "TEST_MAN", "TEST_MODEL", 100.0, true);

        assertEquals(expectedId, car.getIdentifier());

    }
    @Test
    public void testIdentifierMustBe10CharsLong() {
        Car car = new Car("id", "TEST_MAN", "TEST_MODEL", 100.0, true);

        assertEquals(10, car.getIdentifier().length());

    }

    @Test
    public void testGettersWorksProper() {
        Car car = new Car("ID_1000000", "TEST_MAN", "TEST_MODEL", 100.0, true);

        assertEquals("ID_1000000", car.getIdentifier());
        assertEquals("TEST_MAN", car.getManufacturer());
        assertEquals("TEST_MODEL", car.getModel());
        assertEquals(100.0, car.getPrice(), 0);
        assertEquals(true, car.isAvailable());

    }

    @Test
    public void testVATCalculatedProperly() {
        Car car = new Car("ID_1000000", "TEST_MAN", "TEST_MODEL", 100.0, true);

       assertEquals(127,car.getNetPrice(Vat.HUNGARY));

    }

    @Test
    public void testVATCalculatedProperly_2() {
        Car car = new Car("ID_1000000", "TEST_MAN", "TEST_MODEL", 100.0, true);

        assertEquals(118,car.getNetPrice(Vat.MALTA));

    }

    @Test
    public void testVATCalculatedProperly_3() {
        Car car = new Car("ID_1000000", "TEST_MAN", "TEST_MODEL", 100.0, true);

        assertEquals(119,car.getNetPrice(Vat.ROMANIA));

    }

}
