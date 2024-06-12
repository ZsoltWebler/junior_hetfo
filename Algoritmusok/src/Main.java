public class Main {
    public static void main(String[] args) {

        joined(new String[]{
                "oven",
                "envier",
                "erase",
                "serious"
        });
    }

    public static String[] joined(String[] words) {

        String s1 = "oven";
        String s2 = "envier";
        for(int j = 0; j< words.length-1; j++){
            s1= words[j];
            s2 = words[j+1];
            if(s1.length()>s2.length()){
                for (int i = 0; i < s2.length() -1; i++) {
                    String prefix = s1.substring(i, s1.length());

                    if (s2.startsWith(prefix)) {
                        System.out.println("Megvan " + prefix);

                    } else {
                        System.out.println("Nem jó " + prefix);
                    }
                }
            }
            if(s1.length()<s2.length()){
            for (int i = 0; i < s1.length() -1; i++) {
                String prefix = s1.substring(i, s1.length());

                if (s2.startsWith(prefix)) {
                    System.out.println("Megvan " + prefix);

                } else {
                    System.out.println("Nem jó " + prefix);
                }
            }
        }}



        return new String[1];
    }

    public static String[] join(String[] words){


        return new String[]{"egyesített_szó","átfedő_halmaz"};
    }
}