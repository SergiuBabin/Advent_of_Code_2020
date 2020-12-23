package EleventhDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static boolean noChanges;
    public static char[][] deepCopy(char[][] original) {
        if (original == null) {
            return null;
        }

        final char[][] result = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    public static char[][] modeling(char[][] seats) {
        char[][] seat;
        seat = deepCopy(seats);
        noChanges = false;
        for (int i = 1; i < seats.length - 1; i++) {
            for (int j = 1; j < seats[i].length - 1; j++) {
                if (seats[i][j] == '#') {
                    int nrOccupied = 0;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int p = j - 1; p <= j + 1; p++) {
                            if (seats[k][p] == '#') {
                                nrOccupied++;
                            }
                        }
                        if (nrOccupied >= 5) break;
                    }
                    if (nrOccupied >= 5) {
                        seat[i][j] = 'L';
                        noChanges = true;
                    }
                } else if (seats[i][j] == 'L'){
                    boolean isEmpty = true;
                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int p = j - 1; p <= j + 1; p++) {
                            if (seats[k][p] == '#') {
                                isEmpty = false;
                                break;
                            }
                        }
                        if (!isEmpty) {
                            break;
                        }
                    }
                    if (isEmpty) {
                        seat[i][j] = '#';
                        noChanges = true;
                    }
                }
            }
        }
        return seat;
    }

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/EleventhDay/test.txt"));

            List<List<Character>> list = new ArrayList<>();
            List<Character> k = new ArrayList<>();
            String line;
            line = br.readLine();
            char[] strk = line.toCharArray();
            k.add('.');
            for (char i : strk) {
                k.add('.');
            }
            k.add('.');
            list.add(k);
            List<Character> r = new ArrayList<>();
            r.add('.');
            for (char i : strk) {
                r.add(i);
            }
            r.add('.');

            list.add(r);
            while ((line = br.readLine()) != null) {
                List<Character> l = new ArrayList<>();
                debug = line;
                char[] str = line.toCharArray();
                l.add('.');
                for (char i : str) {
                    l.add(i);
                }
                l.add('.');
                list.add(l);
            }
            list.add(k);
            char[][] seat = new char[list.size()][list.get(0).size()];
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    seat[i][j] = list.get(i).get(j);
                }
            }
            noChanges = true;
            char[][] seats = modeling(seat);
            while (noChanges) {
                seat = deepCopy(seats);
                seats = modeling(seat);
            }
            int nrOfOccupiedSeats = 0;
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < seats[i].length; j++) {
                    if (seats[i][j] == '#') {
                        nrOfOccupiedSeats++;
                    }
                }
            }
            System.out.println(nrOfOccupiedSeats);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
