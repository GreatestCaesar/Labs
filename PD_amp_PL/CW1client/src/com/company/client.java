package com.company;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class client {
    public static void main(String[] args) {
        try {
            System.out.println("Подключение к серверу....");
            Socket clientSocket = new Socket("127.0.0.1", 2525);//установление //соединения между локальной машиной и указанным портом узла сети
            System.out.println("Соединение установлено....");
            Date date = new Date();
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));//создание
//буферизированного символьного потока ввода
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());//создание
//потокавывода
            ObjectInputStream cois = new ObjectInputStream(clientSocket.getInputStream());//создание
//потокаввода
            System.out.println("Сервер (" + date.getHours() +":" + date.getMinutes() + ":" + date.getSeconds() + "): " + cois.readObject());
            String clientMessage = stdin.readLine();
            while (!clientMessage.equals("выход")) {//выполнениецикла, пока строка//не будет равна «quite»
                coos.writeObject(clientMessage);//потоку вывода присваивается //значение строковой переменной (передается серверу)
                System.out.println("Вы (" + date.getHours() +":" + date.getMinutes() + ":" + date.getSeconds() + "): " + clientMessage);
                System.out.println("Сервер (" + date.getHours() +":" + date.getMinutes() + ":" + date.getSeconds() + "): " + cois.readObject());
                System.out.println("---------------------------");
                clientMessage = stdin.readLine();//ввод текста с клавиатуры
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
