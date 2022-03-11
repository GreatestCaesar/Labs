package by.bsac.practical2.individual;

import java.util.Scanner;

public class Numbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[20];
        int n=20,k=1,t=1,x=0,c=2;
        arr[0] = t;
        arr[1] = k;
        while(n!=0){
            x = k+t;
            if(c<arr.length) {
                arr[c] = x;
            }
            k=t;
            t=x;
            n--;
            c++;
        }
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
