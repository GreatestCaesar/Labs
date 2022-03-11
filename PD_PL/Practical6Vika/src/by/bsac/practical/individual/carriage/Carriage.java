package by.bsac.practical.individual.carriage;

abstract public class Carriage {
	protected String type;
	protected int seats;

	public Carriage() {
		this.type = type;
		this.seats = seats;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	abstract public int Counter();

	abstract public String toString();
}
