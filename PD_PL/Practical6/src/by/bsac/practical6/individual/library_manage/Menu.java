package by.bsac.practical6.individual.library_manage;

import by.bsac.practical6.individual.Library.Library;
import by.bsac.practical6.individual.Reader.Reader;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Menu {
    public static void main(String[] args) throws InterruptedException {
        menu();
    }

    public static void menu() throws InterruptedException {
        Object lock = new Object();
        synchronized (lock) {
            String on = "";
            ArrayList<Reader> list = new ArrayList<>();
            Scanner s = new Scanner(System.in);
            boolean k = true;
            String c;
            String name = "";
            int l = 0, m = 0;
            while (k) {
                System.out.println("Добавить читателя? д - да, н - нет");
                System.out.println("Ожидающие читатели - о");
                c = s.nextLine();
                switch (c) {
                    case "д": {
                        System.out.println("Введите имя читателя: ");
                        name = s.nextLine();
                        Reader reader = new Reader(name,lock);
                        Thread threader = new Thread(reader);
                        list.add(reader);
                        threader.start();
                        lock.wait();
                        break;
                    }
                    case "н": {
                        k = false;
                        break;
                    }
                    case "о": {
                        for (int i=0;i<list.size();i++){
                            System.out.println(i+"-"+list.get(i));
                        }
                        System.out.println("Введите номер потока, к которому желаете перейти: ");
                        l = s.nextInt();
                        list.get(l).lock.notify();
                        lock.wait();
                        break;
                    }
                    default: {
                        System.out.println("Повторите ввод!");
                        break;
                    }
                }
            }
        }
    }
}
