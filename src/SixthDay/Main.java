package SixthDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("src/SixthDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int nr = 0;
        List<String> l = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            for (int i = 0; i < st.length(); i++) {
                if (!l.contains(String.valueOf(st.charAt(i)))) {
                    l.add(String.valueOf(st.charAt(i)));
                }
            }

            if (st.length() == 0) {
                nr += l.size();
                l.clear();
            }
        }
        System.out.println(nr);
    }
}
