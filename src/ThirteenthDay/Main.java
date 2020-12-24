package ThirteenthDay;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/ThirteenthDay/test.txt"));

            List<Integer> list = new ArrayList<>();

            String line;
            line = br.readLine();
            int nr = Integer.parseInt(line);
            line = br.readLine();
            String[] strings = line.split(",");

            for (String i : strings) {
                if (isStringInt(i)) {
                    list.add(Integer.parseInt(i));
                }
            }
            int min = Integer.MAX_VALUE;
            int p = 0;
            for (Integer i : list){
                int k = 0;
                if (nr % i != 0) {
                    k++;
                }
                int a = i;
                i *= nr / i + k;
                if (min > i) {
                    min = i;
                    p = a;
                }
                System.out.println(i);
            }
            System.out.println((min - nr)*p);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
