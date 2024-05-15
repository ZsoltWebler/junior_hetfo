package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("alma"));
        System.out.println(isPalindrome2("gorog"));

        System.out.println(reverse("ALAKZAT"));

        longestCommonPrefix3(new ArrayList<>(List.of("ALAKZAT", "ALMA", "ALKANTARA")));

    }

    static class StringLengthComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }
    }

    public static String longestCommonPrefix(List<String> stringList) {

        Collections.sort(stringList, new StringLengthComparator());

        String prefix = "";

        for (int i = 0; i < stringList.get(0).length(); i++) {

            String possiblePrefix = stringList.get(0).substring(0, 1 + i);

            for (String words : stringList) {

                if (!words.startsWith(possiblePrefix)) {
                    return prefix;
                }

            }
            prefix = possiblePrefix;

        }

        return "";
    }

    public static String longestCommonPrefix2(List<String> stringList) {

        String prefix = "";

        for (int i = 0; i < stringList.get(0).length(); i++) {

            String possiblePrefix = stringList.get(0).substring(0, 1 + i);

            for (String words : stringList) {

                if (!words.startsWith(possiblePrefix)) {
                    return prefix;
                }

            }
            prefix = possiblePrefix;

        }

        return "";
    }

    public static String longestCommonPrefix3(List<String> stringList) {

        String prefix = "";
        String longestCommonPrefix = "";
        for (String string : stringList) {
            if (prefix.isEmpty()) {
                prefix = string;
            } else {
                for (int i = 0; i < string.length(); i++) {
                    if(i < prefix.length()){
                        if(prefix.charAt(i) == string.charAt(i)){
                            longestCommonPrefix += string.charAt(i);
                        }
                    }
                }
            }
        }
        return longestCommonPrefix;
    }


    public static int occurences(String s, String substring) {
        return 0;
    }

    public static boolean isPalindrome(String s) {

        for (int i = 0; i < s.length() / 2 + 1; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(String s) {

        return s.equals(reverse(s));
    }

    public static String reverse(String s) {

        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static boolean isPalindrome2(String s) {

        String palindrome = "";
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            palindrome += s.charAt(i);
        }
        if (palindrome.equals(s)) {
            return true;
        }
        return false;
    }
}