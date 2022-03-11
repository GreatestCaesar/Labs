package Task2;

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
        t[0] = new PlaceOfWork(0.5,10000);
        t[1] = new Rewards(1.2,5000);
        t[2] = new Privileges(13,25000);
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
