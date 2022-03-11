package by.bsac.practical5.individual.Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class RandomFile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String filePath = "E:\\PD&PL\\Practical5\\src\\by\\bsac\\practical5\\individual\\Task1\\RandomNumbers\\";
        String fileName = "";
        String text = "";
        String text1 = "";
        String[] num;
        int[] numbers;
        boolean t = true;
        int d=0;

        System.out.println("Введите название файла: ");
        fileName = scanner.nextLine();
        fileName += ".txt";

        for(int i=0;i<1000;i++){
            text += (int)((Math.random()*2000)-1000) + " ";
        }

        writeToFile(text,filePath,fileName);
        text1 = readFile(filePath,fileName);
        num = text1.split(" ");
        numbers = new int[num.length];

        do {
            System.out.println("Сортируем? Любая цифра(0-9) - продолжение: ");
            d = scanner.nextInt();
            if(d<0 && d>9){
                t=false;
                System.out.println("Повторите ввод!");
            }
        }while (!t);

        for(int i=0;i< num.length;i++){
            numbers[i] = Integer.parseInt(num[i]);
        }

        int temp;
        for(int i=0;i< numbers.length;i++){
            for(int j=i+1;j< numbers.length;j++){
                if(numbers[i]>numbers[j]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        text1 = "";

        for(int i=0;i< num.length;i++){
            text1 += numbers[i]+" ";
        }

        writeToFile(text1,filePath,fileName);
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
            if(!file.exists()){
                file.createNewFile();
            }
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
