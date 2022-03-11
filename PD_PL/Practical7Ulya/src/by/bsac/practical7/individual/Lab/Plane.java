package by.bsac.practical7.individual.Lab;

import java.util.Scanner;

public class Plane {

    protected double range;// дальность полета
    protected double fuelCons;//  расход топлива

    public Plane() {
        range=350;
        fuelCons=200;
    }

    public Plane(double range, double fuelCons) {
        this.range = range;
        this.fuelCons = fuelCons;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getFuelCons() {
        return fuelCons;
    }

    public void setFuelCons(double fuelCons) {
        this.fuelCons = fuelCons;
    }



    static Scanner scan=new Scanner(System.in);

    //сортировка по дальности полета
    public void sort(Plane...planes) {

        for(int i=0; i<planes.length; i++) {

            System.out.println("Введите, пожалуйста, дальность полета: ");
            String range1=scan.nextLine();
            double range=Double.parseDouble(range1);

            System.out.println("Введите, пожалуйста, потребление горючего: ");
            String fuelCons1=scan.nextLine();
            double fuelCons=Double.parseDouble(fuelCons1);

            planes[i]=new Plane(range,fuelCons);

        }


        for(int i=0; i<planes.length; i++) {
            for(int j=i+1;j<planes.length;j++) {
                if(planes[i].getRange()>planes[j].getRange()) {
                    Plane plan=planes[i];
                    planes[i]=planes[j];
                    planes[j]=plan;
                }
            }
        }

        for(int i=0; i<planes.length; i++) {
            System.out.println(planes[i]);
        }
    }

    //соответствие потребления горючего заданным рамкам
    public static void borders(Plane pl) {
        System.out.println("Введите дальность полета вашего самолета: ");
        String range1=scan.nextLine();
        double range=Double.parseDouble(range1);

        System.out.println("Введите потребление горючего вашего самолета: ");
        String fuelCons1=scan.nextLine();
        double fuelCons=Double.parseDouble(fuelCons1);

        System.out.println("Введите нижнюю границу потребления горючего: ");
        String ng1=scan.nextLine();
        double ng=Double.parseDouble(ng1);

        System.out.println("Введите верхнюю границу потребления горючего: ");
        String vg1=scan.nextLine();
        double vg=Double.parseDouble(vg1);

        pl=new Plane(range,fuelCons);

        if(pl.getFuelCons()>=ng && pl.getFuelCons()<=vg) {
            System.out.println("Потребление горючего входит в заданные границы!");
        }
        else {
            System.out.println("Потребление горючего не входит в заданные границы!");
        }
    }

    @Override
    public String toString() {
        return "Самолет [дальность полета =" + range + ", потребление горючего =" + fuelCons + "]";
    }
}
