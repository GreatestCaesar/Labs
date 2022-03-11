package by.bsac.practical5.individual.individual.Task4fromLab;

public class Privileges extends Taxes{ // льготы
    public Privileges() {
        super();
    }

    public Privileges(double taxrate, double sum) {
        super(taxrate, sum);
    }

    @Override
    public String toString() {
        return "Льготы{" +
                "налоговая ставка=" + getTaxrate() +
                ", сумма=" + getSum() +
                '}';
    }
}
