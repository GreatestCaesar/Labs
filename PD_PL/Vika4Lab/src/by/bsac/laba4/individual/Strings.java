package by.bsac.laba4.individual;

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        String sub = "";
        StringBuffer text = new StringBuffer("Между строчек где-то в коде\n" +                                          // StringBuffer потому что так удобнее и есть
                "Притаился хитрый баг,\n" +                                                                             // специальный метод для вставки подстроки на заданную позицию
                "Он логический наверно -\n" +
                "Не дебажится никак.\n" +
                "\n" +
                "Планомерно шаг за шагом,\n" +
                "Кучу тестов написал,\n" +
                "И его по логам гада,\n" +
                "В процедуре отыскал.\n" +
                "\n" +
                "Вслед за ифом, перед фором,\n" +
                "Обнаружен был злодей.\n" +
                "И пофикшен, ясен перец -\n" +
                "Сразу стало веселей.\n" +
                "\n" +
                "Чтоб душе спокойно стало,\n" +
                "Тест контрольный запустил -\n" +
                "Баг по прежнему на месте...\n" +
                "Так бы сволочь и убил!");

        System.out.println(text);

        System.out.println("Введите строку, которую необходимо вставить в текст: ");                                    // взаимодействие с пользователем, всё как обычно
        sub = scanner.nextLine();
        System.out.println("Введите на какую позицию поставить строку: ");
        n = scanner.nextInt();

        text.insert(n," -> "+sub+" <- ");                                                                           // метод insert, на заданную позицию, заданную строку
        System.out.println(text);                                                                                       // выводим результат
    }
}
