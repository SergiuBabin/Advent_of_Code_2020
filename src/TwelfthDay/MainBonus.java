package TwelfthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class MainBonus {
    public static void way(List<Action> list) {
        int dir = 0;
        int shipX = 0;
        int shipY = 0;
        int wayX = 10;
        int wayY = 1;
        for(Action i : list) {
            if (i.getDirection().equals("F")) {
                shipX += wayX * i.getDistance();
                shipY += wayY * i.getDistance();
            }

            if (i.getDirection().equals("R") || i.getDirection().equals("L")) {
                double angle = Math.toRadians(i.getDistance());
                int semnX = -1;
                int semnY = 1;
                if (i.getDirection().equals("R")) {
                    semnX = 1;
                    semnY = -1;
                }

                switch (i.getDistance()/90) {
                    case 1:
                        int temp = wayX;
                        wayX = semnX * wayY;
                        wayY = semnY * temp;
                        break;
                    case 2:
                        wayX = -wayX;
                        wayY = -wayY;
                        break;
                    case 3:
                        temp = wayX;
                        wayX = semnY * wayY;
                        wayY = semnX * temp;
                        break;
                }
            }

            if (i.getDirection().equals("N"))
                wayY += i.getDistance();
            if (i.getDirection().equals("S"))
                wayY -= i.getDistance();
            if (i.getDirection().equals("W"))
                wayX -= i.getDistance();
            if (i.getDirection().equals("E"))
                wayX += i.getDistance();
            // System.out.println("wayX = "+ wayX +" wayY = " + wayY +"                    "+ i);
        }
        System.out.println(Math.abs(shipX) + Math.abs(shipY));
    }


    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/TwelfthDay/test.txt"));

            List<Action> list = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                list.add(new Action(line));
            }
            way(list);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
