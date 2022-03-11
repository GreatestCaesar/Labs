package by.bsac.practical6.individual;

public class Synch extends Thread{
    private Object o;

    Synch(Object o){
        super(String.valueOf(o.getClass()));
        this.o = o;
        start();
    }

    public void run(){
        System.out.println("Запустился поток " + Thread.currentThread());
        synchronized (o){
            System.out.println("-------------------------------------------------------");
            System.out.println("\nСейчас выполняется поток " + Thread.currentThread());
            System.out.println(o);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-------------------------------------------------------");
        }
    }
}
