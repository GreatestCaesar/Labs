package Third;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n=0,k=1,t=1,x=0;
        System.out.println("Введите конец вычсления числа Фибоначии");
        n = scanner.nextInt();
        System.out.print(k+" "+t+" ");
        while(n!=0){
            x = k+t;
            System.out.print(x+" ");
            k=t;
            t=x;
            n--;
        }
    }
}
