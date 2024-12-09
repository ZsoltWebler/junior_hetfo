package java_basics;

public class Cipher {

    public static String caesarEncrypt(String plaintext, int shift) {

        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) (((c - base + shift) % 16) + base);
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();

    }


    public static String AtbashEncrypt(String plaintext) {
        throw new UnsupportedOperationException();
    }

}
