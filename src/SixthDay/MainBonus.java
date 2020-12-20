package SixthDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class MainBonus {
    public static void main(String[] args) throws Exception {
        File file = new File("src/SixthDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int nr = 0, n = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while ((st = br.readLine()) != null) {
            for (int i = 0; i < st.length(); i++) {
                if (map.containsKey(String.valueOf(st.charAt(i)))) {
                    map.put(String.valueOf(st.charAt(i)) , map.get(String.valueOf(st.charAt(i))) + 1);
                } else {
                    map.put(String.valueOf(st.charAt(i)) , 1);
                }
            }
            n++;
            if (st.length() == 0) {
                n--;
                for (Map.Entry<String, Integer> me : map.entrySet()) {
                    //System.out.println(me.getValue() + " == " + n);

                    if (me.getValue() == n) {
                        nr++;
                    }
                }
                //System.out.println(nr);
                n = 0;
                map.clear();
            }
        }
        System.out.println(nr);
    }
}