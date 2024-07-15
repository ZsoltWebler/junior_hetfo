package practice;

import java.util.*;

public class Practice {


    public static final List<Employee> listOfEmployees = Arrays.asList(
            new Employee(1, "Jeff Bezos", 100000, new Organization("Amazon", new Country("USA", "US"))),
            new Employee(2, "John Smith", 20000, new Organization("Amazon", new Country("USA", "US"))),
            new Employee(3, "Bill Gates", 200000, new Organization("Microsoft", new Country("USA", "US"))),
            new Employee(4, "Paul Allen", 200000, new Organization("Microsoft", new Country("USA", "US"))),
            new Employee(5, "Mark Zuckerberg", 300000, new Organization("Facebook", new Country("Ireland", "IR"))),
            new Employee(6, "Bill Bow", 10000, new Organization("Facebook", new Country("Ireland", "IR"))),
            new Employee(7, "Elon Musk", 300000, new Organization("Twitter", new Country("USA", "US"))),
            new Employee(8, "Parag Agrawal", 300000, new Organization("Twitter", new Country("USA", "US"))),
            new Employee(9, "Tim Cook", 250000, new Organization("Apple", new Country("United Kingdom", "UK"))),
            new Employee(10, "Jony Ive", 50000, new Organization("Apple", new Country("United Kingdom", "UK"))),
            new Employee(11, "Steve Wozniak", 150000, new Organization("Apple", new Country("United Kingdom", "UK"))));


    public static void main(String[] args) {
        List<Employee> employees = everyThrid(listOfEmployees);
        System.out.println(employees);

        Map<String, Double> averageSalaries = averageSalary(listOfEmployees);
        System.out.println(averageSalaries);

        sortBySalary(listOfEmployees);
        System.out.println(listOfEmployees);

        getOrganizationsFromUsa(listOfEmployees);

    }

    public static List<Employee> everyThrid(List<Employee> employees) {
        List<Employee> everyThird = new ArrayList<>();
        for (int i = 0; i < employees.size(); i += 3) {
            everyThird.add(employees.get(i));
        }
        return everyThird;
    }

    public static Map<String, Double> averageSalary(List<Employee> employees) {
        Map<String, List<Double>> salariesByOrganization = new HashMap<>();

        // Group salaries by organization
        for (Employee employee : employees) {
            String organizationName = employee.getOrganization().getName();
            salariesByOrganization.putIfAbsent(organizationName, new ArrayList<>());
            salariesByOrganization.get(organizationName).add(employee.getSalary());
        }

        // Calculate average salary for each organization
        Map<String, Double> averageSalaries = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : salariesByOrganization.entrySet()) {
            String organization = entry.getKey();
            List<Double> salaries = entry.getValue();
            double average = salaries.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            averageSalaries.put(organization, average);
        }

        return averageSalaries;
    }

    public static void sortBySalary(List<Employee> employees) {
        Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary)
                .thenComparing(e -> e.getOrganization().getName()));
    }

    public static void getOrganizationsFromUsa(List<Employee> employees) {
        Set<Organization> organizations = new HashSet<>();
        for (Employee employee : employees) {
            if (employee.getOrganization().getCountry().getName().equals("USA")) {
                organizations.add(employee.getOrganization());
            }
        }
        List<Organization> organizations1 = new ArrayList<>();
        organizations1.addAll(organizations);
        System.out.println(organizations1);

    }

}