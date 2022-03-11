package by.bsac.practical5.individual.individual.Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class RandomFile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/by/bsac/practical5/individual/individual/Task1/";  // путь к папке, в которой будет создаваться файл

        String fileName = "";                                                                                           // переменная для записи названия файла
        String text = "";                                                                                               // для записи содержимого, которое будет размещено в файле
        String text1 = "";                                                                                              // для записи содержимого из файла
        String[] num;                                                                                                   // т.к. содержимое необходимо разделить используем массив строк
        int[] numbers;                                                                                                  // массив для хранения чисел из файла

        System.out.println("Введите название файла: ");
        fileName = scanner.nextLine();
        fileName += ".txt";

        for(int i=0;i<1000;i++){                                                                                        // заполняем рандомными числая в диапазоне [-1000;1000]
            text += (int)((Math.random()*2000)-1000) + " ";
        }

        writeToFile(text,filePath,fileName);                                                                            // вызываем метод для записи в файл и передаём ему, что необходимо записать, по какому пути и как назвать файл
        text1 = readFile(filePath,fileName);                                                                            // считываем данные из файла, которые сохранили до этого
        num = text1.split(" ");                                                                                   // так как данные в одной строке - делим их по " "(пробелу)
        numbers = new int[num.length];                                                                                  // задаем размер массива, согласно кол-ву чисел из файла

        for(int i=0;i< num.length;i++){
            numbers[i] = Integer.parseInt(num[i]);                                                                      // так как числа хранятся в строковом значении, преобразуем и записываем в массив
        }

        int temp;
        for(int i=0;i< numbers.length;i++){                                                                             // алгоритм сортировки
            for(int j=i+1;j< numbers.length;j++){
                if(numbers[i]>numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        text1 = "";                                                                                                     // "обнуляем" текстовую строку, в которой хранились значения из файла

        for(int i=0;i< num.length;i++){                                                                                 // записываем в нее значения из отсортированного массива
            text1 += numbers[i]+" ";
        }

        writeToFile(text1,filePath,fileName);                                                                           // записываем заново в файл отсортированные числа
    }

    public static void writeToFile(String txt, String filePath, String fileName){                                       // метод для записи в файл
        FileOutputStream fos = null;                                                                                    // объявляем поток записи в файл и ничего не инициализируем
        File file;                                                                                                      // объявляем файл
        File dir = new File(filePath);                                                                                  // создаем объект типа File, который отвечает за путь к файлу
        byte[] symbols = txt.getBytes();                                                                                // преобразуем текст к массиву байтов, для удобной записи в файл
        try{                                                                                                            // блок try, для проверки потока записи, чтоб не было проблем
            file = new File(filePath+fileName);                                                                // создаем объект файл(путь+название)
            if(!dir.mkdir()){                                                                                           // если такой папки по заданному пути нет (RandomNumbers) он её создаст
                dir.mkdir();
            }

            if(!file.exists()){                                                                                         // если файла нет, то создаст
                file.createNewFile();
            }

            fos = new FileOutputStream(file);                                                                           // инициализируем поток записи и отправляем файл, в который будет проивзодиться запись
            fos.write(symbols);                                                                                         // записываем массив байтов
            fos.close();                                                                                                // закрываем поток (всегда нужно так делать)
            System.out.println("Данные сохранены! ");                                                                   // предупреждаем пользователя, что данные сохранены
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static String readFile(String filePath, String fileName){                                                    // также как и запись, только в обратную сторону
        FileInputStream fis = null;
        File file;
        byte[] buf;
        String txt = "";
        try{
            file = new File(filePath+fileName);
            fis = new FileInputStream(file);
            buf = new byte[fis.available()];                                                                            // fis.available - возвращает кол-во байтов в файле
            fis.read(buf);
            fis.close();
            txt = new String(buf);
            System.out.println("Данные извлекли!");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        return txt;
    }
}
