package by.bsac.practical2.arrays;

public class ArrayMin {
    public static void main(String[] args) {
        int[] numbers = { -9, 6, 0, -59 };
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i])
                min = numbers[i];
        }
        System.out.println(min);
    }
}
