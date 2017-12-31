import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException{
		
		TopList theList = new TopList(4);
		
		theList.addPerson("Ren", 100);
		theList.addPerson("Sten", 119);
		theList.addPerson("ken", 170);
		theList.addPerson("Jen", 180);
		theList.addPerson("Men", 190);
		theList.addPerson("Ten", 171);

		theList.printTopList();
		System.out.println();
		
		System.out.println(theList.accessTopList(2).getName());
		theList.accessTopList(3).setName("Rem");
		
		theList.printTopList();
		System.out.println();
	}
}
