package stream;

import practice.StringRule;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


    }

    public static void applyRule(StringRule rule, String str){


        String isEmpty = rule.apply(str) ? "" : "nem ";
        System.out.println("A kapott string "+isEmpty+"üres!" );

    }
}