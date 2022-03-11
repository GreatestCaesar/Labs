package by.bsac.practical.individual.carriage;

import java.util.Scanner;

public class FirstClassCarriage extends Carriage {
	public FirstClassCarriage() {
		super();
	}


	public int Counter() {
		Scanner scan=new Scanner(System.in);
		System.out.print("¬ведите количество вагонов первого класса: ");
		int counter=scan.nextInt();
		return counter;
	}

	public String toString() {
		return "\""+type+"\"";
	}




}
