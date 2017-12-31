import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] argument) {
		
		int[] myArray = {1,2,3,4};
		
		List<String> myList = new LinkedList<String>();
		myList.add("Shit1");
		myList.add("Shit2");
		myList.add("Shit3");
		myList.add("Shit4");
		myList.add("Shit5");
		myList.add("Shit6");
		
		
		for(String num : myList) {
			System.out.println(num);
		}
	}
}
