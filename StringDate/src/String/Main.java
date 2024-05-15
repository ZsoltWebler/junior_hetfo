package String;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("amama"));
        occurences("almakortealmabananalmasajt", "alma");
        reverseString("alma");
        longestCommonPrefix(new String[]{
                "alma",
                "alakzat",
                "alap"
        });
    }

    public static boolean isPalindrome(String s) {
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

    public static void occurences(String s, String subString) {
        int count = 0;
        for (int i = 0; i < s.length() - 2 - subString.length(); i++) {
            if (s.substring(i, i + subString.length()).equals(subString)) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public static String reverseString(String s) {
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverse += s.charAt(i);
        }
        return reverse;
    }

    public static String longestCommonPrefix(String[] s) {
        String prefix = "";
        String longestCommonPrefix = "";
        for (String string : s) {
            if (prefix.equals("")) {
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

}