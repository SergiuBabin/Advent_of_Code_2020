package SecondDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("src/SecondDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int min, max;
        String str;
        String c;
        int nr = 0;
        while ((st = br.readLine()) != null) {
            StringTokenizer s = new StringTokenizer(st, " -:");

            min = Integer.parseInt(s.nextToken());
            max = Integer.parseInt(s.nextToken());

            c = s.nextToken();

            str = s.nextToken();
            int n = 0;

            for (int i = 0; i < str.length(); i++) {

                if (String.valueOf(str.charAt(i)).equals(c)) {
                    n++;
                }

                if (n > max) {
                    break;
                }
            }

            if (n >= min && n <= max) {
                nr++;
            }
        }
        System.out.println(nr);
    }
}
