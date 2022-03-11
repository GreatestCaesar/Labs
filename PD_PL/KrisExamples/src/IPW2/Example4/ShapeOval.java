package IPW2.Example4;

class ShapeOval implements Runnable{
    Thread T;
    int x_Oval, y_Oval,w_Oval,h_Oval; //координатыиразмерыовала
    public ShapeOval(){//конструктор
        T = new Thread(this); //созданиеобъектаThread
//установление начальных координат овала
        x_Oval=30; y_Oval=30;w_Oval=100;h_Oval=90;
        T.start(); //запуск потока (вызов метода run)
    }
    public void run(){//методrun
        for(;;){//изменение координат овала
            x_Oval+=8;
            y_Oval+=7;
            try{
                T.sleep(100); //приостановка работы потока на 100 миллисекунд
            }
            catch(InterruptedException e){ }
        }
    }
}