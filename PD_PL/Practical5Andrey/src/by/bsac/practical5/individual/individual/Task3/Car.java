package by.bsac.practical5.individual.individual.Task3;

public class Car { // автомобиль
    private String mark; // марка
    private double fuel; // количество топлива
    private String body; // тип кузова
    private int year; // год выпуска

    private Car(String mark, double fuel, String body, int year) {
        this.mark = mark;
        this.fuel = fuel;
        this.body = body;
        this.year = year;
    }

    public Car() {
        super();
        this.mark = mark;
        this.fuel = fuel;
        this.body = body;
        this.year = year;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String Mark(){
        return "Марка авто: " + mark;
    }

    public void Fuel(){
        if(fuel<5){
            System.out.println("Топливо на минимуме, заправтесь как можно скорее!");
        }
    }

    @Override
    public String toString() {
        return "Автомобиль{" +
                "марка='" + mark + '\'' +
                ", кол-во топлива=" + fuel +
                ", кузов='" + body + '\'' +
                ", год производства=" + year +
                '}';
    }
}
