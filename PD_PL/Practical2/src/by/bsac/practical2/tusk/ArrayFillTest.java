package by.bsac.practical2.tusk;

import java.util.Arrays;

public class ArrayFillTest {
    public static void main(String args[]) {
        int array[] = new int[6];
//заполним каждый элемент массива значением 100
        Arrays.fill(array, 100);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
//элементам массива имеющим индекс с 3 по 5 придадим значение 50
        Arrays.fill(array, 3, 6, 50);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
