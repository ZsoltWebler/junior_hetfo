package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
        Map<Boolean, List<Integer>>evenOddMap=numbers.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));

        System.out.println();

    }
}