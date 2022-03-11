package classes;

public class Sale {
    private int idsales;
    private String model;
    private String seller;
    private int cost;
    private String date;

    public Sale(int idsales, String model, String seller, int cost, String date) {
        this.idsales = idsales;
        this.model = model;
        this.seller = seller;
        this.cost = cost;
        this.date = date;
    }

    public Sale(String model, String seller, int cost, String date) {
        this.model = model;
        this.seller = seller;
        this.cost = cost;
        this.date = date;
    }

    public Sale(){}

    public int getIdsales() {
        return idsales;
    }
    public void setIdsales(int idsales) {
        this.idsales = idsales;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
