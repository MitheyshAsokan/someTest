import java.util.ArrayList;

public class aList {
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<>();
		
		myList.add(5);
		myList.add(5);
		myList.add(5);
		myList.add(5);
		myList.add(5);
		myList.add(5);
		
		myList.add(1, 4);
		
		for (Integer integer : myList) {
			System.out.println(integer);
		}
	}
}
