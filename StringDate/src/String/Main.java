package String;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(isIsomorphic("aab", "xxy"));
        System.out.println(isIsomorphic("aab", "xyy"));

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
                    if (i < prefix.length()) {
                        if (prefix.charAt(i) == string.charAt(i)) {
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

    public static String caesarCode(String message, int offset) {
        char[] chars = message.toUpperCase().toCharArray();
        String shifted = "";

        for (Character c : chars) {
            char tmp = (char) ((((c + offset) - 65) % 26) + 65);
            shifted += tmp;
        }

        return shifted;

    }

    public static boolean isAnagram(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        return Arrays.equals(s1Chars, s2Chars);

    }

    public static boolean isIsomorphic(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character,Character> projections = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);

            if(projections.containsKey(c)){
                if(s2.charAt(i) != projections.get(c)){
                    return false;
                }
            }else {
                projections.put(c,s2.charAt(i));
            }
        }
        return true;
    }
}