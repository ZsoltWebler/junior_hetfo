package Feladat6;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static boolean isAnagram(String s1, String s2) {
        //ha a hossz nem egyezik, akkor false
        if (s1.length() != s2.length()) {
            return false;
        }
        //hashMapp-el: nem rendezett kollekció, nincs jelentősége az elemek sorrendjének
        Map <Character, Integer> s1Map = new HashMap<>();
        Map <Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
        //ha új karakter, akkor vegye fel mindkét map-be, és állítsa az előfordulást 1-re
        //ha már meglévő karakter, akkor adjon a megfelelő map karakter előfordulásához +1-et
            if (s1Map.containsKey(s1.charAt(i))) {
                s1Map.put(s1.charAt(i),s1Map.getOrDefault(s1.charAt(i), 0) + 1);
                } else {
                s1Map.put(s1.charAt(i),1);
            }
            if (s2Map.containsKey(s2.charAt(i))) {
                s2Map.put(s2.charAt(i),s2Map.getOrDefault(s2.charAt(i), 0) + 1);
            } else {
                s2Map.put(s2.charAt(i),1);
            }
        }
        return s1Map.equals(s2Map);
    }
    public static void main(String[] args) {

        System.out.println(isAnagram("egér", "éger"));

    }


}

