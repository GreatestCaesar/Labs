/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipr2;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Kris
 */
public class IPR2 extends JFrame{
    private static Image head;
    private static Image hand1;
    private static Image hand2;
    private static Image torso;
    private static Image leg1;
    private static Image leg2;
    private int phase = 1;
    private int headX = 400, headY = 200,
            hand1X = 380, hand1Y = 250,
            hand2X = 425, hand2Y = 250,
            torsoX = 409, torsoY = 243,
            leg1X = 385, leg1Y = 300,
            leg2X = 418, leg2Y = 295;

    private int headW = 60, headH = 60,
            hand1W = 60, hand1H = 70,
            hand2W = 45, hand2H = 60,
            torsoW = 40, torsoH = 80,
            leg1W = 60, leg1H = 70,
            leg2W = 60, leg2H = 70;

    public IPR2() {
        setTitle("Demo app");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        // панель устанавливается как contentPane в наследнике JFrame
        Container content = getContentPane();
        //теперь все элементы интерфейса будут на этой панели.
        Thread manth = new Thread(new ManThread());
        manth.start();
        content.add(new ManRun());
    }

    private class ManRun extends JPanel {
        public ManRun() {
            setOpaque(false);
            setPreferredSize(new Dimension(1000, 600));
            try {
                head = ImageIO.read(new File("head.png"));
                hand1 = ImageIO.read(new File("hand1.png"));
                hand2 = ImageIO.read(new File("hand44.png"));
                torso = ImageIO.read(new File("torso.png"));
                leg1 = ImageIO.read(new File("hand11.png"));
                leg2 = ImageIO.read(new File("hand4.png"));


            }catch (IOException exc) { }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D graphics2D = (Graphics2D) g;
            graphics2D.drawImage(hand2, hand2X, hand2Y, hand2W, hand2H, this);
            graphics2D.drawImage(leg1, leg1X, leg1Y, leg1W, leg1H, this);
            graphics2D.drawImage(head, headX, headY, headW, headH, this);
            graphics2D.drawImage(torso, torsoX, torsoY, torsoW, torsoH, this);
            graphics2D.drawImage(hand1, hand1X, hand1Y, hand1W, hand1H, this);
            graphics2D.drawImage(leg2, leg2X, leg2Y, leg2W, leg2H, this);
        }
    }

