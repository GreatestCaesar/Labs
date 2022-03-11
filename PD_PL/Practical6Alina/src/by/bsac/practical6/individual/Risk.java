package by.bsac.practical6.individual;

public class Risk extends Strahovanie{

    public int amountOfRisk;// количество рисков

    public Risk() { this.amountOfRisk = 5; }
    public Risk(int amountOfRisk) { this.amountOfRisk = amountOfRisk; }
    public int getAmountOfRisk() {
        return amountOfRisk;
    }

    public void setAmountOfRisk(int amountOfRisk) {
        this.amountOfRisk = amountOfRisk;
    }

    @Override
    public String toString() {
        return "Risk [amountOfRisk=" + amountOfRisk + "]";
    }
}
