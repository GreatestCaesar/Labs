package Task2;

public class Main {
    public static void main(String[] args){
        Taxes[] tax = new Taxes[3];
        Taxes t = new Taxes();

        tax = t.create(tax);
        for (int i=0;i<tax.length;i++){
            System.out.println(tax[i]);
        }

        tax = t.sort(tax);

        for (int i=0;i<tax.length;i++){
            System.out.println(tax[i]);
        }
    }
}
