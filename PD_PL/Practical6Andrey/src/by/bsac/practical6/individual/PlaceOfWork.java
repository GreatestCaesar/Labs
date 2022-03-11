package by.bsac.practical6.individual;

import java.util.Scanner;

public class PlaceOfWork{ // место работы
    private double taxrate; // налоговая ставка
    private double sum; // сумма налога

    PlaceOfWork(){
        taxrate = 0;
        sum = 0;
    }

    public void create(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введите налоговую ставку для места работы: ");
        setTaxrate(s.nextDouble());
        System.out.println("Введите сумму налога: ");
        setSum(s.nextDouble());
        toString();
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
        return "Место работы{" +
                "ставка=" + getTaxrate() +
                ", сумма=" + getSum() +
                '}';
    }
}
