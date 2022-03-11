package First;

public class Main {
    public static void main(String[] args){
        int i=0;
        for(i=1;i<500;i++){
            if((i%5==0) && (i%7==0))
            {
                System.out.print(i + " - ");
                System.out.println("fizzbuzz");
            }
            else if(i%5==0){
                System.out.print(i + " - ");
                System.out.println("fizz");
            }else if(i%7==0){
                System.out.print(i + " - ");
                System.out.println("buzz");
            }
        }
    }
}
