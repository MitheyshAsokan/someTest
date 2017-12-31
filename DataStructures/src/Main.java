import java.util.Scanner;

public class Main {
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] myNewArr = getIntegers();
		printArray(myNewArr);
		int[] resizedArr = resizeArray(myNewArr);
		System.out.println();
		printArray(resizedArr);
	}
	
	public static int[] getIntegers() {
		System.out.println("getIntegers activated... ");
		System.out.println("How many integers would you like to include.");
		
		int length = console.nextInt();
		
		System.out.println("Please enter " + length + " values, followed by an enter.");
		
		int[] newArray = new int[length];
		for(int i = 0; i < length; i++) {
			newArray[i] = console.nextInt();
		}
		
		return newArray;
	}
	
	public static void printArray(int[] Array) {
		System.out.println("printArray activated... ");
		for(int i = 0; i < Array.length; i++) {
			System.out.println("Entry " + i + " is " + Array[i]);
		}
	}
	
	public static int[] sortArray(int[] Array) {
		System.out.println("sortArray activated... ");
		for(int i = 0; i < Array.length; i++) {
			for(int m = 0; m < Array.length; m++) {
				if(Array[i] > Array[m]) {
					int temp = Array[i];
					Array[i] = Array[m];
					Array[m] = temp;
				}
			}
		}
		
		return Array;
	}
	
	public static int[] resizeArray(int[] Array) {
		
		System.out.println("What would you like the new size to be? ");
		int newSize = console.nextInt();
		
		System.out.println("resizeArray activated... ");
		if(Array.length > newSize) {
			int[] tempArray = Array;
			Array = new int[newSize];
			
			for(int i = 0; i < newSize; i++) {
				Array[i] = tempArray[i];
			}
			
			return Array;
		}
		
		if(Array.length < newSize) {
			int tempDiff = newSize - Array.length;
			System.out.println("You'll need to add " + tempDiff + " values");
			
			int[] tempArray = Array;
			Array = new int[newSize];
			
			for(int i = 0; i < tempArray.length; i++) {
				Array[i] = tempArray[i];
				
				System.out.println("New Array position: " + i + " is " + Array[i]);
			}
			
			System.out.println("Time to add in new values: ");
			for(int i = 0; i < tempDiff; i++) {
				Array[(tempArray.length) + i] = console.nextInt();
			}
			
			return Array;
		}

		return Array;
	}
	
	
}


















