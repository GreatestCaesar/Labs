package by.bsac.lab4.individual.Manufacturer;

public class Manufacturer {                         /** Класс, для представления производителя */
    private String brand; // марка
    private String county; // страна производтсва

    public Manufacturer(String brand, String county) {
        this.brand = brand;
        this.county = county;
    }

    public Manufacturer() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public String toString() {
        return "Производитель '" + brand + '\'' + ", страна '" + county + '\'' + '}';
    }
}