
public class DeluxeBurger extends Hamburger{
	public DeluxeBurger() {
		super("White", "Bacon and Sausage", 10.5, "Deluxe");
		super.burgerAddOn1("Chips", 2);
		super.burgerAddOn2("Drinks", 3);
	}

	@Override
	public void burgerAddOn1(String name, double price) {
		System.out.println("This is not allowed");
	}

	@Override
	public void burgerAddOn2(String name, double price) {
		System.out.println("This is not allowed");
	}

	@Override
	public void burgerAddOn3(String name, double price) {
		System.out.println("This is not allowed");
	}

	@Override
	public void burgerAddOn4(String name, double price) {
		System.out.println("This is not allowed");
	}
	
	
}
