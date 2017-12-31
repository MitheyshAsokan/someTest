
public class Hamburger {
	private String breadRoll;
	private String meat;
	private double price;
	private String name;
	
	private String add1Name;
	private double add1Price = 0;
	
	private String add2Name;
	private double add2Price = 0;
	
	private String add3Name;
	private double add3Price = 0;
	
	private String add4Name;
	private double add4Price = 0;
	
	public Hamburger(String breadRoll, String meat, double price, String name) {
		this.breadRoll = breadRoll;
		this.meat = meat;
		this.price = price;
		this.name = name;
	}
	
	public void burgerAddOn1(String name, double price) {
		this.add1Name = name;
		this.add1Price = price;
	}
	
	public void burgerAddOn2(String name, double price) {
		this.add2Name = name;
		this.add2Price = price;
	}
	
	public void burgerAddOn3(String name, double price) {
		this.add3Name = name;
		this.add3Price = price;
	}
	
	public void burgerAddOn4(String name, double price) {
		this.add4Name = name;
		this.add4Price = price;
	}
	
	public double price() {
		double result = price + add1Price + add2Price + add3Price + add4Price;
		return result;
	}
	
	public String getBreadRoll() {
		return breadRoll;
	}
	public String getMeat() {
		return meat;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}

	public String getAdd1Name() {
		return add1Name;
	}

	public double getAdd1Price() {
		return add1Price;
	}

	public String getAdd2Name() {
		return add2Name;
	}

	public double getAdd2Price() {
		return add2Price;
	}

	public String getAdd3Name() {
		return add3Name;
	}

	public double getAdd3Price() {
		return add3Price;
	}

	public String getAdd4Name() {
		return add4Name;
	}

	public double getAdd4Price() {
		return add4Price;
	}
	
	
	
}
