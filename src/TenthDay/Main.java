package TenthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/TenthDay/test.txt"));

            List<Integer> list = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                list.add(Integer.parseInt(line));
            }

            // Include charging outlet and device's built-in adapter
            list.add(0);
            Collections.sort(list);
            list.add(list.get(list.size() - 1) + 3);

            int jolt_1 = 0;
            int jolt_3 = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int diff = list.get(i + 1) - list.get(i);
                if (diff == 1) {
                    jolt_1++;
                } else if (diff == 3) {
                    jolt_3++;
                }
            }
            System.out.println(jolt_1 * jolt_3);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
