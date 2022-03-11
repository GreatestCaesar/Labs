package Individual;

import java.util.Scanner;

/**
 * @author Andrey
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
        int[] num = new int[3];
        int k=0;
        boolean flag = false;
        for(int i=0;i<num.length;i++){
            System.out.print("Введите " + (i+1) + " число - ");
            num[i] = scanner.nextInt();
        }

        for(int i=0;i<num.length-1;i++){
            if(num[i]<num[i+1]){
                k++;
            }
        }
        if(k==2){
            for(int i=0;i<num.length;i++){
                num[i] *= 2;
            }
        }else{
            for(int i=0;i< num.length;i++){
                num[i] = (0-num[i]);
            }
        }

        System.out.println("Числа: ");
        for(int i=0;i< num.length;i++){
            System.out.print(num[i] + " ");
        }
    }
}
