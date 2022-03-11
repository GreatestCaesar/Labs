package by.bsac.practical6.individual;

public class Costume extends Motorcyclist{
    public Costume() {
    }

    public Costume(String material, double size, double price, double wtight) {
        super(material, size, price, wtight);
    }

    public String toString() {
        return "Костюм{" +
                "материал='" + getMaterial() + '\'' +
                ", размер=" + getSize() +
                ", цена=" + getPrice() +
                ", вес=" + getWtight() +
                '}';
    }
}
