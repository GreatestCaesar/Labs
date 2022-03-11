package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class server {
    public static void main(String[] args) {//объявлениеобъектаклассаServerSocket
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;//объявлениеобъектаклассаSocket
        ObjectInputStream sois = null;//объявлениебайтовогопотокаввода
        ObjectOutputStream soos = null;//объявление байтового потока вывода
        Date date = new Date();
        String timeStamp = new SimpleDateFormat("yyyy:MM:dd").format(Calendar.getInstance().getTime());
        String prop = "* Возможности сервера *\nинфо - информация о создателе, дате создания, предназначение\nдата - информация о текущей дате\nдсл - не горит дсл\nнизск - низкая скорость\n678 - ошибки 678,651,815\nвыход - выход из приложения";
        try {
            System.out.println("Сервер запущен....");
            serverSocket = new ServerSocket(2525);//создание сокета сервера для //заданного порта
            clientAccepted = serverSocket.accept();//выполнение метода, который //обеспечивает реальное подключение сервера к клиенту
            System.out.println("Пользователь присоединился....");
//создание потока ввода soos= new
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());//созданиепотока
//вывода
            soos.writeObject(prop);
            String clientMessageRecieved = (String) sois.readObject();//объявление //строки и  присваивание ей данных потока ввода, представленных
//в виде строки (передано клиентом)
            while (!clientMessageRecieved.equals("выход"))//выполнениецикла: пока
//строка не будет равна «quite»
            {
                System.out.println("Клиент (" + date.getHours() +":" + date.getMinutes() + ":" + date.getSeconds() + "): " + clientMessageRecieved + "");
                switch (clientMessageRecieved){
                    case "инфо":{
                        System.out.println("Ответ: Автор: Кристина\nДата: 13.05.2021\nПомощь в решении проблем с интерактивной ZALA");
                        soos.writeObject("Автор: Кристина\nДата: 13.05.2021\nПомощь в решении проблем с интерактивной ZALA");
                        break;
                    }
                    case "дата":{
                        System.out.println("Ответ: " + timeStamp);
                        soos.writeObject(timeStamp);
                        break;
                    }
                    case "дсл":{
                        System.out.println("Ответ: Проверить порт -> Проверить целостность кабеля -> Вызвать мастера");
                        soos.writeObject("Проверить порт -> Проверить целостность кабеля -> Вызвать мастера");
                        break;
                    }
                    case "низск":{
                        System.out.println("Ответ: Перезагрузить модем -> Вызвать мастера");
                        soos.writeObject("Перезагрузить модем -> Вызвать мастера");
                        break;
                    }
                    case "678":{
                        System.out.println("Ответ: Проверить горит ли ДСЛ -> Проверить порт, в который подкл сетевой кабель -> Reset модема -> Вызвать мастера");
                        soos.writeObject("Проверить горит ли ДСЛ -> Проверить порт, в который подкл сетевой кабель -> Reset модема -> Вызвать мастера");
                        break;
                    }
                    default:{
                        System.out.println("Ответ: Нет такой команды");
                        soos.writeObject("Нет такой команды");
                        break;
                    }
                }
//верхнемурегистру
                //потокувывода
//присваивается значение строковой переменной (передается клиенту)
                clientMessageRecieved = (String) sois.readObject();//строке
//присваиваются данные потока ввода, представленные в виде строки
//(передано клиентом)
            }
        } catch (Exception e) {
        } finally {
            try {
                sois.close();//закрытие потока ввода
                soos.close();//закрытие потока вывода
                clientAccepted.close();//закрытие сокета, выделенного для клиента
                serverSocket.close();//закрытие сокета сервера
            } catch (Exception e) {
                e.printStackTrace();//вызывается метод исключения е
            }
        }
    }
}
