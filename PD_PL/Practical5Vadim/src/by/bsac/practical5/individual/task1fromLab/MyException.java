package by.bsac.practical5.individual.task1fromLab;

public class MyException extends Exception{
    double x;

    public MyException(double x){
        this.x = x;
    }

    @Override
    public String toString() {
        return "Вес камня - " + x + ": слишком маленький";
    }
}
