
public class Person {
	public String Name;
	public int Salary;
	
	private Person[] theList;
	
	public Person(int value) {
		theList = new Person[value];
	}
	
	public Person(String Name, int Salary) {
		this.Name = Name;
		this.Salary = Salary;
	}
	
	public void addPerson(String Name, int Salary, int position) {
		theList[position - 1] = new Person(Name,Salary);
		System.out.println(Name + " was added successfully!");
	}

	public Person[] getTheList() {
		return this.theList;
	}
}
