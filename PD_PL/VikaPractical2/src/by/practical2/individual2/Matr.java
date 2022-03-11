package by.practical2.individual2;

public class Matr {
    public static void main(String[] args){
        int[][] arr = new int[10][10];                                                                                  // двумерный массив для матрицы
        int begin=0,end=0,sum=0;                                                                                        // begin - для установления флага на первом положительном элементе в строке
                                                                                                                        // end - для второго положительного
                                                                                                                        // sum - для подсчёта суммы отрицательных элементов
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = (int)((Math.random()*200)-100);                                                             // заполнение рандомно матрицы в диапазоне [-100;+100]
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] > 0){                                                                                      // нахождение первого + элемента
                    begin=j;                                                                                            // запись элемента
                    for(int k=j+1;k<arr[0].length;k++){
                        if(arr[i][k]>0){                                                                                // нахождение второго + элемента
                            end=k;                                                                                      // запись
                            break;                                                                                      // выход из цикла, чтоб не продолжал поиск
                        }
                    }
                    break;                                                                                              // выход из строки матрицы, чтоб не продолжал поиск
                }
            }
            for(int z=begin+1;z<end;z++){                                                                               // суммирование элементов от первого до второго + элемента и так в каждой строке
                sum+=arr[i][z];
            }
        }

        System.out.println("Сумма = " + sum);
    }
}