    public class ManThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                switch(phase){
                    case 1:{
                        try{
                            hand1 = ImageIO.read(new File("hand1.png"));
                            hand2 = ImageIO.read(new File("hand44.png"));
                            leg1 = ImageIO.read(new File("hand11.png"));
                            leg2 = ImageIO.read(new File("hand4.png"));
                            hand1X = 380; hand1Y = 250;
                            hand2X = 425; hand2Y = 250;
                            leg1X = 385; leg1Y = 300;
                            leg2X = 418; leg2Y = 295;
                            hand1W = 60; hand1H = 70;
                            hand2W = 45; hand2H = 60;
                            leg1W = 60; leg1H = 70;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 2:{
                        try{
                            hand1 = ImageIO.read(new File("hand2.png"));
                            hand2 = ImageIO.read(new File("hand33.png"));
                            leg1 = ImageIO.read(new File("hand22.png"));
                            leg2 = ImageIO.read(new File("hand3.png"));
                            hand1X = 380; hand1Y = 250;
                            hand2X = 425; hand2Y = 250;
                            leg1X = 387; leg1Y = 295;
                            leg2X = 418; leg2Y = 295;
                            hand1W = 60; hand1H = 70;
                            hand2W = 45; hand2H = 60;
                            leg1W = 60; leg1H = 70;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 3:{
                        try{
                            hand1 = ImageIO.read(new File("torso.png"));
                            hand2 = ImageIO.read(new File("torso.png"));
                            leg1 = ImageIO.read(new File("torso.png"));
                            leg2 = ImageIO.read(new File("torso.png"));
                            hand1X = 399; hand1Y = 250;
                            hand2X = 399; hand2Y = 250;
                            leg1X = 399; leg1Y = 293;
                            leg2X = 399; leg2Y = 293;
                            hand1W = 60; hand1H = 70;
                            hand2W = 60; hand2H = 70;
                            leg1W = 60; leg1H = 70;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 4:{
                        try{
                            hand1 = ImageIO.read(new File("hand3.png"));
                            hand2 = ImageIO.read(new File("hand22.png"));
                            leg1 = ImageIO.read(new File("hand33.png"));
                            leg2 = ImageIO.read(new File("hand2.png"));
                            hand1X = 415; hand1Y = 250;
                            hand2X = 395; hand2Y = 250;
                            leg1X = 418; leg1Y = 300;
                            leg2X = 387; leg2Y = 295;
                            hand1W = 60; hand1H = 70;
                            hand2W = 45; hand2H = 60;
                            leg1W = 50; leg1H = 60;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 5:{
                        try{
                            hand1 = ImageIO.read(new File("hand4.png"));
                            hand2 = ImageIO.read(new File("hand11.png"));
                            leg1 = ImageIO.read(new File("hand44.png"));
                            leg2 = ImageIO.read(new File("hand1.png"));
                            hand1X = 420; hand1Y = 250;
                            hand2X = 395; hand2Y = 250;
                            leg1X = 425; leg1Y = 300;
                            leg2X = 385; leg2Y = 295;
                            hand1W = 50; hand1H = 60;
                            hand2W = 45; hand2H = 60;
                            leg1W = 50; leg1H = 60;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 6:{
                        try{
                            hand1 = ImageIO.read(new File("hand3.png"));
                            hand2 = ImageIO.read(new File("hand22.png"));
                            leg1 = ImageIO.read(new File("hand33.png"));
                            leg2 = ImageIO.read(new File("hand2.png"));
                            hand1X = 415; hand1Y = 250;
                            hand2X = 395; hand2Y = 250;
                            leg1X = 418; leg1Y = 300;
                            leg2X = 387; leg2Y = 295;
                            hand1W = 60; hand1H = 70;
                            hand2W = 45; hand2H = 60;
                            leg1W = 50; leg1H = 60;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 7:{
                        try{
                            hand1 = ImageIO.read(new File("torso.png"));
                            hand2 = ImageIO.read(new File("torso.png"));
                            leg1 = ImageIO.read(new File("torso.png"));
                            leg2 = ImageIO.read(new File("torso.png"));
                            hand1X = 399; hand1Y = 250;
                            hand2X = 399; hand2Y = 250;
                            leg1X = 399; leg1Y = 293;
                            leg2X = 399; leg2Y = 293;
                            hand1W = 60; hand1H = 70;
                            hand2W = 60; hand2H = 70;
                            leg1W = 60; leg1H = 70;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 8:{
                        try{
                            hand1 = ImageIO.read(new File("hand2.png"));
                            hand2 = ImageIO.read(new File("hand33.png"));
                            leg1 = ImageIO.read(new File("hand22.png"));
                            leg2 = ImageIO.read(new File("hand3.png"));
                            hand1X = 380; hand1Y = 250;
                            hand2X = 425; hand2Y = 250;
                            leg1X = 387; leg1Y = 295;
                            leg2X = 418; leg2Y = 295;
                            hand1W = 60; hand1H = 70;
                            hand2W = 45; hand2H = 60;
                            leg1W = 60; leg1H = 70;
                            leg2W = 60; leg2H = 70;
                            phase++;
                        }catch(Exception e){

                        }
                        break;
                    }
                    case 9:{
                        try{
                            hand1 = ImageIO.read(new File("hand1.png"));
                            hand2 = ImageIO.read(new File("hand44.png"));
                            leg1 = ImageIO.read(new File("hand11.png"));
                            leg2 = ImageIO.read(new File("hand4.png"));
                            hand1X = 380; hand1Y = 250;
                            hand2X = 425; hand2Y = 250;
                            leg1X = 385; leg1Y = 300;
                            leg2X = 418; leg2Y = 295;
                            hand1W = 60; hand1H = 70;
                            hand2W = 45; hand2H = 60;
                            leg1W = 60; leg1H = 70;
                            leg2W = 60; leg2H = 70;
                            phase=2;
                        }catch(Exception e){

                        }
                        break;
                    }
                }
                repaint();
                try {
                    Thread.sleep(130);
                } catch (Exception exc) { }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IPR2().setVisible(true);
            }
        });
    }


}
