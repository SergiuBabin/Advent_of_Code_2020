package ThirdDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("src/ThirdDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int i = 3, nr = 0;
        br.readLine();
        while ((st = br.readLine()) != null) {

            if (st.charAt(i) == '#') {
                System.out.println(st.charAt(i));
                nr++;
            }
            i += 3;
            if (st.length() - 1 < i){
                i -= st.length();
            }
        }
        System.out.println(nr);
    }
}