package TwelfthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void way(List<Action> list) {
        int dir = 0;
        int x = 0;
        int y = 0;
        for(Action i : list) {
            if (i.getDirection().equals("F")) {
                switch (dir) {
                    case 0:
                        x += i.getDistance();
                        break;
                    case 1:
                        y += i.getDistance();
                        break;
                    case 2:
                        x -= i.getDistance();
                        break;
                    case 3:
                        y -= i.getDistance();
                        break;
                }
            }

            if (i.getDirection().equals("R")) {
                dir -= i.getDistance() / 90;
                dir = (dir < 0) ? dir + 4 : dir;
            }

            if (i.getDirection().equals("L")) {
                dir += i.getDistance() / 90;
                dir = (dir > 3) ? dir - 4 : dir;
            }

            if (i.getDirection().equals("N"))
                y += i.getDistance();
            if (i.getDirection().equals("S"))
                y -= i.getDistance();
            if (i.getDirection().equals("W"))
                x -= i.getDistance();
            if (i.getDirection().equals("E"))
                x += i.getDistance();
        }
        System.out.println(Math.abs(x) + Math.abs(y));
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
