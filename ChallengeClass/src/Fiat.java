
public class Fiat extends Car{
	private String model;
	private int licenceNum;
	
	public Fiat(int seats, int doors, int speed, String color, int gear, int tires, String model, int LicenceNum) {
		super(seats, doors, speed, color, gear, tires);
		this.model = model;
		this.licenceNum = licenceNum;
	}

	@Override
	public void move(int speed) {
		super.move(speed);
		System.out.println("This fiat is moving at: " + speed);
	}
	
	
}
