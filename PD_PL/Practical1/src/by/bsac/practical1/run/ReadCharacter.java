package by.bsac.practical1.run;

public class ReadCharacter {
    public static void main(String[] args) {
        int x;
        try {
            System.out.print("Enter any character and then press <Enter>:");
            x = System.in.read();
            char c = (char) x;
            System.out.println("Code symbol: " + c + " = " + x);
        } catch (java.io.IOException e) {
            System.err.println("Input error " + e);
        }
    }
}
