package by.bsac.practical.individual.carriage;

import java.util.Scanner;

public class General extends Carriage {

	public General() {
		super();

	}
	public int Counter() {
		Scanner scan=new Scanner(System.in);
		System.out.print("Введите количество вагонов общего типа:");
		int counter=scan.nextInt();
		return counter;
	}


	public String toString() {
		return "\""+type+"\"";
	}

}
