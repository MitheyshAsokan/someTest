//Mitheysh Asokan
//Assignement 2 Project 1 Part 2
//2017/Sep/27
//No input, No output

//A test class intneded to test the TopList class.

import java.io.FileNotFoundException;
import java.util.Random;

public class TopListTest {
	public static void main(String[] args) throws FileNotFoundException {
		//The main function will launch the testing environment.
			
			//Test Case #1
			
			//Testing the default constructor.
			
			//Create an object of the target class with 0 parameters
			//Test if it builds a structure capable of holding 10 entries.
		    System.out.println();
		    System.out.println("Test Case #1");
		    System.out.println();
			TopList newList1 = new TopList();
			
			//Add 10 entries to the object.
			System.out.println("Added 10 people, while using the default constructor");
			newList1.addPerson("Jeff", 500);
			newList1.addPerson("Jefff", 570);
			newList1.addPerson("Jefgf", 580);
			newList1.addPerson("Jefft", 550);
			newList1.addPerson("Jefrf", 590);
			newList1.addPerson("Jefrf", 5020);
			newList1.addPerson("Jerff", 5046);
			newList1.addPerson("Jerf", 5301);
			newList1.addPerson("Jef", 596);
			newList1.addPerson("Geof", 5071);
			
			
			//Print the contents of the object to see if it is
			//displayed in sorted fashion.
			 
			newList1.printTopList();
			System.out.println();
			
			
			//Add one extra entry with the highest salary entry
			//to test if the object sorts itself and
			//adds the highest Salary earner to the top spot, while
			//removing the lowest earning entry or omitting the addition of 
			//a new entry if their eanrings are not up-to par to the list.

			newList1.addPerson("ADDED", 100000);
			System.out.println("Added a new person with the highes salary");
			newList1.printTopList();
			System.out.println();
			
			//Testing the specific constructor.
			
			//Pass in an Int-value as a parameter to the constructor
			//to test if it creates an appropriate structure to hold 
			//the right amount og people.
			TopList newList1a = new TopList(5);
			
			//Add 5 entries to the object.
			System.out.println("Added 5 people, while using the specific constructor");
			newList1a.addPerson("J1eff", 1700);
			newList1a.addPerson("J2eff", 1050);
			newList1a.addPerson("J3eff", 1090);
			newList1a.addPerson("J4eff", 1060);
			newList1a.addPerson("J5eff", 1020);

			//Print the contents of the object to see if it is
			//displayed in sorted fashion.
			newList1a.printTopList();
			System.out.println();
			
			//Add one extra entry with the highest salary compared to other 
			//entries in the list to test if the object sorts itself and
			//adds the highest Salary earner to the top spot, while
			//removing the lowest earning entry.
			newList1a.addPerson("ADDED2", 9999);
			System.out.println("Added a new person with the highes salary");
			newList1a.printTopList();
			System.out.println();

			//Invalid Entries

			//Pass in 0 or a negative number into the constructor
			//as a parameter and see if it returns an error.
			TopList newList1b = new TopList(0); //Should fail!
			
			
			
			//Test Case #2
			 System.out.println();
			 System.out.println("Test Case #2");
			 System.out.println();
			//Test if the class mirgrates states accurately.
			
			TopList newList2 = new TopList(3);
			
			newList2.addPerson("This", 1562);
			newList2.addPerson("Then", 1234);
			newList2.addPerson("That", 7891);
			
			//Write the current state of the list to a file 
			//specifying the filename.
			
			newList2.writeToFile("newerFile.txt");
			newList2.printTopList();
			System.out.println("Writing to file \"newerFile\"");
			System.out.println();
			
			
			//Check if an object with preexisting entries merges accurately
			//when it reads more data from another file.
			//The print cannot exceed 3 slots in the list, and it should eb sorted.
			TopList newList2b = new TopList(6);
			
			newList2b.addPerson("Sum", 56);
			newList2b.addPerson("Rum", 45);
			newList2b.addPerson("Tum", 25);
			
			newList2b.printTopList();
			System.out.println();
			
			System.out.println("Reading from file \"newerFile\"");
			newList2b.readFromFile("newerFile.txt");
			
			newList2b.printTopList();
			System.out.println();
			
			//Test case #3
			System.out.println();
			System.out.println("Test Case #3");
			System.out.println();
			
			//Test if the user can iterate through the list.
			
			TopList newList3 = new TopList(3);
			
			newList3.addPerson("Mum", 56);
			newList3.addPerson("Rum", 45);
			newList3.addPerson("Tum", 25);
			
			//Access a person within the specified rankings
			System.out.println("We accesed " + newList3.accessPerson(3).getName() + " in position 3");
			System.out.println();
			
			//Access a person out of bounds.
			newList3.accessPerson(4);
			System.out.println();
			
			//Try to print out three entries while iterating thorugh the list.
			for(int i = 1; i < 4; i++) {
				newList3.accessPerson(i);
			}
			
			Person[] theList = newList3.getTopList();
			
			for(int i = 0; i < theList.length; i++) {
				System.out.println(theList[i].getName() + " has a salary of $" + theList[i].getSalary());
			}
			
			//Try to make random changes to the list
			System.out.println();
			System.out.println("adding random values to the list");
			System.out.println();
			
			Random randValue = new Random(10);
			for(int i = 0; i < theList.length; i++) {
				int addToSalary = randValue.nextInt(50);
				theList[i].setSalary(theList[i].getSalary() + addToSalary);
				System.out.println("Added " + addToSalary + " to " + theList[i].getName() + " has a salary of $" + theList[i].getSalary());
			}
			System.out.println();
			
			//Sort the list and print its new state, after the changes were made.
			newList3.sortList();
			for(int i = 0; i < theList.length; i++) {
				System.out.println(theList[i].getName() + " has a salary of $" + theList[i].getSalary());
			}
			
			
	}
}
























