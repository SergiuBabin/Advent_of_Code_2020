package SeventhDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MainBonus {

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/SeventhDay/test.txt"));

            List<Bag> allBags = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                allBags.add(new Bag(line));
            }

            long numberOfBags = 0;
            for (Bag b : allBags) {
                if (b.getName().equals("shiny gold")) {
                    System.out.println(b.containsNumberOfBags(allBags));
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}

