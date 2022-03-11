package by.bsac.practical2.tusk;

public class ArrayExample1 {
    public static void main(String[] args) {
        int[] myNumbers = new int[] { 1, 2, 3 };
        int[] extendedNumbers = new int[5];
        extendedNumbers[3] = 4;
        extendedNumbers[4] = 5;
        System.arraycopy(myNumbers, 0, extendedNumbers, 0,
                myNumbers.length);
        for (int str : extendedNumbers) {
            System.out.println(str);
        }
    }
}
