package by.bsac.practical5.individual.Task4fromLab2.cargo;

import by.bsac.practical5.individual.Task4fromLab2.exception.RangeException;
import by.bsac.practical5.individual.Task4fromLab2.planes.Plane;

import java.util.Scanner;

public class CargoPlane extends Plane {

	protected double liftCap;//грузоподъемность

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
	public double totalLiftCap(CargoPlane...planes) throws RangeException {
		System.out.println("");
		System.out.println("Введите данные самолетов для рассчета общей грузоподъемности: ");
		System.out.println("");

		for(int i=0; i<planes.length; i++) {
			System.out.println((i+1)+"-й самолет: ");
			System.out.println("Введите дальность полета: ");
			String range1=scan.nextLine();
			if(Double.parseDouble(range1)>900){																			// собственное исключение
				throw new RangeException(Double.parseDouble(range1));
			}
			double range=Double.parseDouble(range1);

			System.out.println("Введите потребление горючего: ");
			String fuelCons1=scan.nextLine();
			double fuelCons=Double.parseDouble(fuelCons1);

			System.out.println("Введите грузоподъемность: ");
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

	//общая грузоподъемность 2
	public double totalLiftCap2(CargoPlane[] planes) {


		double totalLift=0;
		for(int i=0; i<planes.length; i++) {
			totalLift=totalLift+planes[i].getLiftCap();
		}
		return totalLift;
	}



	@Override
	public String toString() {
		return "Грузовой самолет [дальность полета=" + range + ", потребление горючего=" + fuelCons + ", грузоподъемность=" + liftCap+"]";
	}
}

