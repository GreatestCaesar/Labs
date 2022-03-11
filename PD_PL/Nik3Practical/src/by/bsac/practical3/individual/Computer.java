package by.bsac.practical3.individual;

public class Computer extends RAM{ // компьютер
    private String soft; // ОС
    private String model; // модель видеокарты
    private boolean on; // вкл/выкл

    public Computer(String model, double width, int memsize, double speed, String mark, double speed1, String type, int num, double freec, int chan, double frec, int size, int num1, double volt, String soft, String model1, boolean on) {
        super(model, width, memsize, speed, mark, speed1, type, num, freec, chan, frec, size, num1, volt);
        this.soft = soft;
        this.model = model1;
        this.on = on;
    }

    public Computer(String mark, double speed, String type, int num, double freec, int chan, double frec, int size, int num1, double volt, String soft, String model, boolean on) {
        super(mark, speed, type, num, freec, chan, frec, size, num1, volt);
        this.soft = soft;
        this.model = model;
        this.on = on;
    }

    public Computer(int num, double freec, int chan, double frec, int size, int num1, double volt, String soft, String model, boolean on) {
        super(num, freec, chan, frec, size, num1, volt);
        this.soft = soft;
        this.model = model;
        this.on = on;
    }

    public Computer(double frec, int size, int num, double volt, String soft, String model, boolean on) {
        super(frec, size, num, volt);
        this.soft = soft;
        this.model = model;
        this.on = on;
    }

    public Computer(String soft, String model, boolean on) {
        this.soft = soft;
        this.model = model;
        this.on = on;
    }

    public Computer() {
        soft = "";
        model = "";
        on = true;
    }

    public String getSoft() {
        return soft;
    }

    public void setSoft(String soft) {
        this.soft = soft;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void on_off(int n){
        switch (n){
            case 1:{
                System.out.println("Компьютер включен");
                on = true;
                break;
            }
            case 2:{
                System.out.println("Компьютер выключен");
                on = false;
                break;
            }
        }
    }

    public int win(){
        return getMemsize();
    }

    public void virus(){
        System.out.println("Вирусы не обнаружены");
    }

    @Override
    public String toString() {
        return "Компьютер{" +
                "ОС='" + soft + '\'' +
                ", модель='" + model + '\'' +
                ", включен=" + on +
                '}';
    }
}
