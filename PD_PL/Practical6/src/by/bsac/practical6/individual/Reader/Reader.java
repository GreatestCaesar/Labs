package by.bsac.practical6.individual.Reader;

import by.bsac.practical6.individual.Library.Library;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class Reader extends Thread{
    private String name;
    public Object lock = new Object();
    private ArrayList<String> books = new ArrayList<>();

    public Reader(String name, Object lock) {
        super(name);
        this.name = name;
        this.lock = lock;
    }

    public String getReaderName() {
        return name;
    }

    public void setReaderName(String name) {
        this.name = name;
    }

    public void run(){
        synchronized (lock) {
            Scanner s = new Scanner(System.in);
            boolean b = true;
            char c;
            int num;
            while (b) {
                System.out.println(getReaderName());
                System.out.println("1. Взять книгу 2. Вернуть книгу 3. Вернуться к другим 4. Покинуть библиотеку");
                c = s.next().charAt(0);
                switch (c) {
                    case '1': {
                        System.out.println(Library.getInstance().toString());
                        System.out.println("Какую книгу желаете взять?");
                        num = s.nextInt();
                        books.add(Library.takeBook(num));
                        System.out.println("Ваши книги: ");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + " - " + books.get(i));
                        }
                        break;
                    }
                    case '2': {
                        if(books.size()==0){
                            break;
                        }else {
                            System.out.println("Ваши книги: ");
                            for (int i = 0; i < books.size(); i++) {
                                System.out.println((i + 1) + " - " + books.get(i));
                            }
                            System.out.println("Какую книгу желаете вернуть?");
                            num = s.nextInt();
                            Library.returnBook(books.get(num - 1));
                            books.remove(num - 1);
                            System.out.println("Ваши книги: ");
                            for (int i = 0; i < books.size(); i++) {
                                System.out.println((i + 1) + " - " + books.get(i));
                            }
                            break;
                        }
                    }
                    case '3': {
                        lock.notify();
                        try {
                            lock.wait();
                            break;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case '4': {
                        lock.notify();
                        b = false;
                        break;
                    }
                }
            }
        }
    }

    public void setLock(Object l){
        this.lock = l;
    }

    @Override
    public String toString() {
        return "Читатель{" +
                "имя='" + name + '\'' +
                '}';
    }
}
