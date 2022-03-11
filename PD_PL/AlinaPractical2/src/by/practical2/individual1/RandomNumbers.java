package by.practical2.individual1;

public class RandomNumbers {
    public static void main(String[] args){ // эту строку можно загуглить
        int[] num = new int[15];                  // создаём массив из 15 элементов
        int sum=0;                                // переменная для подсчёта чётных элементов

        for(int i=0;i< num.length;i++){           // от 0 элемента до 14 инициализируем массив
            num[i] = (int)((Math.random()*10)+0); // (int) - потому что функция Math.random возвращает
                                                  // значения типа double, а массив из int, поэтому кастим(указываем),
                                                  // что записываем целые значения
                                                  // диапазон функцией Math.random задается так [a,b] - (Math.random*(b-a)+a)
        }
        System.out.print("Элементы: ");           // вывод элементов массива в консоль
        for(int i=0;i< num.length;i++){
            System.out.print(num[i] + " ");
        }

        for(int i=0;i< num.length;i++){
            if(num[i]%2==0){                      // проверяем делится ли элемент на 2 без остатка, если делится то счётчик увеличивается на 1
                sum++;
            }
        }

        System.out.println("\nКоличество чётных элементов: " + sum);
    }
}
