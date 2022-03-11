package pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataFromFile {
    public static String readFile(String filePath){
        FileInputStream fis = null;
        File file;
        byte[] buf;
        String txt = "";
        try{
            file = new File(filePath);
            if(!file.exists()){
                System.out.println("Данный файл не найден, попробуйте позже");
                System.exit(0);
            }
            fis = new FileInputStream(file);
            buf = new byte[fis.available()];
            fis.read(buf);
            fis.close();
            txt = new String(buf);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return txt;
    }

    public static void writeToFile(String txt, String filePath){                                       // метод для записи в файл
        FileOutputStream fos = null;                                                                                    // объявляем поток записи в файл и ничего не инициализируем
        File file;                                                                                                      // объявляем файл
        File dir = new File(filePath);                                                                                  // создаем объект типа File, который отвечает за путь к файлу
        byte[] symbols = txt.getBytes();                                                                                // преобразуем текст к массиву байтов, для удобной записи в файл
        try{                                                                                                            // блок try, для проверки потока записи, чтоб не было проблем
            file = new File(filePath);

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
}
