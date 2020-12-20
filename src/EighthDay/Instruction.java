package EighthDay;
enum Instr {
    acc,
    nop,
    jmp
}

public class Instruction {
    private Instr instruction;
    private int instrArg;
    private boolean visited;

    public Instruction(String line) {
        String[] arr = line.split(" ");
        this.instrArg = Integer.parseInt(arr[1]);
        this.instruction = Instr.valueOf(arr[0]);

    }

    public Instr getInstruction() {
        return instruction;
    }

    public void setInstruction(Instr instruction) {
        this.instruction = instruction;
    }

    public int getInstrArg() {
        return instrArg;
    }

    public void setInstrArg(int instrArg) {
        this.instrArg = instrArg;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
