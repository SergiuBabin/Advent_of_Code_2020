package FifthDay;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainBonus {
    public static void main(String[] args) throws Exception {
        File file = new File("src/FifthDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int upperHalf, lowerHalf, max = 0, temp;

        while ((st = br.readLine()) != null) {
            upperHalf = 127;
            lowerHalf = 0;
            for (int i = 0; i < 7; i++) {
                System.out.println(st.charAt(i));
                switch (st.charAt(i)) {
                    case 'F':
                        upperHalf = (upperHalf + lowerHalf) / 2;
                        System.out.println(lowerHalf + " " + upperHalf);
                        break;
                    case 'B':
                        lowerHalf = (upperHalf + lowerHalf) / 2;
                        if (upperHalf % 2 == 1) {
                            lowerHalf++;
                        }
                        System.out.println(lowerHalf + " " + upperHalf);
                        break;
                }
            }
            temp = upperHalf;
            upperHalf = 7;
            lowerHalf = 0;

            for (int i = 7; i < 10; i++) {
                System.out.println(st.charAt(i));
                switch (st.charAt(i)) {
                    case 'L':
                        upperHalf = (upperHalf + lowerHalf) / 2;
                        System.out.println(lowerHalf + " " + upperHalf);
                        break;
                    case 'R':
                        lowerHalf = (upperHalf + lowerHalf) / 2;
                        if (upperHalf % 2 == 1) {
                            lowerHalf++;
                        }
                        System.out.println(lowerHalf + " " + upperHalf);
                        break;
                }
            }

            if (max <= temp * 8 + upperHalf) {
                max = temp * 8 + upperHalf;
            }
        }
        System.out.println(max);
    }
}
