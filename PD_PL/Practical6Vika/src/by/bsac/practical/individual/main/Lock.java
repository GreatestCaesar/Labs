package by.bsac.practical.individual.main;

public class Lock {
    private int lock;

    public Lock(int x){
        lock = x;
    }

    public int getLock() {
        return lock;
    }

    public void setLock(int lock) {
        this.lock = lock;
    }
}
