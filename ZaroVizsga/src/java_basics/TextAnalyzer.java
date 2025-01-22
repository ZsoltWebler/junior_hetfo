package java_basics;


public class TextAnalyzer  {

    public int countLetters(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    public int countDigits(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                count--;
            }
        }
        return count;
    }


    public int countSpecialCharacters(String text) {
        throw new UnsupportedOperationException();
    }


    public int countWords(String text) {
        throw new UnsupportedOperationException();
    }




}
