package by.bsac.practical7.individual.lab;

public class MyException2 extends Exception{
    private int num;

    public MyException2(int num){
        this.num = num;
    }

    @Override
    public String toString() {
        return num + " - не подходит";
    }
}
