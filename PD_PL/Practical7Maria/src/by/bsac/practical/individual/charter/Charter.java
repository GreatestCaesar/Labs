package by.bsac.practical.individual.charter;

import by.bsac.practical.individual.passenger.PassengerPlane;

public class Charter extends PassengerPlane {

	public Charter() {
		range=350;
		fuelCons=200;
		capacity=90;
	}

	public Charter(double range, double fuelCons, double capacity) {
		super(range,fuelCons, capacity);
	}

	@Override
	public String toString() {
		return "Чартер [дальность полета=" + range + ", потребление горючего=" + fuelCons + ", вместимость=" + capacity+"]";
	}

}
