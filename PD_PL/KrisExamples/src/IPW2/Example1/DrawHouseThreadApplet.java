package IPW2.Example1;

import java.awt.*;
import java.applet.*;
public class DrawHouseThreadApplet extends Applet implements Runnable
{
    int level = 0;
    Thread t;
    //функция инициализации апплета
    public void init()
    {
        this.setBackground(Color.white);
        t = new Thread(this);
        t.start();
    }
    //функцияперерисовкиапплета
    public void paint(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        if(level == 1)
        {
            g.drawLine(50, 150, 200, 50);
            g.drawLine(200, 50, 350, 150);
            g.drawLine(350, 150, 50, 150);
        }
        if(level == 2)
        {
            g.drawLine(50, 150, 200, 50);
            g.drawLine(200, 50, 350, 150);
            g.drawLine(350, 150, 50, 150);
            g.drawRect(100, 150, 200, 200);
        }
        if(level == 3)
        {
            g.drawLine(50, 150, 200, 50);
            g.drawLine(200, 50, 350, 150);
            g.drawLine(350, 150, 50, 150);
            g.drawRect(100, 150, 200, 200);
            g.drawRect(170, 200, 60, 100);
        }
        if(level == 4)
        {
            g.drawLine(50, 150, 200, 50);
            g.drawLine(200, 50, 350, 150);
            g.drawLine(350, 150, 50, 150);
            g.drawRect(100, 150, 200, 200);
            g.drawRect(170, 200, 60, 100);
            g.drawLine(200, 200, 200, 300);
            g.drawLine(170, 250, 230, 250);
            g.setColor(Color.MAGENTA);
            g.drawString("Домик", 190, 30);
        }
    }

    //запускпотока
    public void run()
    {
        System.out.println("Run");
        while(true)
        {
            level ++;
            repaint();
            try{
                Thread.currentThread().sleep(3000);
            }
            catch(Exception ex){}
            if(level == 4)
            {
                return;
            }
        }
    }
}
