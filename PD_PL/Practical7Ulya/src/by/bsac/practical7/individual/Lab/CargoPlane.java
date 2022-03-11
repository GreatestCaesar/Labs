package by.bsac.practical7.individual.Lab;

import java.util.Scanner;

public class CargoPlane extends Plane {

    protected double liftCap;

    public CargoPlane() {
        range=350;
        fuelCons=200;
        liftCap=150;
    }

    public CargoPlane(double range, double fuelCons, double liftCap) {
        super(range,fuelCons);
        this.liftCap = liftCap;
    }

    public double getLiftCap() {
        return liftCap;
    }

    public void setLiftCap(double liftCap) {
        this.liftCap = liftCap;
    }

    Scanner scan=new Scanner(System.in);
    //общая грузоподъемность
    public double totalLiftCap(CargoPlane...planes) {
        for(int i=0; i<planes.length; i++) {

            System.out.println("Введите, пожалуйста, дальность полета: ");
            String range1=scan.nextLine();
            double range=Double.parseDouble(range1);

            System.out.println("Введите, пожалуйста, потребление горючего: ");
            String fuelCons1=scan.nextLine();
            double fuelCons=Double.parseDouble(fuelCons1);

            System.out.println("Введите, пожалуйста, грузоподъемность: ");
            String liftCap1=scan.nextLine();
            double liftCap=Double.parseDouble(liftCap1);

            planes[i]=new CargoPlane(range,fuelCons,liftCap);

        }

        double totalLift=0;
        for(int i=0; i<planes.length; i++) {
            totalLift=totalLift+planes[i].getLiftCap();
        }
        return totalLift;
    }



    @Override
    public String toString() {
        return "Грузовой самолет [дальность полета =" + range + ", потребление горючего =" + fuelCons + ", грузоподъемность =" + liftCap+"]";
    }




}
