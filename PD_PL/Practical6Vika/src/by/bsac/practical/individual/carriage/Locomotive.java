package by.bsac.practical.individual.carriage;

import java.util.Scanner;

public class Locomotive extends Carriage {
	public Locomotive() {
		super();
		
	}
	public int Counter() {
		int counter=2;
		return counter;
	}

	
	public String toString() {
		return "\""+type+"\"";
	}
}
