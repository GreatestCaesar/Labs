package IPW2.Example4;

class ShapeRect implements Runnable{
    Thread T;
    int x_Rect,y_Rect,w_Rect,h_Rect; //координатыиразмерыквадрата
    public ShapeRect(){//конструктор
        T = new Thread(this); //созданиеобъектаThread
//установление начальных координат квадрата
        x_Rect=350;y_Rect=50;w_Rect=100;h_Rect=100;
        T.start();//запуск потока (вызов метода run)
    }
    public void run(){//методrun
        for(;;){
            x_Rect-=15; //изменение координаты квадрата
            try{
                T.sleep(500); //приостановка работы потока на 1000 миллисекунд
            }
            catch(InterruptedException e){}
        }
    }
}
