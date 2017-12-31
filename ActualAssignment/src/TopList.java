//Mitheysh Asokan
//Assignement 2 Project 1 Part 2
//2017/Sep/27
//No input, No output

//A list class intended to hold a number of people, with ther names and salaries.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TopList {
	
	public Person[] myList;

	//This constructor is the default constructor and it will not receive and parameters.
	//Creates an appropriate data structure with the right number of fields.
	public TopList() {
		myList = new Person[10];
	}
	
	//This constructor allows the user to specify
	//the number of entries, by receiving a single Int-parameter.
	//Creates an appropriate data structure with the right number of fields.
	public TopList(int numberOfEntries) {
		
		if(numberOfEntries > 0) {
			myList = new Person[numberOfEntries];
		} else {
			System.out.println();
			System.out.println("Invalid entry");
			System.out.println();
		}
	}
	
	//A non-static function which will allow the user to add 
	//new entries into the data structure.
	
	//A function intended to support the user in adding his/her
	//entries into the TopSalaryList.
	public void addPerson(String name, int salary) {
		Person newGuy = new Person(name, salary);
		
		int nullSpots = 0;
		
		for(int i = 0; i < myList.length; i++) {
			if(myList[i] == null) {
				nullSpots += 1;
			}
		}
		
		int filledSpots = myList.length - nullSpots;
		int iterations = filledSpots + 1;
		
		if(filledSpots == myList.length) {
			iterations = myList.length;
		}

		
		for(int i = 0; i < iterations; i++) {
			if(myList[i] == null) {
				myList[i] = newGuy;
			}
			if(myList[i].getSalary() < newGuy.getSalary()) {
				Person tempGuy = myList[i];
				myList[i] = newGuy;
				newGuy = tempGuy;
			}
			if(myList[i].getName().equals(newGuy.getName()) && myList[i].getSalary() == newGuy.getSalary()) {
				break;
			}
		}
	}
	
	//This function is intended to give the user access to the list.
	public Person[] getTopList() {
		return myList;
	}
	
	//This function is intended to give the user access to individual entires within the list.
	public Person accessPerson(int ranking) {
		if(ranking > 0 && ranking <= myList.length) {
			Person theGuy = myList[ranking - 1];
			return theGuy;
		}else {
			System.out.println("Out of bounds...");
			return null;
		}
	}
	
	
	//Prints the top n-list and people on to the console
	//in sorted fashion.
	public void printTopList() {
		for(int i = 0; i < myList.length; i++) {
			if(myList[i] != null) {
				System.out.println(myList[i].getName() + " " + myList[i].getSalary());
			}
			if(myList[i] == null) {
				System.out.println("Empty Slot");
			}
			
		}
	}
	
	
	//Read preexisting file from first invocation if it exists! 
	//and add it's entries into this structure, without disrupting the sorted structure.
	public void readFromFile(String fileName) throws FileNotFoundException {
		File newFile = new File(fileName);
		Scanner theInput;
		
		if(newFile.exists()) {
			theInput = new Scanner(newFile);
			while(theInput.hasNext()) {
				String name = theInput.next();
				int salary = Integer.parseInt(theInput.next());
				addPerson(name, salary);
			}
		}
	}
	
	
	//Write current/collected state into a specified file
	//which can be referred to if needed.
	public void writeToFile(String fileName) throws FileNotFoundException {
		File newFile = new File(fileName);
		PrintWriter theWriter = new PrintWriter(newFile);
		
		for(int i = 0; i < myList.length; i++) {
			if(myList[i] != null) {
				theWriter.print(myList[i].getName() + " ");
				theWriter.println(myList[i].getSalary());
				theWriter.flush();
			}
		}
	}

	//A sort function for the user, if he/she makes changes to the structures 
	//using the getTopList or getPerson functions.
	public void sortList() {
		System.out.println();
		System.out.println("User-Sort called");
		System.out.println();
		for(int i = 0; i < myList.length; i++) {
			for(int m = 0; m < myList.length; m++) {
				if(myList[i].getSalary() > myList[m].getSalary()) {
					Person tempGuy = myList[i];
					myList[i] = myList[m];
					myList[m] = tempGuy;
				}
			}
		}
	}
}




