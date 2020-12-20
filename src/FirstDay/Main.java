package FirstDay;

import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("src/FirstDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        List<Integer> integers = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            integers.add(Integer.parseInt(st));
        }

        int n;
        boolean STOP = true;
        Collections.sort(integers);
        for (int i = 0; i < integers.size() && STOP; i++) {
            for (int j = i; j < integers.size() && STOP; j++) {
                n = 2020 - integers.get(i) - integers.get(j);
                if (integers.indexOf(n) != -1) {
                    System.out.println(integers.get(i) + " * " + integers.get(j) + " * " + integers.get(integers.indexOf(n))
                            + " = " + integers.get(i) * integers.get(j) * integers.get(integers.indexOf(n)));
                    STOP = false;
                }
            }
        }
    }
}
