package by.bsac.practical.individual.exception;

public class RangeException extends Exception{
    double n;

    public RangeException(double num){
        n = num;
    }

    @Override
    public String toString() {
        return "Недопустимое расстояние: " + n;
    }
}
