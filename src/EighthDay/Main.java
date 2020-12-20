package EighthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int accumulator;
    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/EighthDay/test.txt"));

            List<Instruction> allInstrucions = new ArrayList<>();

            accumulator = 0;
            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                allInstrucions.add(new Instruction(line));
            }
            int position = 0;
            while (!allInstrucions.get(position).isVisited()) {
                allInstrucions.get(position).setVisited(true);
                switch (allInstrucions.get(position).getInstruction()) {
                    case acc:
                        accumulator += allInstrucions.get(position).getInstrArg();
                        position++;
                        break;
                    case jmp:
                        position += allInstrucions.get(position).getInstrArg();
                        break;
                    case nop:
                        position++;
                        break;
                }
            }
            System.out.println(accumulator);
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}
