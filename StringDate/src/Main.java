import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        StringJoiner joiner=new StringJoiner(",","[","]"); //
        joiner.add("Red").add("Green").add("Blue"); //
        String joined=joiner.toString();
        System.out.println(joined);
    }
}