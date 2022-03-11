package by.bsac.individual;

public class Main {
    public static void main(String[] args){
        Car c = new Car(1.8,"Belshina","Зима",205,55,5.5,16,40000,5000,"Mercedes",55,"Седан",2020);
        System.out.println(c);
        System.out.println(c.Mark());
        c.Fuel();
        System.out.println(c.Wear());
        System.out.println(c.Change());
    }
}
