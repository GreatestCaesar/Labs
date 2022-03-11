package by.bsac.individual;

public class Wheel{ // колесо
    private double height; // высота протектора
    private String name; // название
    private String type; // тип резины
    private double radius; // радиус
    private double width; // ширина

    Wheel(){
        height = 0;
        name = "";
        type = "";
        radius = 0;
        width = 0;
    }

    Wheel(double height, String name, String type, double radius, double width){
        this.height = height;
        this.name = name;
        this.type = type;
        this.radius = radius;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String Change(){
        String str;
        if(getHeight() < 1.6){
            str = "Колесо стоит заменить";
        }else{
            str = "Колесо в норме";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Колесо{" +
                "высота протектора=" + height +
                ", название='" + name + '\'' +
                ", тип='" + type + '\'' +
                ", радиус=" + radius +
                ", ширина=" + width +
                '}';
    }
}
