package by.bsac.lab3.individual;

import java.util.HashMap;
import java.util.Scanner;

public class Poly {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<Integer,Integer> A = new HashMap<>();
        HashMap<Integer,Integer> B = new HashMap<>();
        HashMap<Integer,Integer> C = new HashMap<>();
        int k=0,pow=0;
        System.out.println("Введите максимальную степень: ");
        pow = s.nextInt();
        System.out.println("Введите число элементов в многочлене: ");
        k = s.nextInt();
        int x = k;
        while (k!=0){
            A.put((int) ((Math.random() * pow)+0),(int) ((Math.random() * (50-1))+1));
            k--;
        }
        while (x!=0){
            B.put((int) ((Math.random() * pow)+0),(int) ((Math.random() * (50-1))+1));
            x--;
        }
        for(int i=0;i<pow;i++){
            if(A.containsKey(i)){
                if(B.containsKey(i)){
                    C.put(i,A.get(i)+B.get(i));
                }else{
                    C.put(i,A.get(i));
                }
            }else if(B.containsKey(i)){
                if(A.containsKey(i)){
                    C.put(i,A.get(i)+B.get(i));
                }else{
                    C.put(i,B.get(i));
                }
            }
        }
        System.out.println(A+"\n"+B+"\n"+C);
    }
}
