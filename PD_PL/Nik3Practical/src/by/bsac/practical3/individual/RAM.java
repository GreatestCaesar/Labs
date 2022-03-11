package by.bsac.practical3.individual;

public class RAM extends CPU{ // оперативная память
    private double frec; // частота
    private int size; // Объем
    private int num; // кол-во модулей
    private double volt; // напряжение

    public RAM(String model, double width, int memsize, double speed, String mark, double speed1, String type, int num, double freec, int chan, double frec, int size, int num1, double volt) {
        super(model, width, memsize, speed, mark, speed1, type, num, freec, chan);
        this.frec = frec;
        this.size = size;
        this.num = num1;
        this.volt = volt;
    }

    public RAM(String mark, double speed, String type, int num, double freec, int chan, double frec, int size, int num1, double volt) {
        super(mark, speed, type, num, freec, chan);
        this.frec = frec;
        this.size = size;
        this.num = num1;
        this.volt = volt;
    }

    public RAM(int num, double freec, int chan, double frec, int size, int num1, double volt) {
        super(num, freec, chan);
        this.frec = frec;
        this.size = size;
        this.num = num1;
        this.volt = volt;
    }

    public RAM(double frec, int size, int num, double volt) {
        this.frec = frec;
        this.size = size;
        this.num = num;
        this.volt = volt;
    }

    public RAM() {
        frec = 0;
        size = 0;
        num = 0;
        volt = 0;
    }

    public double getFrec() {
        return frec;
    }

    public void setFrec(double frec) {
        this.frec = frec;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    public double getVolt() {
        return volt;
    }

    public void setVolt(double volt) {
        this.volt = volt;
    }

    @Override
    public String toString() {
        return "Оперативная память{" +
                "частота=" + frec +
                ", объем=" + size +
                ", кол-во модулей=" + num +
                ", напряжение=" + volt +
                '}';
    }
}
