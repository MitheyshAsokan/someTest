import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		
		myList.add("Jeff");
		myList.add("John");
		myList.add("Jerry");
		myList.add("James");
		myList.add("Jacob");
		myList.add("Jesse");
		
		ListIterator<String> iter = myList.listIterator();
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println(iter.previous());
		System.out.println(iter.previous());
	}
}

