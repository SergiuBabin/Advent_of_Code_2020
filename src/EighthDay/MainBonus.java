package EighthDay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class MainBonus {

    public static void main(String[] args) {
        String debug = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/EighthDay/test.txt"));

            List<Instruction> allInstrucions = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                debug = line;
                allInstrucions.add(new Instruction(line));
            }

            for (int i = 0; i < allInstrucions.size(); i++) {
                int position = 0;
                int acc = 0;
                for (Instruction k : allInstrucions) {
                    k.setVisited(false);
                }
                if (allInstrucions.get(i).getInstruction() == Instr.jmp) {
                    allInstrucions.get(i).setInstruction(Instr.nop);
                } else {
                    if (allInstrucions.get(i).getInstruction() == Instr.nop) {
                        allInstrucions.get(i).setInstruction(Instr.jmp);
                    }
                }
                while (!allInstrucions.get(position).isVisited()) {
                    allInstrucions.get(position).setVisited(true);
                    switch (allInstrucions.get(position).getInstruction()) {
                        case acc:
                            acc += allInstrucions.get(position).getInstrArg();
                            position++;
                            break;
                        case jmp:
                            position += allInstrucions.get(position).getInstrArg();
                            break;
                        case nop:
                            position++;
                            break;
                    }
                    if (position == allInstrucions.size()) {
                        break;
                    }
                }

                if (allInstrucions.get(i).getInstruction() == Instr.jmp) {
                    allInstrucions.get(i).setInstruction(Instr.nop);
                } else {
                    if (allInstrucions.get(i).getInstruction() == Instr.nop) {
                        allInstrucions.get(i).setInstruction(Instr.jmp);
                    }
                }

                if (position == allInstrucions.size()) {
                    System.out.println(acc);
                }
            }
        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}