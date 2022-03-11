package by.bsac.practical7.individual.Main;

public class Helmet extends Motorcyclist{
    public Helmet() {
    }

    public Helmet(String material, double size, double price, double wtight) {
        super(material, size, price, wtight);
    }

    public String toString() {
        return "Шлем{" +
                "материал='" + getMaterial() + '\'' +
                ", размер=" + getSize() +
                ", цена=" + getPrice() +
                ", вес=" + getWtight() +
                '}';
    }
}
