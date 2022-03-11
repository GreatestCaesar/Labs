package IPW2.Example3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SynchroFile {
    File f=new File("file.txt");
    public SynchroFile(){
        System.out.println("Object SynchroFile creating...");
        try{
            f.delete(); //удалить файл если он есть
            f.createNewFile(); //создать новый файл
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public synchronized void writing(String str,int i){
        try{
            RandomAccessFile raf=new RandomAccessFile(f,"rw");
            raf.seek(raf.length()); //переместить указатель в конец
            System.out.print(str);
            raf.writeBytes(str); //записать в файл
// на случайное значение приостанавить поток
            Thread.sleep((long)(Math.random()*15));
            raf.seek(raf.length()); //переместить указатель в конец
            System.out.print("->"+i+" \n");
            raf.writeBytes("->"+i+" \n"); //записать в файл
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
        notify(); //известить об окончании работы с методом
    }

}
