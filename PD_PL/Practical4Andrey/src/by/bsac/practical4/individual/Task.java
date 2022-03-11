package by.bsac.practical4.individual;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int s1 = 0;
        String temp;
        char[] symb = {'!','@','#','$','%','^','&','*','(',')','_','-','+','=',',','.','/','\\',';','"','?','№'};
        System.out.println("Введите стоимость слова: ");
        s1 = s.nextInt();
        System.out.println("Введите текст: ");
        s.nextLine();
        temp = s.nextLine();
        StringBuffer txt = new StringBuffer(temp);
        while(avail(txt, symb)){
            for(int i=0;i< symb.length;i++){
                if(txt.indexOf(String.valueOf(symb[i])) != -1) {
                    txt.replace(txt.indexOf(String.valueOf(symb[i])),txt.indexOf(String.valueOf(symb[i]))+1," ");
                }
            }
        }
        temp = "";
        temp = txt.toString();
        String[] words = temp.split(" ");
        System.out.println("Стоимость телеграммы: " + (s1*words.length));
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
