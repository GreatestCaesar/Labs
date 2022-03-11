package by.bsac.practical7.individual.Lab;

import java.util.Scanner;

public class PassengerPlane extends Plane{

    protected double capacity;

    public PassengerPlane() {
        range=350;
        fuelCons=200;
        capacity=90;
    }


    public PassengerPlane(double range, double fuelCons, double capacity) {
        super(range,fuelCons);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    Scanner scan=new Scanner(System.in);
    // общая вместимость
    public double totalCapacity(PassengerPlane...planes) {

        for(int i=0; i<planes.length; i++) {

            System.out.println("Введите, пожалуйста, дальность полета: ");
            String range1=scan.nextLine();
            double range=Double.parseDouble(range1);

            System.out.println("Введите, пожалуйста, потребление горючего: ");
            String fuelCons1=scan.nextLine();
            double fuelCons=Double.parseDouble(fuelCons1);

            System.out.println("Введите, пожалуйста, вместимость: ");
            String capacity1=scan.nextLine();
            double capacity=Double.parseDouble(capacity1);

            if(capacity<=10) {
                planes[i]=new Charter(range,fuelCons,capacity);
            }
            else {
                planes[i]=new PassengerPlane(range,fuelCons,capacity);
            }
        }

        double totalCap=0;
        for(int i=0; i<planes.length; i++) {
            totalCap=totalCap+planes[i].getCapacity();
        }
        return totalCap;
    }



    @Override
    public String toString() {
        return " Пассажирский самолет [дальность полета =" + range + ", потребление горючего =" + fuelCons + ", вместимость =" + capacity+"]";
    }


}
