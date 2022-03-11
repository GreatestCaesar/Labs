package by.bsac.practical8.individual;

public class Candy {
    private String name;
    private double energy;
    private String type;
    private double shugar;
    private double fructose;
    private double vanilin;
    private double proteins;
    private double fats;
    private double carbohydrates;
    private String production;

    public Candy(String name, double energy, String type, double shugar, double fructose, double vanilin, double proteins, double fats, double carbohydrates, String production) {
        this.name = name;
        this.energy = energy;
        this.type = type;
        this.shugar = shugar;
        this.fructose = fructose;
        this.vanilin = vanilin;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.production = production;
    }

    public Candy(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getShugar() {
        return shugar;
    }

    public void setShugar(double shugar) {
        this.shugar = shugar;
    }

    public double getFructose() {
        return fructose;
    }

    public void setFructose(double fructose) {
        this.fructose = fructose;
    }

    public double getVanilin() {
        return vanilin;
    }

    public void setVanilin(double vanilin) {
        this.vanilin = vanilin;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    @Override
    public String toString() {
        return "Конфета {" + getName()
                + " Калорийность " + getEnergy()
                + ", Тип " + getType()
                + ", Сахар " + getShugar()
                + ", Фруктоза " + getFructose()
                + ", Ванилин " + getVanilin()
                + ", Белки " + getFats()
                + ", Углеводы " + getCarbohydrates()
                + ", Произведено в " + getProduction()
                + " }";
    }
}
