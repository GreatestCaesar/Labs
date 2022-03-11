package by.bsac.practical3.individual;

public class CPU extends Drive{ // процессор
    private int num; // кол-во ядер
    private double freec; // тактовая частота
    private int chan; // кол-во каналов памяти

    public CPU(String model, double width, int memsize, double speed, String mark, double speed1, String type, int num, double freec, int chan) {
        super(model, width, memsize, speed, mark, speed1, type);
        this.num = num;
        this.freec = freec;
        this.chan = chan;
    }

    public CPU(String mark, double speed, String type, int num, double freec, int chan) {
        super(mark, speed, type);
        this.num = num;
        this.freec = freec;
        this.chan = chan;
    }

    public CPU(int num, double freec, int chan) {
        this.num = num;
        this.freec = freec;
        this.chan = chan;
    }

    public CPU() {
        num = 0;
        freec = 0;
        chan = 0;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getFreec() {
        return freec;
    }

    public void setFreec(double freec) {
        this.freec = freec;
    }

    public int getChan() {
        return chan;
    }

    public void setChan(int chan) {
        this.chan = chan;
    }

    @Override
    public String toString() {
        return "Процессор{" +
                "кол-во ядер=" + num +
                ", частота=" + freec +
                ", кол-во каналов=" + chan +
                '}';
    }
}
