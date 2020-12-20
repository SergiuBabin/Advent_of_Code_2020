package NinthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

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

            for (int i = 25; i < list.size(); i++) {
                boolean cond = false;
                for (int j = i - 1; j >= i - 24; j--) {
                    for (int k = j - 1; k >= i - 25; k--) {
                        //System.out.println(list.get(i) + " = "+ list.get(j) + " " + list.get(k));
                        if (list.get(i) == list.get(j) + list.get(k)) {
                            cond = true;
                            //System.out.println("=================="+list.get(i) + " = "+ list.get(j) + " " + list.get(k));
                            break;
                        }
                    }
                    if (cond) {
                        break;
                    }
                }

                if (!cond) {
                    NumberFormat formatter = new DecimalFormat("0");
                    String string = formatter.format(list.get(i));
                    System.out.println(string);
                }
            }

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
