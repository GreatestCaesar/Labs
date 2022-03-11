package by.bsac.practical5.individual.Task3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WWJFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "E:\\PD&PL\\Practical5\\src\\by\\bsac\\practical5\\individual\\Task3\\";
        String fileName = "Car.java";
        String text = "";
        String[] str;
        String temp = "";

        text = readFile(filePath, fileName);
        str = text.split("\n");


        for (int i = 0; i < str.length; i++) {
            temp = "";
            for (int j = str[i].length() - 1; j >= 0; j--) {
                temp += str[i].charAt(j);
            }
            str[i] = temp;
        }

        temp = "";

        for (int i = 0; i < str.length; i++) {
            temp += str[i];
        }

        writeToFile(temp,filePath,"raC.txt");
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
