package by.bsac.practical7.individual.lab;

public class Derivativ extends Risk{
    public int amountOfRisk;//количество рисков
    public int cost;// стоимость
    public double degree;//степень рисков

    public Derivativ() {
        super();
        this. amountOfRisk = 5;
        this.cost = 200;
        this.degree = 10;
    }

    public Derivativ(int amountOfRisk, int cost, double degree) {
        super();
        this. amountOfRisk = amountOfRisk;
        this.cost = cost;
        this.degree = degree;
    }

    public int getAmountOfRisk() {
        return amountOfRisk;
    }

    public void setAmountOfRisk(int amountOfRisk) { this.amountOfRisk = amountOfRisk;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Derivativ [amountOfRisk=" + amountOfRisk + ", cost=" + cost + ", degree=" + degree + "]";
    }
}