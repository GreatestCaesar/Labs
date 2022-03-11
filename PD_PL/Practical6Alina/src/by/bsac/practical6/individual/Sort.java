package by.bsac.practical6.individual;

public class Sort extends Thread{
    Derivativ[] derivativs;
    public Sort(Derivativ[] derivativs){
        this.derivativs = derivativs;
        start();
    }

    public void run(){
        synchronized (derivativs){
            for (int i = 0; i < derivativs.length; i++) {
                for (int j = i + 1; j < derivativs.length; j++) {
                    if (derivativs[i].degree > derivativs[j].degree) {
                        Derivativ temp = derivativs[i];
                        derivativs[i] = derivativs[j];
                        derivativs[j] = temp;
                    }
                }
            }
            derivativs.notify();
            try {
                derivativs.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
