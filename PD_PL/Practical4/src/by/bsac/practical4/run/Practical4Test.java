package by.bsac.practical4.run;

public class Practical4Test {
    public static void main(String[] args) {
        /*
        * Создание объекта класса String
        */

        /*
        * Cпособ 1: Используя строковые литералы - последовательность символов
        * заключенных в двойные кавычки. Важно понимать, что всегда когда вы
        * используете строковой литерал компилятор создает объект со значением
        * этого литерала
        */
        String stringExample = "string literal";
        System.out.println("string literal"); // создали объект и вывели его
        // значение
        /*
         * 2. С помощью конструкторов:
         */
        String stringForTest = "test string";
        char[] testStringAsArrayOfChars = { 't', 'e', 's', 't', ' ', 's',
                't', 'r', 'i', 'n', 'g' };
        byte[] testStringAsArrayOfBytes = new byte[stringForTest.length()];
        for (int i = 0; i < stringForTest.length(); i++) {
            char character = stringForTest.charAt(i);
            testStringAsArrayOfBytes[i] = (byte) character;
        }
        String first = new String("test string");
        String second = new String(stringForTest);
        String third = new String(testStringAsArrayOfChars);
        String fourth = new String(testStringAsArrayOfBytes, 0, 4);
        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
        System.out.println(fourth);
            /*
         * Сравнение производительности при создании строк первым и вторым
         * способами
         */
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String s1 = "hello";
            String s2 = "hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время, потраченное на создание" + " строковых литералов: " + (endTime - startTime) + "миллисекунд");
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            String s3 = new String("hello");
            String s4 = new String("hello");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("Время, потраченное на создание" + " объектов класса String : " + (endTime1 - startTime1) + " миллисекунд");
        /*
         * Длина строки
         */
        String testLength = "String";
// получить длину строки
        int length = testLength.length();
// теперь можно узнать есть ли символ символ 't' в "String"
        char searchChar = 't';
        boolean isFound = false;
        for (int i = 0; i < length; ++i) {
            if (testLength.charAt(i) == searchChar) {
                isFound = true;
                break; // первое вхождение
            }
        }
        System.out.println(isFound); // true
        /*
         * String.indexOf - Возвращает индекс первого(последнего) вхождения
         * символа в строке.
         */
        boolean isFoundCharAt = testLength.indexOf(searchChar) != -1;
        System.out.println(isFoundCharAt); // true
        /*
         * Конкатенация
         */
// 1. Метод concat
        String concatString = "ADP".concat("-java").concat("- practical").concat("4");
        System.out.println(concatString); // получим ADP-java-practical4
// 2. Операторы "+" и "+="
        String plusString = "java" + "-string";
        plusString += "-example";
        System.out.println(plusString);// java-string-example
        String str1 = "test";
        String str2 = "string";
        String resultString = str1 + str2;
// на самом деле
        String resultString2 = new StringBuilder().append(str1).append(str2).toString();
/*
* Сравнение строк
18
*/
        String compareStr1 = new String("test");
        String compareStr2 = "test";
        System.out.println("equals() - строки имеют одинаковое значение: " + compareStr1.equals(compareStr2)); // true
        System.out.println("== проверка, одинаковые ли объекты: " + (compareStr1 == compareStr2)); // false
        String compareStr3 = new String("test");
        System.out.println("== проверка, одинаковые ли объекты: " + (compareStr1 == compareStr3)); // false
        String compareStr4 = "test";
        System.out.println("== проверка, одинаковые ли объекты: " + (compareStr2 == compareStr4)); // true
        /*
         * Преобразование
         */
// 1. Число в строку
        int integerVariable = 10;
        String firstInt = integerVariable + ""; // конкатенация с пустой строкой
        String secondInt = String.valueOf(integerVariable); // вызов
// статического
// метода valueOf
// класса String
        String thirdInt = Integer.toString(integerVariable); // вызов метода
// toString
// класса-обертки
// 2. Строку в число
        String stringInt = "15";
        int int1 = Integer.parseInt(stringInt);
        /*
         * получаем примитивный тип (primitive type) используя метод
         * parseXхх
         * нужного класса-обертки, где Xxx - имя примитива с заглавной буквы
         * (например parseInt)
         */
        int int2 = Integer.valueOf(stringInt); // получаем объект wrapper
// класса и автоматически распаковываем
        /* Примеры, демострирующие неизменяемость строк(immutable) */
        String immutableStr1 = "Hello";
        String immutableStr2 = immutableStr1; // s1 и s2 now указывают наодин и тот же объект класса String "Hello"
/*
* Теперь нет ничего такого, чтобы мы могли сделать с объектом
* immutableStr1 и не повляить на объект immutableStr2. Они
ссылаются на
* один и тот же объект - строка "Hello" - но этот объект является
* неизменяемым(immutable) и таким образом не может быть изменен.
*
* Если мы выполним следующее:
*/
        immutableStr1 = "Help!";
// создается новый объект в пуле строк(так как строки являются
// неизменяемыми (immutable)
        System.out.println(immutableStr2); // "Hello" -
// *immutableStr2 продолжает ссылаться на строку Hello, так как данный объект не изменился, а для immutableStr1 был создан новый объект*/
        String string1 = "String";
        String string2 = string1;
        string1 = string1.replace('i', 'o');
        System.out.println(string1); // "Strong"
        System.out.println(string2); // "String"
        System.out.println(string1 == string2); // "false"
        /* так как s1 и s2 являются 2мя разными объектами */
        /*
         * Форматирование
         *
         * Класс String предоставляет возможность создания форматированных
         * строк. За это отвечает статический метод format, например:
         */
        String formatString = "Printing double variable (%f), string ('%s') and integer variable (%d).";
        System.out.println(String.format(formatString, 9.31, "example", 17));
// Printing double variable (9,310000), string ('example') and integer
// variable (17).
    }
}
