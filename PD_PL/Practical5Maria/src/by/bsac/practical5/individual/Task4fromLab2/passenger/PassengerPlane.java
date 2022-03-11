package by.bsac.practical5.individual.Task4fromLab2.passenger;

import by.bsac.practical5.individual.Task4fromLab2.charter.Charter;
import by.bsac.practical5.individual.Task4fromLab2.exception.RangeException;
import by.bsac.practical5.individual.Task4fromLab2.planes.Plane;

import java.util.Scanner;

public class PassengerPlane extends Plane{

	protected double capacity; //вместимость

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
	//общая вместимость
	public double totalCapacity(PassengerPlane...planes) throws RangeException {

		System.out.println("");
		System.out.println("Введите данные самолетов для рассчета общей вместимости: ");
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

			System.out.println("Введите вместимость: ");
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


	//общая вместимость
	public double totalCapacity2(PassengerPlane[] planes) {

		double totalCap=0;
		for(int i=0; i<planes.length; i++) {
			totalCap=totalCap+planes[i].getCapacity();
		}
		return totalCap;
	}




	@Override
	public String toString() {
		return "Пассажирский самолет [дальность полета=" + range + ", потребление горючего=" + fuelCons + ", вместимость=" + capacity+"]";
	}


}
