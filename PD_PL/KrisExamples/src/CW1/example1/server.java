package CW1.example1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] arg) {//объявлениеобъектаклассаServerSocket
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;//объявлениеобъектаклассаSocket
        ObjectInputStream sois = null;//объявлениебайтовогопотокаввода
        ObjectOutputStream soos = null;//объявление байтового потока вывода
        try {
            System.out.println("serverstarting....");
            serverSocket = new ServerSocket(2525);//создание сокета сервера для //заданного порта
            clientAccepted = serverSocket.accept();//выполнение метода, который //обеспечивает реальное подключение сервера к клиенту
            System.out.println("connection established....");
//создание потока ввода soos= new
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());//созданиепотока
//вывода
            String clientMessageRecieved = (String) sois.readObject();//объявление //строки и  присваивание ей данных потока ввода, представленных
//в виде строки (передано клиентом)
            while (!clientMessageRecieved.equals("quite"))//выполнениецикла: пока
//строка не будет равна «quite»
            {
                System.out.println("message recieved: '" + clientMessageRecieved + "'");
                clientMessageRecieved = clientMessageRecieved.toUpperCase();//приведениесимволовстрокик
//верхнемурегистру
                soos.writeObject(clientMessageRecieved);//потокувывода
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
