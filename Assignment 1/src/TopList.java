import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

//Mitheysh Asokan
//Project 1 Part 1
//A class that is intended to hold a list of top salary earners.
//No inputs
//No outputs

public class TopList {
	
	private ArrayList<Person> myList;
	private int listSize = 10;
	private String fileName = "myFile.txt";
	private File theFile = new File(fileName);;
	private PrintWriter theWriter;
	private Scanner theReader;
	public Person[] tempList;

	//This constructor is the default constructor and it will not receive and parameters.
	//Creates an appropriate data structure with the right number of fields.
	public TopList() throws IOException {
		myList = new ArrayList<>();
		
		if(!theFile.exists()) {
			theFile.createNewFile();
			theReader = new Scanner(theFile);
		}
		if(theFile.exists()) {
			theReader = new Scanner(theFile);
			readFromFile();
		}
		
		theWriter = new PrintWriter(theFile);
		writeToFile();
		
	}
	
	//This constructor allows the user to specify
	//the number of entries, by receiving a single Int-parameter.
	//Creates an appropriate data structure with the right number of fields.
	public TopList(int numberOfEntries) throws IOException {
		myList = new ArrayList<>();
		
		if(numberOfEntries <= 0) {
			numberOfEntries = 10;
			System.out.println("Error, your list size is invalid, the list is defaulted to 10.");
		}
		
		listSize = numberOfEntries;
		
		if(!(theFile.exists())) {
			theFile.createNewFile();
			theReader = new Scanner(theFile);
		}
		if(theFile.exists()) {
			theReader = new Scanner(theFile);
			readFromFile();
		}
		
		theWriter = new PrintWriter(theFile);
		writeToFile();
	}
	
	//A non-static function which will allow the user to add 
	//new entries into the data structure.
	
	//A function intended to support the user in adding his/her
	//entries into the TopSalaryList.
	public void addPerson(String name, int Salary) throws IOException {
		Person newGuy = new Person(name, Salary);
		
		int test = 0;
		
		for(int i = 0; i < myList.size(); i++) {
			if(myList.get(i).getName().equals(newGuy.getName()) && myList.get(i).getSalary() == newGuy.getSalary()) {
				test++;
			}
		}
		
		if(test == 0) {
		    myList.add(newGuy);
		}
		
		sortList();
		writeToFile();
	}
	

	//This function is intended to give you access to the person based on his ranking.
	//prints the name and salary of the specified ranking.
	public Person accessTopList(int rankings) {
		int rank = rankings - 1;
		
		if(rankings > listSize || rankings <= 0) {
			System.out.println("You have entered an invalid position");
			return null;
		}else {
			return myList.get(rank);
		}
	}

	//Prints the top n-list and people on to the console
	//in sorted fashion.
	public void printTopList() {
		
		int iterations = 0;
		
		if(myList.size() < listSize) {
			iterations = myList.size();
		}else if(myList.size() >= listSize) {
			iterations = listSize;
		}
		
		for(int i = 0; i < iterations; i++) {
			System.out.print(myList.get(i).getName() + " ");
			System.out.println(myList.get(i).getSalary());
		}
	}
	
	
	//Read preexisting file from first invocation if it exists! 
	//and add it's entries into this structure, without disrupting the sorted structure.
	public void readFromFile() throws IOException {
		while(theReader.hasNext()) {
			String name = theReader.next();
			int salary = Integer.parseInt(theReader.next());
			Person newGuy = new Person(name, salary);	
			myList.add(newGuy);
			sortList();
		}
	}
	
	
	//Write current/collected state into a specified file
	//which can be referred to if needed.
	public void writeToFile() throws IOException {
		theWriter.close();
		theWriter = new PrintWriter(theFile);
		
		int iterations = 0;
		
		if(myList.size() < listSize) {
			iterations = myList.size();
		}else if(myList.size() >= listSize) {
			iterations = listSize;
		}
		
		for(int i = 0; i < iterations; i++) {
			theWriter.print(myList.get(i).getName() + " ");
			theWriter.println(myList.get(i).getSalary());
		}
		theWriter.flush();
	}
	
	//This method will constantly keep watch and make sure the list is sorted.
	//currently the list's data structure is yet to be decided along with the 
	//data type of every individual person, hence the parameters are set to nothing
	//however, when the implementation takes place the sortList will access an appropriate 
	//structure and sort it.
	public void sortList() {
		for(int i = 0; i < myList.size(); i++) {
			for(int n = 0; n < myList.size(); n++) {				
				if(myList.get(i).getSalary() > myList.get(n).getSalary()) {
					Person tempPerson = myList.get(i);
					Person tempPerson2 = myList.get(n);
					myList.set(i, tempPerson2);
					myList.set(n, tempPerson);
				}
			}
		}
		
	}
}















