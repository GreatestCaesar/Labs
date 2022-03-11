package Individual;

import java.util.Scanner;

/**
 * @author Julius
 * @version 1.0
 */

public class Main
{
    /**
     * @since 1.0
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        /*int[] arr = new int[3];
        for(int i=0;i< arr.length;i++){
            System.out.print("Введите число: ");
            arr[i] = scanner.nextInt();
        }

        int max = 0;
        for(int i=0;i< arr.length;i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        System.out.println("Максимальное число: " + max);*/

        // ------------------------------------------------------------------------------------------------------------//

        int a,b,c;
        System.out.print("Введите первое число: ");
        a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        b = scanner.nextInt();
        System.out.print("Введите третье число: ");
        c = scanner.nextInt();
        if(a>b && a>c){
            System.out.println("Наибольшее - " + a);
        }else if(b>a && b>c){
            System.out.println("Наибольшее - " + b);
        }else{
            System.out.println("Наибольшее - " + c);
        }
    }
}
