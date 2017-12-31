
public class Car extends Vehicle{
	private int gear;
	private int tires;
	
	public Car(int seats, int doors, int speed, String color, int gear, int tires) {
		super(seats, doors, speed, color);
		this.gear = gear;
		this.tires = tires;
	}
	
	public void shiftGear(int gear) {
		this.gear = gear;
	}
	
	public void tirePuncture(int puntures) {
		this.tires -= puntures;
	}

	@Override
	public void move(int speed) {
		super.move(speed);
		System.out.println("This car is running at: " + speed);
	}
	
	
	
}
