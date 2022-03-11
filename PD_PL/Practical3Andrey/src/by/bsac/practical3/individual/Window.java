package by.bsac.practical3.individual;

public class Window {
    private String material; // материал
    private double height; // высота
    private double width; // ширина
    private String color; // цвет
    private int num; // кол-во режимов открывания
    private int glass; // кол-во стекол

    public Window(String material, double height, double width, String color, int num, int glass) {
        this.material = material;
        this.height = height;
        this.width = width;
        this.color = color;
        this.num = num;
        this.glass = glass;
    }

    public Window() {
        material = "";
        height = 0;
        width = 0;
        color = "";
        num = 0;
        glass = 0;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getGlass() {
        return glass;
    }

    public void setGlass(int glass) {
        this.glass = glass;
    }

    @Override
    public String toString() {
        return "Окно{" +
                "материал='" + material + '\'' +
                ", высота=" + height +
                ", ширина=" + width +
                ", цвет='" + color + '\'' +
                ", кол-во режимов открытия=" + num +
                ", кол-во стёкол=" + glass +
                '}';
    }
}
