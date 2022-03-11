package by.bsac.practical5.individual.Task4fromLab2.planes;

import by.bsac.practical5.individual.Task4fromLab2.exception.RangeException;

import java.util.Scanner;

public class Plane {

	protected double range;//дальность полета
	protected double fuelCons;//потребление горючего

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
		System.out.println("");
		System.out.println("Введите данные самолетов для их сортировки по дальности полета: ");
		System.out.println("");
		for(int i=0; i<planes.length; i++) {
			System.out.println((i+1)+"-й самолет: ");
			System.out.println("Введите дальность полета: ");
			String range1=scan.nextLine();
			double range=Double.parseDouble(range1);

			System.out.println("Введите потребление горючего: ");
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

	//сортировка по дальности полета 2
	public void sort1(Plane[] planes) {

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
	public static void borders(Plane pl) throws RangeException {
		System.out.println("");
		System.out.println("Введите данне для проверки соответствия потребления горючего заданным рамкам: ");
		System.out.println("");
		System.out.println("Введите дальность полета вашего самолета: ");
		String range1=scan.nextLine();
		if(Double.parseDouble(range1)>900){																			// собственное исключение
			throw new RangeException(Double.parseDouble(range1));
		}
		double range=Double.parseDouble(range1);

		System.out.println("Введите потребление горючего вашего самолета: ");
		String fuelCons1=scan.nextLine();
		double fuelCons=Double.parseDouble(fuelCons1);

		System.out.println("Введите нижнюю границу потребления горючего: ");
		String downBorder1=scan.nextLine();
		double downBorder=Double.parseDouble(downBorder1);

		System.out.println("Введите верхнюю границу потребления горючего: ");
		String hideBorder1=scan.nextLine();
		double hideBorder=Double.parseDouble(hideBorder1);

		pl=new Plane(range,fuelCons);

		if(pl.getFuelCons()>=downBorder && pl.getFuelCons()<=hideBorder) {
			System.out.println("Потребление горючего входит в заданные границы!");
		}
		else {
			System.out.println("Потребление горючего не входит в заданные границы!");
		}
	}

	@Override
	public String toString() {
		return "Самолет [дальность полета=" + range + ", потребление горючего=" + fuelCons + "]";
	}



}
