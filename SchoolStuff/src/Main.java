
public class Main {
	public static void main(String[] args) {
		Person newGuy = new Person(5);
		newGuy.addPerson("Jeff", 1000, 1);
		newGuy.addPerson("Jenn", 1001, 2);
		newGuy.addPerson("Jett", 1002, 3);
		newGuy.addPerson("Jeyy", 1003, 4);
		newGuy.addPerson("Jess", 1004, 5);
		
		//Just spacing
		System.out.println();
		
		for(Person i: newGuy.getTheList()) {
			System.out.println(i.Name + " has a salary of " + i.Salary);
		}
		
	}
}
