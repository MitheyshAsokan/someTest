
public class Vehicle {
	private int seats;
	private int speed;
	private int doors;
	private String color;
	public int balls;
	
	public Vehicle(int seats, int doors, int speed, String color) {
		this.seats = seats;
		this.doors = doors;
		this.speed = speed;
		this.color = color;
	}
	
	public Vehicle() {
		this.seats = 1;
		this.doors = 1;
		this.speed = 0;
		this.color = "Unknown";
	}
	
	public Vehicle(String color) {
		this(1,1,0,color);
	}
	
	public void move(int speed) {
		this.speed = speed;
		System.out.println("The vehicle is moving at " + speed + ".");
	}
	
	public void crash() {
		System.out.println("The vehicle is dead.");
	}
	
	
}
