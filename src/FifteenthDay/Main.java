package FifteenthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static int step(int lastSpoken, int index, Map<Integer, Integer> seenLast) {
        int seenLastTemp = seenLast.getOrDefault(lastSpoken, -1);
        seenLast.put(lastSpoken, index);
        return seenLastTemp == -1 ? 0 : (index - seenLastTemp);
    }

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/FifteenthDay/test.txt"));

            String[] numStrings = br.readLine().split(",");
            int index = 0;
            Map<Integer, Integer> seenLast = new HashMap<>();
            int last = -1;
            for(int i = 0; i < numStrings.length; i++)
            {
                int num = Integer.parseInt(numStrings[i]);
                index++;
                if(i == numStrings.length - 1)
                {
                    last = num;
                }
                else
                {
                    seenLast.put(num, index);
                }
            }

            while(index < 2020)
            {
                last = step(last, index, seenLast);
                index++;
            }

            System.out.println(last);

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
