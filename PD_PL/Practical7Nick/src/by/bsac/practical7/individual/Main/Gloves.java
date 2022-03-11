package by.bsac.practical7.individual.Main;

public class Gloves extends Motorcyclist{
    public Gloves() {
    }

    public Gloves(String material, double size, double price, double wtight) {
        super(material, size, price, wtight);
    }

    public String toString() {
        return "Перчатки{" +
                "материал='" + getMaterial() + '\'' +
                ", размер=" + getSize() +
                ", цена=" + getPrice() +
                ", вес=" + getWtight() +
                '}';
    }
}
