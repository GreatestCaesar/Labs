package by.practical2.individual1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[100];                                                                                       // массив для хранения числе
        int[] num = new int[100];                                                                                       // массив для хранения кол-ва повторяющихся цифр
        int max=0, index=0;                                                                                             // мах - для определения, какое максимальное число цифр повторяется
                                                                                                                        // index - найти индекс числа

        for(int i=0;i<arr.length;i++){
            arr[i] = (int) ((Math.random()*99999)+0);                                                                   // заполнение массива рандомными числами
            System.out.print(arr[i] + " ");
        }

        for(int i=0;i<num.length;i++){                                                                                  // обращение к функци, которая возрващает число повторяющихся цифр в числе, и запись их в массив
            num[i] = num(arr[i]);
        }

        max = num[0];                                                                                                   // нахождение максимального числа в массива
        for(int i=0;i<num.length;i++){
            if(num[i]>max){
               max = num[i];
            }
        }

        for(int i=0;i<num.length;i++){                                                                                  // нахождение первого числа, у которого минимальное число повторяющихся цифр и выход из цикла с записью индекса этого числа
            if(num[i]==max){
                index=i;
                break;
            }
        }

        System.out.println("\nЧисло, в котором число различных цифр минимально: " + arr[index]);                        // вывод числа на экран
    }

    public static int num(int n){
        String str = "" + n;                                                                                            // запись числа из массива в строку
        int k=0;                                                                                                        // счётчик повторяющихся цифр
        char[] numb = new char[str.length()];                                                                           // массив, в которых заносятся цифры из числа
        for(int i=0;i<numb.length;i++){                                                                                 // внесение цирф
            numb[i] = str.charAt(i);
        }

        for(int i=0;i<numb.length;i++){                                                                                 // сверяет первую(и остальные) цифру с остальными и так далее
            for(int j=i+1;j<numb.length;j++){
                if(numb[i]==numb[j]){
                    k++;                                                                                                // если в числе цифры совпали, счётчик увеличивается
                }
            }
        }

        return k;
    }
}
