
public class MAIN {
	public static void main(String[] args) {
		DeluxeBurger myNew = new DeluxeBurger();
		myNew.burgerAddOn1("Lettuce", 1);
		myNew.burgerAddOn2("Tomato", 1);
		myNew.burgerAddOn3("Mayo", 0.5);
		myNew.burgerAddOn4("Onions", 1);

		System.out.println("The price is: " + myNew.price());
		
	}
}
