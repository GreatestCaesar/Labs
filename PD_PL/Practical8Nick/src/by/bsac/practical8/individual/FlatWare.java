package by.bsac.practical8.individual;

public class FlatWare {
    private String type; // тип (нож, вилка, ложка и т. д.)
    private String origin; // страна производства
    private String type1; // лезвие, зубец
    private double length; // длина
    private double width; // ширина
    private String material; // материал
    private String value; // коллекционный

    public FlatWare(){

    }

    public FlatWare(String type, String origin, String type1, double length, double width, String material, String value) {
        this.type = type;
        this.origin = origin;
        this.type1 = type1;
        this.length = length;
        this.width = width;
        this.material = material;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Столовые приборы{" +
                "тип='" + type + '\'' +
                ", страна='" + origin + '\'' +
                ", тип='" + type1 + '\'' +
                ", длина=" + length +
                ", ширина=" + width +
                ", материал='" + material + '\'' +
                ", коллекционный='" + value + '\'' +
                '}';
    }
}
