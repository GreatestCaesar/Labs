package by.bsac.practical1.indiviudal;

import java.util.Scanner;

public class SumNumb {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.print("Введите число: ");
        num = scanner.nextInt();
        System.out.println("Ваше числов: " + num);
        System.out.println("Сумма четных цифр: " + sum(num));
    }

    public static int sum(int n){
        String str = n + "";
        int s = 0;
        for(int i=0;i<str.length();i++){
            if(Integer.parseInt(String.valueOf(str.charAt(i)))%2==0 && Integer.parseInt(String.valueOf(str.charAt(i)))!=0){
                s+=Integer.parseInt(String.valueOf(str.charAt(i)));
            }
        }
        return s;
    }
}
