package ThirteenthDay;

public class Bus {
    private int nrBus;
    private int  nrX;

    public Bus(int nrBus, int nrX) {
        this.nrBus = nrBus;
        this.nrX = nrX;
    }

    public void setNrX() {
        this.nrX++;
    }

    public int getNrBus() {
        return nrBus;
    }

    public void setNrBus(int nrBus) {
        this.nrBus = nrBus;
    }

    public int getNrX() {
        return nrX;
    }

    public void setNrX(int nrX) {
        this.nrX = nrX;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "nrBus=" + nrBus +
                ", nrX=" + nrX +
                '}';
    }
}
