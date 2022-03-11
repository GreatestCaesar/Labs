package CW1.example1;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    public static void main(String[] arg){
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1", 2525);//установление //соединения между локальной машиной и указанным портом узла сети
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));//создание
//буферизированного символьного потока ввода
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание
//потокавывода
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание
//потокаввода
            System.out.println("Enter any string to send to server \n\t('quite' − programme terminate)");
            String clientMessage = stdin.readLine();
            System.out.println("you've entered: " + clientMessage);
            while (!clientMessage.equals("quite")) {//выполнениецикла, пока строка//не будет равна «quite»
                coos.writeObject(clientMessage);//потоку вывода присваивается //значение строковой переменной (передается серверу)
                System.out.println("~server~: " + cois.readObject());//выводится на //экран содержимое потока ввода (переданное сервером)
                System.out.println("---------------------------");
                clientMessage = stdin.readLine();//ввод текста с клавиатуры
                System.out.println("you've entered: " + clientMessage);//выводв
//консоль строки и значения строковой переменной
            }
            coos.close();//закрытие потока вывода
            cois.close();//закрытие потока ввода
            clientSocket.close();//закрытие сокета
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
