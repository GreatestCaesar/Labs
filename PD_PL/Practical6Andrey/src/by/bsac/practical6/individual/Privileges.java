package by.bsac.practical6.individual;

import java.util.Scanner;

public class Privileges{ // льготы
    private double taxrate; // налоговая ставка
    private double sum; // сумма налог

    Privileges(){
        taxrate = 0;
        sum = 0;
    }

    public void create(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введите налоговую ставку для льгот: ");
        setTaxrate(s.nextDouble());
        System.out.println("Введите сумму налога: ");
        setSum(s.nextDouble());
    }

    public double getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(double taxrate) {
        this.taxrate = taxrate;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Льготы{" +
                "ставка=" + getTaxrate() +
                ", сумма=" + getSum() +
                '}';
    }
}
