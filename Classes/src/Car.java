
public class Car {
	private int doors;
	private int wheels;
	private String model;
	private String engine;
	private String colour;
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void printModel() {
		System.out.println(this.model);
	}
	
	public String getModel() {
		return this.model;
	}
	
}
