package by.bsac.practical5.individual.Task4fromLab;

public class MyException extends Exception{
    private char x;

    MyException(char x){
        this.x = x;
    }

    @Override
    public String toString() {
        return "Вы ввели " + this.x + " некорректный символ";
    }
}
