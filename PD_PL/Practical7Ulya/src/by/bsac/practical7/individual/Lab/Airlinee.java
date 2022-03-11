package by.bsac.practical7.individual.Lab;

import java.util.Scanner;

public class Airlinee {

    Scanner scan=new Scanner(System.in);

    Plane[] pl= new Plane[3];



    //общая вместимость
    public double totalCapacity(PassengerPlane...planes) {
	/*for(int i=0;i<3;i++) {
		System.out.println(pl[i]);
	}
	*/
        for(int i=0; i<planes.length; i++) {

            System.out.println("Введите, пожалуйста, далность палета: ");
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


    // общая грузоподъемность
    public double totalLiftCap(CargoPlane...planes) {
        for(int i=0; i<planes.length; i++) {

            System.out.println("Введите, пожалуйста, дальность палета: ");
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

    //сортировка по дальности полета
    public void sort(Plane...planes) {

        for(int i=0; i<planes.length; i++) {

            System.out.println("Введите, пожалуйста, дальность полета:");
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




}
