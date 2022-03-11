package by.bsac.lab4.individual.Timer;

public class Watch {
    private String brand; // марка
    private String model; // модель(коллекция)
    private String type; // тип механические/кварцевые
    private double price; // цена
    private int quantity; // количество
    private String requisites; // реквизиты

    public Watch(String brand, String model, String type, double price, int quantity, String requisites) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.requisites = requisites;
    }

    public Watch() {

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public String toString() {
        return "Часы '" + getBrand() + '\'' + ", модель '" + getModel() + '\'' + ", тип '" + getType() + '\'' + ", цена " + getPrice() + ", количество " + getQuantity() + ", рекзвизиты '" + getRequisites() + '\'';
    }
}
