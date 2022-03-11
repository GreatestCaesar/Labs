package by.bsac.practical3.individual;

public class Winchester { // винчестер
    private String model; // модель
    private double width; // ширина
    private int memsize; // объем памяти
    private double speed; // линейная скорость

    public Winchester(String model, double width, int memsize, double speed) {
        this.model = model;
        this.width = width;
        this.memsize = memsize;
        this.speed = speed;
    }

    public Winchester() {
        model = "";
        width = 0;
        memsize = 0;
        speed = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getMemsize() {
        return memsize;
    }

    public void setMemsize(int memsize) {
        this.memsize = memsize;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Винчестер{" +
                "модель='" + model + '\'' +
                ", ширина=" + width +
                ", объем памяти=" + memsize +
                ", скорость=" + speed +
                '}';
    }
}
