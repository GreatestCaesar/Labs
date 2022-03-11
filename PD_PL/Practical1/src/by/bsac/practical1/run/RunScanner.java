package by.bsac.practical1.run;

import java.util.Scanner;

public class RunScanner {
    public static void main(String[] args) {
        System.out.println("Enter your name and press <Enter>:");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Hello, " + name);
        scan.close();
    }
}
