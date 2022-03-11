package by.bsac.practical3.individual;

public class Drive extends Winchester{ // дисковод
    private String mark; // бренд
    private double speed; // скорость чтения
    private String type; // тип установки(внутренний/внешний)

    public Drive(String model, double width, int memsize, double speed, String mark, double speed1, String type) {
        super(model, width, memsize, speed);
        this.mark = mark;
        this.speed = speed1;
        this.type = type;
    }

    public Drive(String mark, double speed, String type) {
        this.mark = mark;
        this.speed = speed;
        this.type = type;
    }

    public Drive() {
        mark = "";
        speed = 0;
        type = "";
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Дисковод{" +
                "бренд='" + mark + '\'' +
                ", скорость=" + speed +
                ", тип установки='" + type + '\'' +
                '}';
    }
}
