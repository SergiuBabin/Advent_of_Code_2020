package FifthDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("src/FifthDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Integer> k = new ArrayList<>();
        String st;
        int upperHalf, lowerHalf, max = 0, min = 99999, temp;

        while ((st = br.readLine()) != null) {
            upperHalf = 127;
            lowerHalf = 0;
            for (int i = 0; i < 7; i++) {
                switch (st.charAt(i)) {
                    case 'F':
                        upperHalf = (upperHalf + lowerHalf) / 2;
                        break;
                    case 'B':
                        lowerHalf = (upperHalf + lowerHalf) / 2;
                        if (upperHalf % 2 == 1) {
                            lowerHalf++;
                        }
                        break;
                }
            }
            temp = upperHalf;
            upperHalf = 7;
            lowerHalf = 0;

            for (int i = 7; i < 10; i++) {
                switch (st.charAt(i)) {
                    case 'L':
                        upperHalf = (upperHalf + lowerHalf) / 2;
                        break;
                    case 'R':
                        lowerHalf = (upperHalf + lowerHalf) / 2;
                        if (upperHalf % 2 == 1) {
                            lowerHalf++;
                        }
                        break;
                }
            }
            k.add(temp * 8 + upperHalf);
            if (max <= temp * 8 + upperHalf) {
                max = temp * 8 + upperHalf;
            }

            if (min >= temp * 8 + upperHalf) {
                min = temp * 8 + upperHalf;
            }
        }

        for (int i = min; i <= max; i++) {
            if (!k.contains(i)) {
                System.out.println(i);
            }
        }
        System.out.println(max);
    }
}