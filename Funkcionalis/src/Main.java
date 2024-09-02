public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public static int closerTo100(int first, int second) {
        return Math.abs(100 - first) > Math.abs(100 - second) ? second : first;
    }
}