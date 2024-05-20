package Feladat5;
//forrás: https://www.educative.io/answers/how-to-check-if-two-strings-are-isomorphic


import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean isIsomorphic(String s1, String s2) {
        //ha a hossz nem egyezik, akkor false
        if (s1.length() != s2.length()) {
            return false;
        }
        //hashMapp-el: key: s1 karakterei value: s2 karakterei
        Map <Character, Character> stringMap = new HashMap<>();
        //már egymáshoz rendelt karaketerek követése SETTEL!!!!
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
           //ha stringMap tartalmazza s1 karakterét és stringMap s1-hez tartozó ÉRTÉKE NEM ua.,
           // mint s2 i. karaktere, akkor false
            if (stringMap.containsKey(s1.charAt(i))) {
                if (stringMap.get(s1.charAt(i)) !=s2.charAt(i)) return false;
            } else {

            //ha  stringMap NEM tartalmazza s1 karakterét, de a charSet tartalmazza már s2 i. karakterét, akkor false
                if (charSet.contains(s2.charAt(i))) return false;
            //ha  stringMap NEM tartalmazza s1 karakterét,
                // ÉS a charSet sem tartalmazza már s2 i. karakterét, akkor felvesszük az új hozzárendelést
                stringMap.put(s1.charAt(i), s2.charAt(i));
                charSet.add(s2.charAt(i));
            }
        }
        //ha nem teljesültek a for ciklusban lévő false feltételek, akkor igazzal tér vissza
        return true;
    }
    public static void main(String[] args) {

        System.out.println(isIsomorphic("baba", "rers"));
        System.out.println(isIsomorphic("baba", "rere"));

    }


}

