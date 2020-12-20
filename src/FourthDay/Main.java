package FourthDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("src/FourthDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int nr = 0;
        boolean ecl = false, pid = false, eyr = false, byr = false, iyr = false, hcl = false, hgt = false;


        while ((st = br.readLine()) != null) {
            StringTokenizer s = new StringTokenizer(st, " :");


            while (s.hasMoreTokens()) {
                String a = s.nextToken();
                switch (a) {
                    case "ecl":
                        ecl = true;
                        break;
                    case "pid":
                        pid = true;
                        break;
                    case "eyr":
                        eyr = true;
                        break;
                    case "byr":
                        byr = true;
                        break;
                    case "iyr":
                        iyr = true;
                        break;
                    case "hgt":
                        hgt = true;
                        break;
                    case "hcl":
                        hcl = true;
                        break;
                }

                s.nextToken();
            }

            if (ecl == true && pid == true && eyr == true && byr == true && iyr == true && hcl == true && hgt == true && st.length() == 0) {
                nr++;
                System.out.println(st + " " + nr);
            }

            if (st.length() == 0) {
                ecl = false;
                pid = false;
                eyr = false;
                byr = false;
                iyr = false;
                hcl = false;
                hgt = false;
            }
        }
        System.out.println(nr);
    }
}