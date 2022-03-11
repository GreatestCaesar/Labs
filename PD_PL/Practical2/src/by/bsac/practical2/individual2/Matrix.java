package by.bsac.practical2.individual2;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[5][5];
        int t = 1;
        int k = 0;
        int p = 0;

        for(int i=0;i < arr.length;i++){
            for(int j=0;j < arr.length;j++){
                arr[i][j] = t;
                t++;
            }
        }

        for(int i=0;i < arr.length;i++){
            for(int j=0;j < arr.length;j++){
                if(len(arr[i][j])==1){
                    System.out.print(" " + arr[i][j] + " ");
                }else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

        System.out.println("На сколько позиций сдвинуть матрицу: ");
        k = scanner.nextInt();
        System.out.println("1. Вверх 2. Вниз 3. Влево 4. Вправо");
        p = scanner.nextInt();
        switch (p){
            case 1:{
                arr = shiftUp(arr,k);
                break;
            }
            case 2:{
                arr = shiftDown(arr,k);
                break;
            }
            case 3:{
                arr = shiftLeft(arr,k);
                break;
            }
            case 4:{
                arr = shiftRight(arr,k);
                break;
            }
        }

        for(int i=0;i < arr.length;i++){
            for(int j=0;j < arr.length;j++){
                if(len(arr[i][j])==1){
                    System.out.print(" " + arr[i][j] + " ");
                }else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static int len(int n){
        int l=0;
        while (n!=0){
            n/=10;
            l++;
        }
        return l;
    }

    public static int[][] shiftUp(int[][] a, int k){
        int[] first = new int[a.length];
        while (k!=0){
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a.length; j++){
                    if(i==0){
                        first[j] = a[i][j];
                        a[i][j] = a[i+1][j];
                    }else{
                        if(i==a.length-1){
                            a[i][j] = first[j];
                        }else{
                            a[i][j] = a[i+1][j];
                        }
                    }
                }
            }
            k--;
        }
        return a;
    }

    public static int[][] shiftDown(int[][] a, int k){
        int[] first = new int[a.length];
        while (k!=0){
            for(int i = a.length-1; i >= 0; i--){
                for(int j = 0; j < a.length; j++){
                    if(i==a.length-1){
                        first[j] = a[i][j];
                        a[i][j] = a[i-1][j];
                    }else{
                        if(i==0){
                            a[i][j] = first[j];
                        }else{
                            a[i][j] = a[i-1][j];
                        }
                    }
                }
            }
            k--;
        }
        return a;
    }

    public static int[][] shiftLeft(int[][] a, int k){
        int[] first = new int[a.length];
        while (k!=0){
            for(int i = 0; i < a.length; i++){
                for(int j = 0; j < a.length; j++){
                    if(i==0){
                        first[j] = a[j][i];
                        a[j][i] = a[j][i+1];
                    }else{
                        if(i==a.length-1){
                            a[j][i] = first[j];
                        }else{
                            a[j][i] = a[j][i+1];
                        }
                    }
                }
            }
            k--;
        }
        return a;
    }

    public static int[][] shiftRight(int[][] a, int k){
        int[] first = new int[a.length];
        while (k!=0){
            for(int i = a.length-1; i >= 0; i--){
                for(int j = 0; j < a.length; j++){
                    if(i==a.length-1){
                        first[j] = a[j][i];
                        a[j][i] = a[j][i-1];
                    }else{
                        if(i==0){
                            a[j][i] = first[j];
                        }else{
                            a[j][i] = a[j][i-1];
                        }
                    }
                }
            }
            k--;
        }
        return a;
    }
}
