package by.bsac.practical6.individual;

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
