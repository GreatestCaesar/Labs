package by.bsac.practical5.individual.task4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WWJFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/by/bsac/practical5/individual/task4/";                      // путь проекта, в нём же и файл, можно вставить просто путь к файлу
        String fileName = "Car.java";                                                                                   // название файла, с которым работаем
        String text = "";
        String[] str;
        String temp = "";

        text = readFile(filePath, fileName);                                                                            // записываем данные из файла
        str = text.split("\n");                                                                                   // так как в задание работаем со строками файла, а новая строка это \n то и делим большой текст в массив строк построчно


        for (int i = 0; i < str.length; i++) {
            temp = "";                                                                                                  // переменная для того, чтоб записать текст каждой стоки задом наперед(дерепан)
            for (int j = str[i].length() - 1; j >= 0; j--) {                                                            // от конца строки до начала записываем в переменную содержимое
                temp += str[i].charAt(j);
            }
            str[i] = temp;                                                                                              // записываем в ту же строку то, что мы изменили
        }

        temp = "";                                                                                                      // "очищаем" строку, чтоб туда записать данные из массива строк

        for (int i = 0; i < str.length; i++) {                                                                          // записываем в temp содержимое массива строк
            temp += str[i];
        }

        writeToFile(temp,filePath,"raC.txt");                                                                   // записываем строку в файл, название своё вставить
    }

    public static void writeToFile(String txt, String filePath, String fileName){
        FileOutputStream fos = null;
        File file;
        File dir = new File(filePath);
        byte[] symbols = txt.getBytes();
        try{
            file = new File(filePath+fileName);
            if(!dir.mkdir()){
                dir.mkdir();
            }

            if(!file.exists()){
                file.createNewFile();
            }

            fos = new FileOutputStream(file);
            fos.write(symbols);
            fos.close();
            System.out.println("Данные сохранены! ");
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static String readFile(String filePath, String fileName){
        FileInputStream fis = null;
        File file;
        byte[] buf;
        String txt = "";
        try{
            file = new File(filePath+fileName);
            fis = new FileInputStream(file);
            buf = new byte[fis.available()];
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
