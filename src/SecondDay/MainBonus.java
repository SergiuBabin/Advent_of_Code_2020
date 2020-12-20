package SecondDay;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class MainBonus {
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

            if (String.valueOf(str.charAt(min - 1)).equals(c) && !String.valueOf(str.charAt(max - 1)).equals(c)) {
                nr++;
            }
            if (!String.valueOf(str.charAt(min - 1)).equals(c) && String.valueOf(str.charAt(max - 1)).equals(c)) {
                nr++;
            }
        }
        System.out.println(nr);
    }
}
