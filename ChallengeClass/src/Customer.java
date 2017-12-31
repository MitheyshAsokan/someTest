
public class Customer {
	private String name;
	private double charge;

	public Customer(String name, double charge) {
		this.name = name;
		this.charge = charge;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		this.charge = charge;
	}
	
	
}
