package FourthDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainBonus {
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
                String str = s.nextToken();
                int n;
                switch (a) {
                    case "ecl":
                        ecl = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(str);
                        break;
                    case "pid":
                        pid = str.length() == 9 && str.matches("[0-9]+");
                        break;
                    case "eyr":
                        n = Integer.parseInt(str);
                        eyr = n >= 2020 && n <= 2030;
                        break;
                    case "byr":
                        n = Integer.parseInt(str);
                        byr = n >= 1920 && n <= 2002;
                        break;
                    case "iyr":
                        n = Integer.parseInt(str);
                        iyr = n >= 2010 && n <= 2020;
                        break;
                    case "hgt":
                        if (str.length() > 2) {
                            int r = Integer.parseInt(str.substring(0, str.length() - 2));
                            String unit = str.substring(str.length() - 2);
                            if (unit.equals("cm")) {
                                hgt = r >= 150 && r <= 193;
                            } else if (unit.equals("in")) {
                                hgt = r >= 59 && r <= 76;
                            }
                        }
                        break;
                    case "hcl":
                        hcl = str.matches("#[0-9a-f]{6}");
                        break;
                }
            }

            if (ecl == true && pid == true && eyr == true && byr == true && iyr == true && hcl == true && hgt == true && st.length() == 0) {
                nr++;
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
