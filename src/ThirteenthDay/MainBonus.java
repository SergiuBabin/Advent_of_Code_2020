package ThirteenthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class MainBonus {
    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static int prod(int m, int n) {
        if (m == n) {
            return n;
        } else {
            int recurse = prod(m, n-1);
            int result = n * recurse;
            return result;
        }
    }

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/ThirteenthDay/test.txt"));

            List<Bus> list = new ArrayList<>();

            String line;
            line = br.readLine();
            int nr = Integer.parseInt(line);
            line = br.readLine();
            String[] strings = line.split(",");
            int j = 0;
            int k = 0;
            long id_production = 1;
            for (int i = 0; i < strings.length; i++) {
                if (isStringInt(strings[i])) {
                    list.add(new Bus(Integer.parseInt(strings[i]), j));
                    id_production *= list.get(k).getNrBus();
                    k++;
                }
                j++;
            }
            System.out.println(id_production);
            for (Bus i : list){
                System.out.println(i);
            }

            // chinese_remainder_theorem
            long x = 0;
            for (Bus i : list) {
                long info = i.getNrX();
                long bi = (i.getNrBus() - info) % i.getNrBus();
                long ni = id_production / i.getNrBus();
                long c = ni % i.getNrBus();
                long xi = 1;
                while ((c * xi) % i.getNrBus() != 1)  {
                    xi++;
                }
                x += bi * ni * xi;
            }
            long t = x % id_production;
            System.out.println(t);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }

}