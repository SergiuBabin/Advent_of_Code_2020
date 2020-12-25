package FourteenthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/FourteenthDay/test.txt"));

            String line;
            char[] bitMask = new char[36];
            Map<Integer, Long> memory = new HashMap<>();
            while ((line = br.readLine()) != null) {
                debug = line;
                String[] parts = line.split("=");
                if (parts[0].trim().equals("mask")) {
                    bitMask = parts[1].trim().toCharArray();

                } else {
                    int index = Integer.parseInt(parts[0].substring(4, parts[0].length() - 2));
                    String number = String.format("%36s", Integer.toBinaryString(Integer.parseInt(parts[1].trim()))).replace(" ", "0");
                    long result = 0;
                    for (int i = 0; i < bitMask.length; i++) {
                        if (bitMask[i] != 'X') {
                            result = (result << 1) | Integer.parseInt(String.valueOf(bitMask[i]));
                        } else {
                            result = (result << 1) | Integer.parseInt(String.valueOf(number.charAt(i)));
                        }
                    }
                    System.out.println(index + " " + result);
                    memory.put(index, result);
                }
            }
            long sum = 0;
            for (Long value : memory.values()) {
                sum += value;
            }
            System.out.println(sum);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
