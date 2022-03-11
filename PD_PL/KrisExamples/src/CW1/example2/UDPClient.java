package CW1.example2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {//описание класса клиента

    public void runClient() throws IOException {//методклиентаrunClient
        DatagramSocket s = null;//созданиедейтаграммы
        try {
            byte[] buf = new byte[512]; //буфер для приема/передачи дейтаграммы
            s = new DatagramSocket();//привязка сокета к реальному объету
            System.out.println("UDPClient: Started");
            byte[] verCmd = {'V', 'E', 'R', 'S'};
            DatagramPacket sendPacket = new DatagramPacket(verCmd,verCmd.length, InetAddress.getByName("127.0.0.1"), 8001);//создание
//дейтаграммы для отсылки данных
            s.send(sendPacket);//посылка дейтаграммы
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание дейтаграммы для получения данных
            s.receive(recvPacket);//получениедейтаграммы
            String version = new String(recvPacket.getData()).trim();//извлечение
//данных(версиисервера)
            System.out.println("UDPClient: ServerVersion: " + version);
            byte[] quitCmd = {'Q', 'U', 'I', 'T'};
            sendPacket.setData(quitCmd);//установить массив посылаемых данных
            sendPacket.setLength(quitCmd.length);//установить длину посылаемых
// данных
            s.send(sendPacket); //послать данные серверу
            System.out.println("UDPClient: Ended");
        } finally {
            if (s != null) {
                s.close();//закрытиесокетаклиента
            }
        }
    }

    public static void main(String[] args) {//методmain
        try {
            UDPClient client = new UDPClient();//созданиеобъектаclient
            client.runClient();//вызовметодаобъектаclient
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}