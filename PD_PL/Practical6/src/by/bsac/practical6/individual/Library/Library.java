package by.bsac.practical6.individual.Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Library {
    private static String books = "Мастер и Маргарита;Алые паруса;Человек в футляре;Евгений Онегин;Идиот;Анна Каренина";

    private Library() {
    }

    public static class LibraryHolder {
        public static final Library HOLDER_INSTANCE = new Library();
    }

    public static Library getInstance() {
        return LibraryHolder.HOLDER_INSTANCE;
    }

    public static String takeBook(int n){
        String[] b = books.split(";");
        String str = b[n-1];
        books = "";
        for(int i=0;i<n-1;i++){
            books += b[i] + ";";
        }
        for(int i=n;i<b.length;i++){
            books += b[i] + ";";
        }
        return str;
    }

    public static void returnBook(String s){
        books += s+";";
    }

    @Override
    public String toString() {
        String[] b = books.split(";");
        String str = "";
        for(int i=0;i<b.length;i++){
            str += (i+1) + " - " + b[i] + "\n";
        }
        return "Библиотека{" +
                "книги=\n" + str +
                '}';
    }
}
