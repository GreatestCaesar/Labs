package by.bsac.practical7.individual.Main;

public class Boots extends Motorcyclist{
    public Boots(String material, double size, double price, double wtight) {
        super(material, size, price, wtight);
    }

    public Boots() {
    }

    public String toString() {
        return "Сапоги{" +
                "материал='" + getMaterial() + '\'' +
                ", размер=" + getSize() +
                ", цена=" + getPrice() +
                ", вес=" + getWtight() +
                '}';
    }
}
