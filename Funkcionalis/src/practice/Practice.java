package practice;

import java.util.Arrays;
import java.util.List;

public class Practice {


    public static final List<Employee> listOfEmployees= Arrays.asList(
            new Employee(1,"Jeff Bezos",100000,new Organization("Amazon",new Country("USA","US"))),
            new Employee(2,"John Smith",20000,new Organization("Amazon",new Country("USA","US"))),
            new Employee(3,"Bill Gates",200000,new Organization("Microsoft",new Country("USA","US"))),
            new Employee(4,"Paul Allen",200000,new Organization("Microsoft",new Country("USA","US"))),
            new Employee(5,"Mark Zuckerberg",300000,new Organization("Facebook",new Country("Ireland","IR"))),
            new Employee(6,"Bill Bow",10000,new Organization("Facebook",new Country("Ireland","IR"))),
            new Employee(7,"Elon Musk",300000,new Organization("Twitter",new Country("USA","US"))),
            new Employee(8,"Parag Agrawal",300000,new Organization("Twitter",new Country("USA","US"))),
            new Employee(9,"Tim Cook",250000,new Organization("Apple",new Country("United Kingdom","UK"))),
            new Employee(10,"Jony Ive",50000,new Organization("Apple",new Country("United Kingdom","UK"))),
            new Employee(11,"Steve Wozniak",150000,new Organization("Apple",new Country("United Kingdom","UK"))));


    public static void main(String[] args) {


    }
}