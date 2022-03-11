package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public void runClient() throws IOException {//методклиентаrunClient
        DatagramSocket s = null;//созданиедейтаграммы

        try {
            Scanner scan = new Scanner(System.in);
            byte[] buf = new byte[512]; //буфер для приема/передачи дейтаграммы
            s = new DatagramSocket();//привязка сокета к реальному объету
            System.out.println("Клиент: Запущен");
            byte[] text = new byte[512];
            System.out.println("Клиент: Введите х: ");
            byte x = scan.nextByte();
            System.out.println("Клиент: Введите y: ");
            byte y = scan.nextByte();
            System.out.println("Клиент: Введите z: ");
            byte z = scan.nextByte();
            text[0] = x;
            text[1] = y;
            text[2] = z;
            DatagramPacket sendPacket = new DatagramPacket(text,text.length, InetAddress.getByName("127.0.0.1"), 8001);//создание
//дейтаграммы для отсылки данных
            s.send(sendPacket);//посылка дейтаграммы
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание дейтаграммы для получения данных
            s.receive(recvPacket);//получениедейтаграммы
            String b = new String(recvPacket.getData()).trim();//извлечение
//данных(версиисервера)
            System.out.println("Клиент: b = : " + b);
            System.out.println("Клиент: Остановлен");
        } finally {
            if (s != null) {
                s.close();//закрытиесокетаклиента
            }
        }
    }

    public static void main(String[] args) {//методmain
        try {
            Client client = new Client();//созданиеобъектаclient
            client.runClient();//вызовметодаобъектаclient
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
