import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedLis {
	public static void main(String[] args) {
		
		LinkedList<String> myLinked = new LinkedList<String>();
		
		alphaSort(myLinked,"this");
		alphaSort(myLinked,"bitch");
		alphaSort(myLinked,"alpha");
		alphaSort(myLinked,"xylo");
		alphaSort(myLinked,"uvula");
		
		ListIterator<String> iter = myLinked.listIterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
	
	public static boolean alphaSort(LinkedList<String> theList, String word) {
		System.out.println(word + " has been entered to the list");
		
		ListIterator<String> iter = theList.listIterator();
		
		while(iter.hasNext()) {
			String value = iter.next();
			System.out.println(value + " is the current word.");
			
			if(value.compareTo(word) == 0) {
				System.out.println("This word already exists in the database.");
				
				System.out.println();
				return false;
			}
			
			if(value.compareTo(word) > 0) {
				System.out.println(word + " is alphabetically superior to " + value);
				iter.previous();
				iter.add(word);
				
				System.out.println();
				return true;
			}
		}
		
		System.out.println();
		iter.add(word);
		return true;
	}
}
