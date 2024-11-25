package java_oop;

import java.time.LocalDate;

public class Employee {

    private final String firstName;
    private final String lastName;
    private final int startYear;
    private int lastSalaryRaise;
    private int performance;
    private int salary;


    public Employee(String firstName, String lastName, int startYear, int lastSalaryRaise, int performance, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startYear = startYear;
        this.salary = salary;
        this.lastSalaryRaise = lastSalaryRaise;
        setPerformance(performance);
    }

    public void raiseSalary(int amount) {
        salary += amount;
        lastSalaryRaise = LocalDate.now().getYear();
    }

    public void setPerformance(int performance) {
        this.performance = Math.max(1, Math.min(10, performance));
    }

    public int recommendedSalaryRaise() {
        return (int) Math.round(getSalary()*Math.pow((1+(getPerformance()/100.0)),LocalDate.now().getYear()-lastSalaryRaise));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getLastSalaryRaise() {
        return lastSalaryRaise;
    }

    public int getPerformance() {
        return performance;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", startYear=" + startYear +
                ", lastSalaryRaise=" + lastSalaryRaise +
                ", performance=" + performance +
                ", salary=" + salary +
                '}';
    }
}
