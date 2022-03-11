package Task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Coll {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();                                                                      // коллекция (на базе массива)
        ArrayList<Integer> c2 = new ArrayList<>();
        String filePath = "E:\\PD&PL\\Maria3Lab\\src\\";                                                                // по практическому работа с файлами станет понятно, что и для чего
        String fileName = "forList.txt";
        String txt = readFile(filePath,fileName);                                                                       // записали данные из файла
        String[] num = txt.split(" ");                                                                            // разделили цифра
        for(int i=0;i<num.length;i++){                                                                                  // записали в с1 до отрицательного числа
            if(!(num[i].indexOf('-')==-1)){
                break;
            }
            c1.add(Integer.parseInt(num[i]));
        }

        for(int i=c1.size();i<num.length;i++){                                                                          // от отрицательного числа до конца записали в с2
            if(!(num[i].indexOf('-')==-1)){

            }else {
                c2.add(Integer.parseInt(num[i]));
            }
        }
        System.out.println("c1 - " + c1);                                                                               // показываем списки
        System.out.println("c2 - " + c2);

        int t;                                                                                                          // сортируем с1
        for(int i=0;i<c1.size();i++){
            for(int j=i+1;j<c1.size();j++){
                if(c1.get(i)>c1.get(j)){
                    t = c1.get(i);
                    c1.set(i, c1.get(j));
                    c1.set(j,t);
                }
            }
        }
        System.out.println("c1 - " + c1);                                                                               // выводим отсортированный с1
        System.out.println("Объединяем!");
        c1.addAll(c2);                                                                                                  // объединяем с1 <- с2
        System.out.println("c1 - " + c1);                                                                               // выводим новый список
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
