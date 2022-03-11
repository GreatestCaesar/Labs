package IPW2.Example4;

class ShapeString implements Runnable{
    Thread T;
    int x_String, y_String;//координатыстроки
    public ShapeString(){//конструктор
        T = new Thread(this);//созданиеобъектаThread
//установление начальных координат строки
        x_String=100; y_String=100;
        T.start(); //запуск потока (вызов метода run)
    }
    public void run(){//методrun
        for(;;){
            x_String+=15; //изменение координаты строки
            try{
                T.sleep(1000); //приостановка работы потока на 1000 миллисекунд
            }
            catch(InterruptedException e){}
        }
    }
}
