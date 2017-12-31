//Mitheysh Asokan
//Assignement 2 Project 1 Part 2
//2017/Sep/27
//No input, No output

//A class to relate the persons name and salary.


public class Person {
	private String name;
	private int salary;
			
	public Person(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
