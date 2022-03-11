package by.bsac.practical6.individual;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();                                                                             // объект, который служит ключом для синхронизации, у кого ключ, тот и работает
        Scanner s = new Scanner(System.in);
        synchronized (lock) {
            boolean k = true;
            char c;
            while (k) {
                System.out.println("1. Создать мотоциклиста 2. Перейти к мотоциклистам");
                c = s.next().charAt(0);
                switch (c) {
                    case '1': {
                        new Thread(new Menu(lock));                                                             // создание нового мотоциклиста в новом потоке
                        break;
                    }
                    case '2': {
                        lock.notify();                                                                          // передаём ключ остальным потокам
                        lock.wait();                                                                            // ждем пока вернут ключ
                        break;
                    }
                    case '3': {
                        k = false;
                        break;
                    }
                    default: {
                        System.out.println("Ошибка");
                        break;
                    }
                }
            }
        }
    }
}
