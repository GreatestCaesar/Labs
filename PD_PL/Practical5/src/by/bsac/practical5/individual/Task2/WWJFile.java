package by.bsac.practical5.individual.Task2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WWJFile {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String filePath = "E:\\PD&PL\\Practical5\\src\\by\\bsac\\practical5\\individual\\Task2\\";
        String fileName = "Car.java";
        String text = "";
        String str = "";
        char[] pub = {'p','u','b','l','i','c'};
        int t=0,k=0,begin=0,end=0;
        boolean flag = false;

        text = readFile(filePath,fileName);

        for(int i=0;i<text.length();i++){
            flag = false;
            if(text.charAt(i)=='p'){
                k=i;
                begin=i;
                t=0;
                for(int j=0;j<pub.length;j++){
                    if(pub[j]==text.charAt(k)){
                        k++;
                        t++;
                    }
                    if(t==pub.length){
                        end = k;
                        flag=true;
                    }
                }
                if(flag==true){
                    str = text.substring(0,begin);
                    str += "private";
                    str += text.substring(end,text.length());
                    text = str;
                }
            }
        }

        writeToFile(text,filePath,fileName);
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
