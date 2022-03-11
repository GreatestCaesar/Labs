package by.bsac.lab3.individual;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Words {
    public static void main(String[] args) {
        String file = "src/by/bsac/lab3/individual/text.txt"; // путь к файлу с текстом
        String text = readFile(file);                           // считываем текст из файла
        char[] symbols = {'!','@','#','$','%','^','&','*','(',')','_','+','"','№',';',':','?','-','=',',','.','«','»','—','–'}; // символы для нахождения их в тексте
        StringBuffer txt = new StringBuffer(text);
        while(avail(txt, symbols)){                                                                                     // удаляем символы из текста, чтоб остались только слова
            for(int i=0;i< symbols.length;i++){
                if(txt.indexOf(String.valueOf(symbols[i])) != -1)
                    txt.deleteCharAt(txt.indexOf(String.valueOf(symbols[i])));
            }
        }

        text = txt.toString();
        System.out.println(text);
        String words[] = text.split(" ");                                                           // записываем в массив слова из строки разделяя по пробелу

        HashMap<String, Integer> word = new HashMap<>();                                            // создаем список HashMap
        for(int i=0;i< words.length;i++){                                                           // (почитать что такое HashMap) из за свойства такой коллекции записываем в неё слова при этом подсчитывая их встречаемость
            word.put(words[i],count(words,words[i]));
        }

        System.out.println(word);
    }

    public static int count(String[] words, String word){
        int x = 0;
        for(int i=0;i< words.length;i++){
            if(words[i].equals(word)){
                x++;
            }
        }
        return x;
    }

    public static String readFile(String fileT){                                                    // также как и запись, только в обратную сторону
        FileInputStream fis = null;
        File file;
        byte[] buf;
        String txt = "";
        try{
            file = new File(fileT);
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

    public static boolean avail(StringBuffer t, char[] symbols){
        for(int i=0;i<t.length();i++){
            for(int j=0;j< symbols.length;j++){
                if(symbols[j] == t.charAt(i)){
                    return true;
                }
            }
        }
        return false;
    }
}
