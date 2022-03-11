package by.bsac.practical2.individual2;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int k=0,o=0;
        boolean flag = false;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++) {
                if (len(arr[i][j]) == 1)
                {
                    System.out.print(" " + arr[i][j] + " ");
                }
                else
                {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }


        int min = 0;
        System.out.println();


        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                min = arr[i][0];
                for(int b=0;b<arr[i].length;b++){
                    if(arr[i][b]<min){
                        min = arr[i][b];
                    }
                }
                if(arr[i][j]==min){
                    k++;
                    break;
                }
                System.out.println();
            }
        }
        System.out.println("Количество седловых точек: " + k);
    }

    public static int len(int n){
        String s="" + n;
        if(s.length()>1){
            return 2;
        }
        return 1;
    }
}
