package NinthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainBonus {

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/NinthDay/test.txt"));

            List<Double> list = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                list.add(Double.parseDouble(line));
            }
            int p = 0;
            for (int i = 25; i < list.size(); i++) {
                boolean cond = false;
                for (int j = i - 1; j >= i - 24; j--) {
                    for (int k = j - 1; k >= i - 25; k--) {
                        if (list.get(i) == list.get(j) + list.get(k)) {
                            cond = true;
                            break;
                        }
                    }
                    if (cond) {
                        break;
                    }
                }

                if (!cond) {
                    p = i;
                    NumberFormat formatter = new DecimalFormat("0");
                    String string = formatter.format(list.get(i));
                    break;
                }
            }

            final Double VALUE_TO_FIND = list.get(p);

            for (int val1pos = 0; val1pos < list.size(); val1pos++) {
                Double accumulator = 0.;
                for (int val2pos = val1pos; val2pos < list.size(); val2pos++) {
                    accumulator += list.get(val2pos);
                    if (accumulator.equals(VALUE_TO_FIND)) {

                        Double smallest = Double.MAX_VALUE;
                        Double largest = 0.;
                        System.out.println(val1pos + " " + val2pos);
                        for (int i = val1pos; i < val2pos + 1; i++) {
                            if (smallest > list.get(i)) smallest = list.get(i);
                            if (largest < list.get(i)) largest = list.get(i);
                        }
                        NumberFormat formatter = new DecimalFormat("0");
                        String string = formatter.format(smallest + largest);
                        System.out.println(string);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
