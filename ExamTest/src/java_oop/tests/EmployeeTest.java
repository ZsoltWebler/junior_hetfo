package java_oop.tests;

import org.junit.jupiter.api.Test;
import java_oop.Employee;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeTest {


    @Test
    public void testPerformanceIsLessThan11() {
        Employee employee = new Employee("John", "Doe", 2000, 2008, 11, 1000);

        int actual = employee.getPerformance();
        int expected = 10;

        assertEquals(expected, actual);
    }

    @Test
    public void testPerformanceIsMoreThan0() {
        Employee employee = new Employee("John", "Doe", 2000, 2008, -1, 1000);

        int actual = employee.getPerformance();
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    public void testLastSalaryRaiseIsSetCorrectlyAfterASalaryRaise() {
        int lastSalaryRaise = 2008;
        Employee employee = new Employee("John", "Doe", 2000, lastSalaryRaise, 6, 1000);

        employee.raiseSalary(1000);
        int actual = employee.getLastSalaryRaise();
        int expected = LocalDate.now().getYear();

        assertEquals(expected, actual);
    }


}
