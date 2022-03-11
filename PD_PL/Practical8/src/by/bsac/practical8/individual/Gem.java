package by.bsac.practical8.individual;

public class Gem {
    private String name;
    private String preciousness;
    private String origin;
    private String color;
    private double transparence;
    private int value;

    public Gem(String name, String preciousness, String origin, String color, double transparence, int value) {
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.color = color;
        this.transparence = transparence;
        this.value = value;
    }

    public Gem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTransparence() {
        return transparence;
    }

    public void setTransparence(double transparence) {
        this.transparence = transparence;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "~ Драгоценный камень ~" +
                "\nНазвание: " + name +
                "\nДрагоценность: " + preciousness +
                "\nМесто добывания: " + origin +
                "\nЦвет: " + color +
                "\nПрозрачность: " + transparence + "%" +
                "\nВес: " + value + " карат" +
                "\n------------------------------------------------";
    }
}