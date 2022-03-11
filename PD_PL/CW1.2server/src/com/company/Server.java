package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public void runServer() throws IOException {//методсервераrunServer
        DatagramSocket s = null;//созданиеобъектаDatagramSocket
        try {
            boolean stopFlag = false;//созданиефлагаstopFlagиегоинициализация
            //значением false
            byte[] buf = new byte[512];//буфер для приема/передачи дейтаграммы
            s = new DatagramSocket(8001);//привязкасокетак
            //реальному объекту с портом DEFAULT_PORT
            System.out.println("Сервер запущен");//вывод к консоль сообщения
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание объекта дейтаграммы для получения данных
            s.receive(recvPacket);//помещение полученного содержимого в
            //объект дейтаграммы
            //команды из пакета
            System.out.println("Сервер: Числа: " + buf[0] + " " + buf[1] + " " + buf[2]);
            double x = Double.parseDouble(String.valueOf(buf[0]));
            double y = Double.parseDouble(String.valueOf(buf[1]));
            double z = Double.parseDouble(String.valueOf(buf[2]));
            double b = Math.sqrt(10*(Math.sqrt(x) + Math.pow(x,y*z))*(Math.pow(Math.sin(z),2)+Math.abs(x+y)))*Math.pow(Math.exp(1),z);
            System.out.println("Сервер: b = " + b);
            String blen = b+"";
            byte[] bbyte = new byte[blen.length()];
            for(int i=0;i< bbyte.length;i++){
                bbyte[i] = (byte) blen.charAt(i);
            }
            DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(),recvPacket.getPort());//формированиеобъекта // дейтаграммыдляотсылкиданных
            System.arraycopy(bbyte, 0, buf, 0, blen.length());
            sendPacket.setData(buf);//установить массив посылаемых данных
            sendPacket.setLength(blen.length());//установить длину посылаемых данных
            s.send(sendPacket);//послать сами данные
            System.out.println("Сервер: Остановлен");
        } finally {
            if (s != null) {
                s.close();//закрытиесокетасервера
            }
        }
    }

    public static void main(String[] args) {//методmain
        try {
            Server udpSvr = new Server();//созданиеобъектаudpSvr
            udpSvr.runServer();//вызовметодаобъектаrunServer
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
