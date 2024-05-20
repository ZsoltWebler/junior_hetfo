package Feladat7;

public class Main {

    public static String caesarCode(String message, int offset) {
        String code = "";
        for (int i=0;i < message.length(); i++) {
            int ascii = (int)  (message.charAt(i)) + offset;
            code +=  (char) ascii;
        }
        return code;
    }
    public static void main(String[] args) {

        System.out.println(caesarCode("Teszt", 3));

    }


}