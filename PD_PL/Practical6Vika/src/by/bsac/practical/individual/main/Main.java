package by.bsac.practical.individual.main;


import by.bsac.practical.individual.train.RailwayTransport;

public class Main {
	public static void main(String [] args) {
		Lock l = new Lock(1);
		new Thread(new RailwayTransport("Первый",l));
		new Thread(new RailwayTransport("Второй",l));
		new Thread(new RailwayTransport("Третий",l));
	}
}
