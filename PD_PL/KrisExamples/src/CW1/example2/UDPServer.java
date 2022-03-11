package CW1.example2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public final static int DEFAULT_PORT = 8001;//определениепорта
    //сервера
    public final String VERSION_CMD = "VERS";//определениеверсии
    //команды
    public final String QUIT_CMD = "QUIT";//определение
    //команды«выход»
    public final byte[] VERSION = {'V', '2', '.', '0'};//созданиемассива
    //дляопределенияверсиисервера
    public final byte[] UNKNOWN_CMD = {'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'c', 'o', 'm', 'm', 'a', 'n', 'd'};//неизвестная команда

    public void runServer() throws IOException {//методсервераrunServer
        DatagramSocket s = null;//созданиеобъектаDatagramSocket
        try {
            boolean stopFlag = false;//созданиефлагаstopFlagиегоинициализация
            //значением false
            byte[] buf = new byte[512];//буфер для приема/передачи дейтаграммы
            s = new DatagramSocket(DEFAULT_PORT);//привязкасокетак
            //реальному объекту с портом DEFAULT_PORT
            System.out.println("UDPServer: Started on " + s.getLocalAddress() + ":" + s.getLocalPort());//вывод к консоль сообщения
            while (!stopFlag) {//цикл до тех пор, пока флаг не примет значение true
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание объекта дейтаграммы для получения данных
                s.receive(recvPacket);//помещение полученного содержимого в
                //объект дейтаграммы
                String cmd = new String(recvPacket.getData()).trim();//извлечение
                //команды из пакета
                System.out.println("UDPServer: Command: " + cmd);
                DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(),recvPacket.getPort());//формированиеобъекта // дейтаграммыдляотсылкиданных
                int n = 0;//количество байт в ответе
                if (cmd.equals(VERSION_CMD)) {//проверка версии команды
                    n = VERSION.length;
                    System.arraycopy(VERSION, 0, buf, 0, n);
                } else if (cmd.equals(QUIT_CMD)) {
                    stopFlag = true;//остановка сервера
                    continue;
                } else {
                    n = UNKNOWN_CMD.length;
                    System.arraycopy(UNKNOWN_CMD, 0, buf, 0, n);
                }
                sendPacket.setData(buf);//установить массив посылаемых данных
                sendPacket.setLength(n);//установить длину посылаемых данных
                s.send(sendPacket);//послать сами данные
            } // while(server is not stopped)
            System.out.println("UDPServer: Stopped");
        } finally {
            if (s != null) {
                s.close();//закрытиесокетасервера
            }
        }
    }

    public static void main(String[] args) {//методmain
        try {
            UDPServer udpSvr = new UDPServer();//созданиеобъектаudpSvr
            udpSvr.runServer();//вызовметодаобъектаrunServer
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
