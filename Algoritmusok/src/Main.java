import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Person> people = List.of(
                new Person("John"),
                new Person("Jane"),
                new Person("Daniel"),
                new Person("Bil"),
                new Person("Mark")

        );

        ArrayList<Person> people1 = new ArrayList<>(people);

        people1.sort((o1, o2) -> {
            return Integer.compare(o1.getName().length(), o2.getName().length());
        });

        System.out.println(people1);


    }

    public static String[] join(String[] words) {

        String merged = words[0];
        int longestPreffix = 0;

        for (int i = 1; i < words.length; i++) {
            String[] prefix = joinTwo(merged, words[i]);
            merged = merged + words[i].substring(prefix[0].length());

            int prefixSize = Integer.parseInt(prefix[1]);

            if (prefixSize > longestPreffix) {
                longestPreffix = prefixSize;
            }

        }

        return new String[]{merged, String.valueOf(longestPreffix)};
    }

    private static String[] joinTwo(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            String prefix = s1.substring(i);
            if (s2.startsWith(prefix)) {
                return new String[]{prefix, String.valueOf(prefix.length())};
            }
        }
        return new String[]{"", "0"};
    }

    private static int minPalindromeSteps(String word) {
        String reversed = reverse(word);
        String[] prefix = joinTwo(word, reversed);

        String minPalindrome = word + reversed.substring(prefix[0].length());
        System.out.println("\t " + minPalindrome);
        return minPalindrome.length() - word.length();

    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}