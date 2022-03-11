package by.bsac.practical2.tusk;

import java.util.Arrays;

public class ArrayTestSortAndSearch {
    public static void main(String args[]) throws Exception {
        int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };
        Arrays.sort(array); //написать подробное описание метода (что делает и какие параметры принимает)
        printArray("Sorted array", array);
        int index = Arrays.binarySearch(array, 2);
        if (index < 0) {
            System.out.println("Not found");
        } else {
            System.out.println("Found 2 @ " + index);
        }
    }
    private static void printArray(String message, int array[]) {
        System.out.println(message + ": [length: " + array.length + "]");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
