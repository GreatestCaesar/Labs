package Task;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        boolean b=false;
        int n;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add(i,(int)((Math.random()*100)+0));
        }

        /*for (int i = 0; i < 100; i++) {
            b = false;
            n = (int) (Math.random() * 100);
            for (int j = i - 1; j >= 0; j--) {
                if (n == list.get(j)) {
                    b = true;
                    i--;
                    break;
                }
            }
            if (!b) {
                list.add(n);
            }
        }*/

        int c=0;
        for(int i=0;i<list.size();i++){
            if(c==5){
                System.out.println();
                c=0;
            }
            System.out.print(list.get(i) + " ");
            c++;
        }

        boolean t=true;
        int d;
        do{
            t=true;
            System.out.println("\nВведите число Х, относительно которого будет упорядочен список: ");
            d = scanner.nextInt();
            if(d>100 || d<0){
                t=false;
                System.out.println("Введенное число не входит в диапазон [0..100]");
            }
        }while (!t);

        int temp;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)>list.get(j)){
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }

        System.out.println(list);
    }
}
