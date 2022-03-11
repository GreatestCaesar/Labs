package by.bsac.practical2.individual.Task1;

public class Number {
    public static void main(String[] args){
        int[] numbers = new int[100];

        for(int i=0;i<numbers.length;i++){                                                                              // заполнеине массива рандомными числами от 0 до 100.000
            numbers[i] = (int) ((Math.random()*100000)+0);
            System.out.print(numbers[i] + " ");
        }

        System.out.println();

        for(int i=0;i< numbers.length;i++){                                                                             // проход по массиву, для вызова функции, которая проверяет повторяются ли цифры в числе
            if(num(numbers[i])){                                                                                        // если не повторяются, выводит это число и останавливает цикл
                System.out.print(numbers[i]+" ");
                break;
            }
        }
    }


    public static boolean num(int x){
        String str = "" + x;                                                                                            // преобразовывает число в строчку, для удобного сравнения цифр в числе
        int k=0;                                                                                                        // счётчик повторяющихся цифр
        char[] numb = new char[str.length()];
        for(int i=0;i<numb.length;i++){
            numb[i] = str.charAt(i);                                                                                    // преобразование строки к массиву символов
        }

        for(int i=0;i< numb.length;i++){
            for(int j=i+1;j<numb.length;j++){
                if(numb[i]==numb[j]){                                                                                   // проверка совпадает ли какая нибудь цифра с остальными в числе
                    k++;                                                                                                // если цифра найдена счётчик увеличивается
                }
            }
        }
        if(k==0){                                                                                                       // если не нашло повторяющихся цифр, то число нам подходит
            return true;
        }
        return false;
    }
}
