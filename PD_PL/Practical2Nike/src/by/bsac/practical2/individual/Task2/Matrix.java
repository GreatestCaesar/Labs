package by.bsac.practical2.individual.Task2;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char k;
        boolean d = true;
        int[][] matr = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] temp = new int[matr.length][matr[0].length];

        print(matr);                                                                                                    // вывод матрицы на экран

        while (d) {                                                                                                     // меню для пользования программой
            System.out.println("Повернуть на 1. 90˚ 2. 180˚ 3. 270˚ 0. Выход:");
            k = scanner.nextLine().charAt(0);
            switch (k) {
                case '1': {
                    temp = turn(matr);                                                                                  // вызов функции для поворота на 90
                    print(temp);
                    System.out.println();
                    break;
                }
                case '2': {
                    temp = turn(turn(matr));                                                                            // рекурсия (2 раза по 90 = 180)
                    print(temp);
                    System.out.println();
                    break;
                }
                case '3': {
                    temp = turn(turn(turn(matr)));                                                                      // также рекурсия (3 раза по 90 = 270)
                    print(temp);
                    System.out.println();
                    break;
                }
                case '0': {
                    d = false;
                    break;
                }
                default: {
                    System.err.println("Повторите ввод");
                    break;
                }
            }
        }
    }

    public static int len(int n){                                                                                       // функция для красивого вывода чисел матрицы, без сдвигов
        int l=0;
        while (n!=0){
            n/=10;
            l++;
        }
        return l;
    }

    public static int[][] turn(int[][] a){                                                                              // поворот на 90 градусов
        int[][] temp = new int[a.length][a[0].length];
        int x=0,y=0;

        for(int i= a.length-1;i>=0;i--){                                                                                // с последнего столбца от начала матрицы вниз
            y=0;
            for(int j=0;j<a.length;j++){
                temp[x][y] = a[j][i];
                y++;
            }
            x++;
        }

        return temp;
    }

    public static void print(int[][] m){                                                                                // функция для вывода матрицы на экран
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (len(m[i][j]) == 1) {
                    System.out.print(" " + m[i][j] + " ");
                } else {
                    System.out.print(m[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
