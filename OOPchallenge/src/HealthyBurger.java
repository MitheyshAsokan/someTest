
public class HealthyBurger extends Hamburger{
	private String add5Name;
	private double add5Price = 0;
	
	private String add6Name;
	private double add6Price = 0;
	
	public HealthyBurger(String meat, double price, String name) {
		super("Brown Rye", meat, price, name);
	}
	
	public void burgerAddOn5(String name, double price) {
		this.add5Name = name;
		this.add5Price = price;
	}
	
	public void burgerAddOn6(String name, double price) {
		this.add6Name = name;
		this.add6Price = price;
	}
	
	public double price() {
		double result = super.price() + add5Price + add6Price;
		return result;
	}
	
	public String getAdd5Name() {
		return add5Name;
	}

	public double getAdd5Price() {
		return add5Price;
	}

	public String getAdd6Name() {
		return add6Name;
	}

	public double getAdd6Price() {
		return add6Price;
	}
	
	
}
