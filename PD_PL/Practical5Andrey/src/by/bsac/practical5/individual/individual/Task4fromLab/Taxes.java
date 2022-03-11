package by.bsac.practical5.individual.individual.Task4fromLab;

import java.util.Scanner;

public class Taxes { // налоги
    private double taxrate; // налоговая ставка
    private double sum; // сумма налога

    public Taxes() {
        taxrate = 0;
        sum = 0;
    }

    public Taxes(double taxrate, double sum) {
        this.taxrate = taxrate;
        this.sum = sum;
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

    public Taxes[] sort(Taxes[] t){
        Taxes ta = new Taxes();
        for(int i=0;i<t.length;i++){
            for (int j=i+1;j<t.length;j++){
                if(t[i].getSum() < t[j].getSum()){
                    ta = t[i];
                    t[i] = t[j];
                    t[j] = ta;
                }
            }
        }
        return t;
    }

    public Taxes[] create(Taxes[] t){
        Scanner s = new Scanner(System.in);
        int tax = 0;
        try{
            System.out.println("Введите налоговую ставку для места работы");
            tax = s.nextInt();
            if(tax>3){
                throw new MyException(tax);
            }
            tax = 0;
        }catch (Exception e){
            System.out.println(e);
        }
        t[0] = new PlaceOfWork(tax,10000);
        try{
            System.out.println("Введите налоговую ставку для вознагрождения");
            tax = s.nextInt();
            if(tax>7){
                throw new MyException(tax);                                                         // исключение
            }
            tax = 0;
        }catch (Exception e){
            System.out.println(e);
        }
        t[1] = new Rewards(tax,5000);
        try{
            System.out.println("Введите налоговую ставку для льгот");
            tax = s.nextInt();
            if(tax>20){
                throw new MyException(tax);
            }
            tax = 0;
        }catch (Exception e){
            System.out.println(e);
        }
        t[2] = new Privileges(tax,25000);
        return t;
    }

    @Override
    public String toString() {
        return "Налоги{" +
                "налоговая ставка=" + taxrate +
                ", сумма=" + sum +
                '}';
    }
}
