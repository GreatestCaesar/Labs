package by.bsac.lab3.individual;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Matrix {
    public static void main(String[] args) {
        String file = "E:\\PD&PL\\Lab3Nick\\src\\by\\bsac\\lab3\\data\\matr.txt";
        String txt = readFile(file);
        String[] matr = txt.split("!");
        FirstLastList CA = new FirstLastList();
        FirstLastList CB = new FirstLastList();
        FirstLastList CS = new FirstLastList();
        FirstLastList CP = new FirstLastList();
        String[] one = matr[0].split("\n");
        String temp = "";
        for(int i=0;i<one.length;i++){
            temp = one[i];
            String[] one1 = temp.split(" ");
            for(int j=0;j<one1.length;j++){
                one1[j] = one1[j].trim();
                if(Integer.parseInt(one1[j])!=0){
                    CA.insertLast((String.valueOf(i).concat(String.valueOf(j))),Integer.parseInt(one1[j]));
                }
            }
        }
        String[] two = matr[1].split("\n");
        for(int i=1;i<two.length;i++){
            temp = two[i].trim();
            String[] two1 = temp.split(" ");
            for(int j=0;j<two1.length;j++){
                two1[j] = two1[j].trim();
                if(Integer.parseInt(two1[j])!=0){
                    CB.insertLast(String.valueOf(i-1).concat(String.valueOf(j)),Integer.parseInt(two1[j]));
                }
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(CA.find((String.valueOf(i).concat(String.valueOf(j)))) != null){
                    if(CB.find((String.valueOf(i).concat(String.valueOf(j)))) != null){
                        CS.insertLast((String.valueOf(i).concat(String.valueOf(j))),CB.find((String.valueOf(i).concat(String.valueOf(j)))).data+CA.find((String.valueOf(i).concat(String.valueOf(j)))).data);
                    }else{
                        CS.insertLast(String.valueOf(i).concat(String.valueOf(j)),CA.find(String.valueOf(i).concat(String.valueOf(j))).data);
                    }
                }else if(CB.find((String.valueOf(i).concat(String.valueOf(j)))) != null) {
                    if (CA.find((String.valueOf(i).concat(String.valueOf(j)))) != null) {
                        CS.insertLast((String.valueOf(i).concat(String.valueOf(j))), CB.find((String.valueOf(i).concat(String.valueOf(j)))).data + CA.find((String.valueOf(i).concat(String.valueOf(j)))).data);
                    }else{
                        CS.insertLast(String.valueOf(i).concat(String.valueOf(j)),CB.find(String.valueOf(i).concat(String.valueOf(j))).data);
                    }
                }else{
                    CS.insertLast(String.valueOf(i).concat(String.valueOf(j)),0);
                }
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(CA.find((String.valueOf(i).concat(String.valueOf(j)))) != null){
                    if(CB.find((String.valueOf(i).concat(String.valueOf(j)))) != null){
                        CP.insertLast((String.valueOf(i).concat(String.valueOf(j))),CB.find((String.valueOf(i).concat(String.valueOf(j)))).data*CA.find((String.valueOf(i).concat(String.valueOf(j)))).data);
                    }else{
                        CP.insertLast(String.valueOf(i).concat(String.valueOf(j)),CA.find(String.valueOf(i).concat(String.valueOf(j))).data*0);
                    }
                }else if(CB.find((String.valueOf(i).concat(String.valueOf(j)))) != null) {
                    if (CA.find((String.valueOf(i).concat(String.valueOf(j)))) != null) {
                        CP.insertLast((String.valueOf(i).concat(String.valueOf(j))), CB.find((String.valueOf(i).concat(String.valueOf(j)))).data + CA.find((String.valueOf(i).concat(String.valueOf(j)))).data);
                    }else{
                        CP.insertLast(String.valueOf(i).concat(String.valueOf(j)),CB.find(String.valueOf(i).concat(String.valueOf(j))).data*0);
                    }
                }else{
                    CP.insertLast(String.valueOf(i).concat(String.valueOf(j)),0);
                }
            }
        }

        System.out.println("Сумма: ");
        CS.specialDisplay();
        System.out.println("Произведение: ");
        CP.specialDisplay();
    }

    public static String readFile(String filePath){                                                    // также как и запись, только в обратную сторону
        FileInputStream fis = null;
        File file;
        byte[] buf;
        String txt = "";
        try{
            file = new File(filePath);
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
