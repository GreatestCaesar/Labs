package by.bsac.practical7.individual.lab;

public class MyExeption extends Exception{
    private int txt;

    MyExeption(int txt){
        this.txt = txt;
    }

    @Override
    public String toString() {
        return "Значение рисков = " + txt + " слишком велико, ошибка!";
    }
}
