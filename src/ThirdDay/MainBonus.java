package ThirdDay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class MainBonus {
    public static void main(String[] args) throws Exception {
        File file = new File("src/ThirdDay/test.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int i = 3, j = 1, k = 5, p = 7, l = 1;
        int  nri = 0, nrj = 0, nrk = 0, nrp = 0, nrl = 0;
        boolean evenLine = false;
        br.readLine();
        while ((st = br.readLine()) != null) {
            if (st.length() - 1 < i) {
                i -= st.length();
            }

            if (st.length() - 1 < j) {
                j -= st.length();
            }

            if (st.length() - 1 < k) {
                k -= st.length();
            }

            if (st.length() - 1 < p) {
                p -= st.length();
            }

            if (st.length() - 1 < l) {
                l -= st.length();
            }

            if (evenLine) {
                if (st.charAt(l) == '#') {
                    nrl++;
                }
                evenLine = false;
                l += 1;
            } else {
                evenLine = true;

            }


            if (st.charAt(i) == '#') {
                nri++;
            }

            if (st.charAt(j) == '#') {
                nrj++;
            }

            if (st.charAt(k) == '#') {
                nrk++;
            }

            if (st.charAt(p) == '#') {
                nrp++;
            }

            i += 3;
            j += 1;
            k += 5;
            p += 7;


        }

        System.out.println(nri);
        System.out.println(nrj);
        System.out.println(nrk);
        System.out.println(nrp);
        System.out.println(nrl);
        BigInteger c = new BigInteger(String.valueOf(nri * nrj * nrk * nrl * nrp));
        System.out.println(c);
    }
}