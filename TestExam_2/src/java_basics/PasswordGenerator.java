package java_basics;

import java.util.Random;

public class PasswordGenerator {
    public static final char[] SPECIAL_CHARACTERS = new char[]{'!', '#', '$', '(', ')', '*', '+', '-', ',', '_', '/'};
    private static final Random RANDOM = new Random();

    public static String generateWeakPassword(int length) {

        StringBuilder password = new StringBuilder();
        while (password.length() < length) {
            password.append((char) (RANDOM.nextInt(26) + 'a'));
        }

        return password.toString();

    }

    public static String generateAveragePassword(int length) {
        StringBuilder password = new StringBuilder();
        while (password.length() < length) {
            if (RANDOM.nextBoolean()) {
                password.append((char) (RANDOM.nextInt(26) + 'a'));
            } else {
                password.append((char) (RANDOM.nextInt(26) + 'A'));
            }

        }

        return password.toString();
    }

    public static String generateStrongPassword(int length) {
        StringBuilder password = new StringBuilder();

        while (password.length() < length) {
            int randomNumber = RANDOM.nextInt(3);
            if (randomNumber == 0) {
                password.append((char) (RANDOM.nextInt(26) + 'a'));
            }
            if (randomNumber == 1) {
                password.append((char) (RANDOM.nextInt(26) + 'A'));
            }
            if (randomNumber == 2) {
                password.append(RANDOM.nextInt(10));
            }

        }

        return password.toString();
    }

    public static String generateVeryStrongPassword(int length) {
        StringBuilder password = new StringBuilder();

        while (password.length() < length) {
            int randomNumber = RANDOM.nextInt(4);
            if (randomNumber == 0) {
                password.append((char) (RANDOM.nextInt(26) + 'a'));
            }
            if (randomNumber == 1) {
                password.append((char) (RANDOM.nextInt(26) + 'A'));
            }
            if (randomNumber == 2) {
                password.append(RANDOM.nextInt(10));
            }
            if (randomNumber == 3) {
                password.append(SPECIAL_CHARACTERS[RANDOM.nextInt(SPECIAL_CHARACTERS.length)]);
            }

        }

        return password.toString();
    }



}
