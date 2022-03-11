package Second;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String text = new String();
        System.out.println("Введите строку: ");
        text = scanner.nextLine();
        System.out.println("Вы ввели: " + text);
        System.out.println("Результат: "+swap(text));
    }

    public static String swap(String z)
    {
        String str = new String();
        for(int i=z.length()-1;i>=0;i--){
            str += z.charAt(i);
        }
        return str;
    }
}
