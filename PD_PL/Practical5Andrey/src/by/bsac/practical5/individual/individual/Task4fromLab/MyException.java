package by.bsac.practical5.individual.individual.Task4fromLab;

public class MyException extends Exception{
    private int txt;

    MyException(int txt){
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "Налоговоая ставка \'" + txt + "\' слишком высока, ошибка!";
    }
}
