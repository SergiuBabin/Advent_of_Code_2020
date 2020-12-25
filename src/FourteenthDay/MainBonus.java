package FourteenthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainBonus {

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/FourteenthDay/test.txt"));

            String line;
            char[] bitMask = new char[36];
            Map<String, Long> memory = new HashMap<>();
            while ((line = br.readLine()) != null) {
                debug = line;
                String[] parts = line.split("=");
                if(parts[0].trim().equals("mask"))
                {
                    bitMask = parts[1].trim().toCharArray();
                }
                else
                {
                    List<char[]> address = new ArrayList<>();
                    int index = Integer.parseInt(parts[0].substring(4, parts[0].length() - 2));
                    address.add(String.format("%36s", Integer.toBinaryString(index)).replace(" ", "0").toCharArray());

                    long number = Integer.parseInt(parts[1].trim());
                    for(int i = 0; i < bitMask.length; i++)
                    {
                        for(int j = address.size() - 1; j >= 0; j--)
                        {
                            char[] addressEdit = address.remove(j);
                            if(bitMask[i] == 'X')
                            {
                                addressEdit[i] = '0';
                                address.add(addressEdit);
                                char[] clone = addressEdit.clone();
                                clone[i] = '1';
                                address.add(clone);
                            }
                            else if(bitMask[i] == '1')
                            {
                                addressEdit[i] = '1';
                                address.add(addressEdit);
                            }
                            else
                            {
                                address.add(addressEdit);
                            }
                        }
                    }

                    for(char[] addr : address)
                        memory.put(new String(addr), number);
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
