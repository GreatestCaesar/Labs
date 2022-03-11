package IPW2.Example4;

import java.awt.*;
import java.applet.*;

//создать класс апплета, который реализует интерфейс Runnable
public class AppletThreadSample extends Applet implements Runnable {
    private Thread T; //создать объект потока
    //объявление переменных
    private ShapeString m_ShapeString = null; //длястроки
    private ShapeOval m_ShapeOval = null; //дляовала
    private ShapeRect m_ShapeRect = null;//дляквадрата

    public void run() { //реализация метода run, точка входа в поток
        setBackground(Color.yellow); //фон апплета зарисовывается желтым
        while (true) { //бесконечный цикл
            repaint(); //перерисовка апплета или вызов метода paint
            try {
                T.sleep(10); //приостановка апплета на 10 миллисекунл
            } catch (InterruptedException e) {
            }
        }
    }

    public void init() { //метод инициализации апплета
        T = new Thread(this); //создание потока и привязка его к текущему классу
        T.start(); //запуск потока (вызывается run)
//созданиеобъектов
        m_ShapeString = new ShapeString();
        m_ShapeOval = new ShapeOval();
        m_ShapeRect = new ShapeRect();
    }

    public void paint(Graphics g) {//методпрорисовкиапплета
//прорисовкастроки
        g.drawString("This is ShapeString",
                m_ShapeString.x_String, m_ShapeString.y_String);
//прорисовкаквадрата
        g.setColor(Color.red);
        g.drawRect(m_ShapeRect.x_Rect, m_ShapeRect.y_Rect,
                m_ShapeRect.w_Rect, m_ShapeRect.h_Rect);
//прорисовкаовала
        g.setColor(Color.CYAN);
        g.fillOval(m_ShapeOval.x_Oval, m_ShapeOval.y_Oval,
                m_ShapeOval.w_Oval, m_ShapeOval.h_Oval);
    }
}