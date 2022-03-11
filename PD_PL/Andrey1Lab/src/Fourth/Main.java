package Fourth;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n=0,k=1;
        System.out.println("Введите число, для которого необходимо найти факториал");
        n = scanner.nextInt();
        for(int i=1;i<=n;i++)
        {
            k*=i;
        }
        System.out.println("Факториал - " + k);
    }
}
