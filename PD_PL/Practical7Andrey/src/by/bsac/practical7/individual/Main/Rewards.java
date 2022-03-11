package by.bsac.practical7.individual.Main;

public class Rewards extends Taxes{ // вознагрождения

    public Rewards() {
        super();
    }

    public Rewards(double taxrate, double sum) {
        super(taxrate, sum);
    }



    @Override
    public String toString() {
        return "Вознагрождения{" +
                "налоговая ставка=" + getTaxrate() +
                ", сумма=" + getSum() +
                '}';
    }
}
