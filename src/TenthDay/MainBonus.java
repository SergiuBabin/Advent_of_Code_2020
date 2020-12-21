package TenthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainBonus {
    public static List<Integer> list = new ArrayList<>();
    static long[] DP = new long[100];

    static long dp(int i) {
        if (i == list.size() - 1) {
            return 1;
        }

        if (DP[i] != 0) {
            return DP[i];
        }

        long ans = 0;
        for (int j = i+1; j < list.size(); j++) {
            if (list.get(j) - list.get(i) <= 3) {
                ans += dp(j);
            } else {
                break;
            }
        }
        DP[i] = ans;
        return ans;
    }
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/TenthDay/test.txt"));

            String line;
            list.add(0);
            while ((line = br.readLine()) != null) {
                debug = line;
                list.add(Integer.parseInt(line));
            }

            Collections.sort(list);
            list.add(list.get(list.size() - 1) + 3);

            System.out.println(dp(0));
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
