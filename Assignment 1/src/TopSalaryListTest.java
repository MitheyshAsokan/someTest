import java.io.IOException;

//Mitheysh Asokan
//Project 1 Part 1
//A test class that is intended to utilize a class that holds a 
//list of top salary earners, and test its inner workings.
//Inputs: Various test cases.
//Outputs: Validation in test cases (Success or failure.)

public class TopSalaryListTest {
	//The main function will launch the testing environment.
	public static void main(String[] args) throws IOException {
		/*
		//Test Case #1
		
		//Testing the default constructor.
		
		//Create an object of the target class with 0 parameters
		//Test if it builds a structure capable of holding 10 entries.
		TopSalaryList newList1 = new TopSalaryList();
		
		//Add 10 entries to the object.
		newList1.addPerson("Ren", 100);
		newList1.addPerson("Sten", 119);
		newList1.addPerson("ken", 170);
		newList1.addPerson("Jen", 180);
		newList1.addPerson("Men", 190);
		newList1.addPerson("Stun", 171);
		
		//Print the contents of the object to see if it is
		//displayed in sorted fashion.
		newList1.printTopList();
		System.out.println();
		
		//Add one extra entry with the highest salary entry
		//to test if the object sorts itself and
		//adds the highest Salary earner to the top spot, while
		//removing the lowest earning entry or omitting the addition of 
		//a new entry if their eanrings are not up-to par to the list.
		
		newList1.addPerson("John", 5000);
		newList1.printTopList();
		System.out.println();
		
		
		
		
		//Testing the specific constructor.
		
		//Pass in an Int-value as a parameter to the constructor
		//to test if it creates an appropriate structure to hold 
		//the right amount og people.
		TopSalaryList newList1a = new TopSalaryList(20);
		
		//Add 5 entries to the object.
		newList1a.addPerson("Jason", 156);
		newList1a.addPerson("Jan", 656);
		newList1a.addPerson("Jas", 354);
		newList1a.addPerson("Jaso", 766);
		newList1a.addPerson("Jao", 9367);
		
		//Print the contents of the object to see if it is
		//displayed in sorted fashion.
		newList1a.printTopList();
		System.out.println();
		
		//Add one extra entry with the highest salary compared to other 
		//entries in the list to test if the object sorts itself and
		//adds the highest Salary earner to the top spot, while
		//removing the lowest earning entry.
		newList1a.addPerson("Jason", 10000);
		newList1a.printTopList();
		System.out.println();
		
		
		

		//Invalid Entries
		
		//Pass in 0 or a negative number into the constructor
		//as a parameter and see if it returns an error.
		//TopSalaryList newList1b = new TopSalaryList(0); //Should fail!
		
		//Test Case #2
		
		//Test if the class mirgrates states accurately.
		
		TopSalaryList newList2 = new TopSalaryList(5);
		
		newList2.addPerson("Jason", 156);
		newList2.addPerson("Jan", 656);
		newList2.addPerson("Jas", 354);
		newList2.addPerson("Jaso", 766);
		newList2.addPerson("Jao", 9367);
		
		//Write the current state of the list to a file 
		//specifying the filename.
		newList2.printTopList();
		System.out.println();
		
		TopSalaryList newList2a = new TopSalaryList(5);
		
		//Read the state of a previous file and try to merge the state with the 
		//new object.
		newList2a.printTopList();
		System.out.println();
		
		//Check if an object with preexisting entries merges accurately
		//when it reads more data from another file.
		//The print cannot exceed 3 slots in the list, and it should eb sorted.
		TopSalaryList newList2b = new TopSalaryList(6);
		
		newList2b.addPerson("Sten", 9999999);
		newList2b.addPerson("ken", 99999);
		newList2b.addPerson("Jen", 999999);

		newList2b.printTopList();
		System.out.println();
		
		*/
		
		//Test case #3
		
		//Test if the user can iterate through the list.
		
		TopList newList3 = new TopList(3);
		
		newList3.addPerson("Jani", 123);
		newList3.addPerson("Janu", 236);
		newList3.addPerson("Janf", 354);
		newList3.addPerson("Jand", 7789);
		newList3.addPerson("Jans", 654);
		newList3.addPerson("Jane", 455);
		
		newList3.printTopList();
		System.out.println();
		
		//Access a person within the specified rankings
		newList3.accessTopList(2);
		System.out.println();
		
		//Access a person out of bounds.
		newList3.accessTopList(4);
		System.out.println();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
