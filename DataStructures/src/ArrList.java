import java.util.ArrayList;
import java.util.Scanner;


public class ArrList {
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayList<String> newList = new ArrayList<String>();
		printArrList(addSimul(newList));
	}
	
	
	public static void printArrList(ArrayList<String> someList) {
		for(int i = 0; i < someList.size(); i++) {
			System.out.println(someList.get(i));
		}
	}
	
	public static ArrayList<String> addSimul(ArrayList<String> someList){
		
		boolean temp = true;
		
		while(temp) {
			System.out.println("Enter a new item: ");
			someList.add(console.next());
			
			System.out.println("Are you done? (Press 1 for yes)");
			if (console.nextInt() == 1) {
				temp = false;
			}
		}

		return someList;
	}
}
