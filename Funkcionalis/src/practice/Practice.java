package practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        //feladat_1();
        //feladat_2();
        //feladat_3();
        //feladat_4();
        feladat_6();

    }

    public static void feladat_1() {

        //Régi megoldás
        for (int i = 0; i < listOfEmployees.size(); i = i + 3) {
            System.out.println(listOfEmployees.get(i));
        }

        System.out.println("\n============\n");

        //Streames megoldás
        IntStream.range(0, listOfEmployees.size())
                .filter(n -> n % 3 == 0)
                .mapToObj(listOfEmployees::get)
                .forEach(System.out::println);
    }

    public static void feladat_2() {

        //Régi megoldás

        Map<String, Double> averageSalaryByOrganizations = new HashMap<>();
        Map<String, Integer> employeeCountByOrganizations = new HashMap<>();

        for (Employee employee : listOfEmployees) {

            int employeeSalary = employee.getSalary();
            String organization = employee.getOrganization().getName();

            if (!averageSalaryByOrganizations.containsKey(organization)) {
                averageSalaryByOrganizations.put(organization, 0.0);
                employeeCountByOrganizations.put(organization, 0);
            }
            averageSalaryByOrganizations.put(organization, averageSalaryByOrganizations.get(organization) + employeeSalary);
            employeeCountByOrganizations.put(organization, employeeCountByOrganizations.get(organization) + 1);
        }

        for (String organization : employeeCountByOrganizations.keySet()) {
            averageSalaryByOrganizations.put(organization, averageSalaryByOrganizations.get(organization) / employeeCountByOrganizations.get(organization));
        }


        System.out.println("\n============\n");

        //Streames megoldás
        Map<String, Double> collect = listOfEmployees.stream().collect(Collectors.
                groupingBy(employee -> employee.getOrganization().getName(),
                        Collectors.averagingDouble(Employee::getSalary)));

    }

    public static void feladat_3() {
        //Régi megoldás
        ArrayList<Employee> employees = new ArrayList<>(listOfEmployees);
        Collections.sort(employees, (o1, o2) -> {
            if (o1.getSalary() == o2.getSalary()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });

        System.out.println();

        List<Employee> sortedList = listOfEmployees.stream().sorted((o1, o2) -> {
            if (o1.getSalary() == o2.getSalary()) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        }).toList();
    }

    public static void feladat_4() {

        List<Organization> usaBasedOrganizations = new ArrayList<>();

        for (Employee employee : listOfEmployees) {
            if (employee.getOrganization().getCountry().getName().equals("USA")) {
                if (!usaBasedOrganizations.contains(employee.getOrganization())) {
                    usaBasedOrganizations.add(employee.getOrganization());
                }
            }
        }


        List<Organization> organizations = listOfEmployees.stream()
                .map(Employee::getOrganization)
                .filter(organization -> organization.getCountry().getName().equals("USA"))
                .distinct()
                .toList();

        System.out.println();
    }

    //Készíts egy Map<Organization,Long>
    // adatszerkezetetet, amiben minden organization objektumhoz hozzá rendeled az ott dolgozók számát.
    public static void feladat_5() {

        //Régi megoldás
        Map<Organization, Long> employeeCountByOrganization = new HashMap<>();

        for (Employee employee : listOfEmployees) {
            Organization organization = employee.getOrganization();

            if (!employeeCountByOrganization.containsKey(organization)) {
                employeeCountByOrganization.put(organization, 0L);
            }
            Long currentValue = employeeCountByOrganization.get(organization);
            employeeCountByOrganization.put(organization, currentValue + 1);

        }


        // Új megoldás
        listOfEmployees
                .stream()
                .collect(Collectors.groupingBy(Employee::getOrganization, Collectors.counting()))
                .forEach((organization, count) -> System.out.println(organization.getName() + " - " +count));

    }

    //Készíts egy Map<Organization,List<Employee>> adatszerkezetetet,
    // amiben minden organization objektumhoz hozzá rendeled az ott dolgozókat.

    public static void feladat_6() {

        Map<Organization,List<Employee>> map = new HashMap<>();

        for(Employee employee: listOfEmployees){
            Organization organization = employee.getOrganization();
            if(!map.containsKey(organization)){
                map.put(organization,new ArrayList<>());
            }
            map.get(organization).add(employee);

        }


        listOfEmployees
                .stream()
                .collect(Collectors.groupingBy(Employee::getOrganization))
                .forEach((organization, employees) -> {
                    System.out.println(organization.getName());
                    employees.forEach(employee -> System.out.println("\t"+employee.getName()));
                });

        listOfEmployees
                .stream()
                .collect(Collectors.groupingBy(Employee::getOrganization))
                .forEach((organization, a) -> System.out.println(organization.getName() + " : " + a.stream().map(Employee::getName).collect(Collectors.joining(", "))));
    }
}