package pack;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String original = DataFromFile.readFile("src/file1.txt");
        String[] list1 = original.split("\n");
        char[] symb = {'!','@','#','$','%','^','&','*','(',')','_','+','=',',','.','/','\\',';','"','?','№','—',':','\r','\n'};
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        for(int i=0;i<list1.length;i++){
            if(!list1[i].equals("\r")){
                list2.add(list1[i]);
            }
        }

        for(int i=0;i<list2.size();i++) {
            StringBuffer temp = new StringBuffer(list2.get(i));
            while (avail(temp, symb)) {
                for (int j = 0; j < symb.length; j++) {
                    if (temp.indexOf(String.valueOf(symb[j])) != -1) {
                        temp.replace(temp.indexOf(String.valueOf(symb[j])), temp.indexOf(String.valueOf(symb[j])) + 1, "");
                    }
                }
            }
            list2.set(i, String.valueOf(temp).trim());
        }

        for(int i=0;i<list2.size();i++){
            String temp = list2.get(i);
            String[] x = temp.split(" ");
            for(int j=0;j<x.length;j++){
                list3.add(x[j]);
            }
        }

        String y;
        for(int i=0;i<list3.size();i++){
            for(int j=i+1;j<list3.size();j++){
                if(list3.get(j).compareToIgnoreCase(list3.get(i))<0){
                    y = list3.get(i);
                    list3.set(i,list3.get(j));
                    list3.set(j,y);
                }
            }
        }

        String text = "";

        for(String s : list3){
            System.out.println(s);
            text += s + " ";
        }
        System.out.println();

        DataFromFile.writeToFile(text,"src/file2.txt");


        String f3 = "Было: \n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + original +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\nСтало: " +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n " + text +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        DataFromFile.writeToFile(f3,"src/file3.txt");
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
