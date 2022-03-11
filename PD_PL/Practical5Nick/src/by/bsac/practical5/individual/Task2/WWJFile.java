package by.bsac.practical5.individual.Task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WWJFile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String filePath = "src/by/bsac/practical5/individual/Task2/";                      // путь к любому(желательно нигде не задействованному) java файлу, можно копировать в папку проекта любой другой файл для безопасности и указать путь
        String fileName = "Car.java";                                                                                   // название файла, с которым будем работать
        String text = "";
        String str = "";
        char[] pub = {'p','u','b','l','i','c'};                                                                         // так как private и public и необходимо сравнивать символы в тексте с public, удобнее работать с массивом символов
        int t=0,k=0,begin=0,end=0;                                                                                      // t - для подсчета совпадающих сиволов в тексте со словом 'public', k - для перехода по тексту, begin - начало слова public, end - соответсвтенно конец
        boolean flag = false;                                                                                           // флаг - указывающий, что мы нашли слово public в тексте

        text = readFile(filePath,fileName);                                                                             // читаем данные из java файла, как это работает описано в Task1

        for(int i=0;i<text.length();i++){                                                                               // до конца текста посимвольно делаем проверку
            flag = false;                                                                                               // с каждым символом флаг "обнуляется"
            if(text.charAt(i)=='p'){                                                                                    // если символ p то начинаем проверять
                k=i;                                                                                                    // записываем откуда будем проверять последующие символы в text
                begin=i;                                                                                                // если это слово 'public' то необходимо запомнить начало
                t=0;                                                                                                    // обнуляем счётчик совпадающих символов
                for(int j=0;j<pub.length;j++){                                                                          // цикл, чтоб проверить символы текста со словом public
                    if(pub[j]==text.charAt(k)){                                                                         // если символы совпадают
                        k++;                                                                                            // переход на следующий символ в text
                        t++;                                                                                            // кол-во совпадающих символов на 1 увеличилось
                    }
                    if(t==pub.length){                                                                                  // если символы совпали с целым словом
                        end = k;                                                                                        // запоминаем конце слова public в тексте
                        flag=true;                                                                                      // даём флагу знать, что необходимо заменить слово
                                                                                                                        // флаг необходим, чтоб не заменял всё подряд т.к. цикл делает множество прохходов
                    }
                }
                if(flag==true){                                                                                         // если флаг есть то
                    str = text.substring(0,begin);                                                                      // во временную строку(она необходима, чтоб сохранять ей в нашу основную строку получается "то что имзенили не исчезает при каждом проходе по тексту"
                                                                                                                        // от начала текста до начала слова public
                    str += "private";                                                                                   // где было слово public вставляем private
                    str += text.substring(end,text.length());                                                           // и там где слово закончилось вставляем основной текст, тем самым обходим слово public
                    text = str;                                                                                         // записываем в основной текст
                }
            }
        }

        writeToFile(text,filePath,fileName);                                                                            // записываем измененный текст обратно в файл
    }

    public static void writeToFile(String txt, String filePath, String fileName){                                       // описание в файле Task1
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

    public static String readFile(String filePath, String fileName){                                                    // Task1
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
