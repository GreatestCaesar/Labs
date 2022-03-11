package by.bsac.practical.individual.carriage;

import java.util.Scanner;

public class SecondClassCarriage extends Carriage {

	public SecondClassCarriage() {
		super();

	}


	public int Counter() {
		Scanner scan=new Scanner(System.in);
		System.out.print("¬ведите количество вагонов второго класса:");
		int counter=scan.nextInt();
		return counter;

	}


	public String toString() {

		return "\""+type+"\"";
	}

}
