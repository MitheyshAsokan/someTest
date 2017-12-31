//Mitheysh Asokan 	
//Homework 1
//2017/Oct/1

//No inputs or outputs

//This class privides the user a set of methods to work with ArrayLists.


import java.util.ArrayList;

public class ArrayListImplementation {
	
	public static ArrayList<String> doubleList(ArrayList<String> theList){
		ArrayList<String> targetList = new ArrayList<>();
		
		for(int i = 0; i < theList.size(); i++) {
			targetList.add(theList.get(i));
			targetList.add(theList.get(i));
		}
		
		return targetList;
	}
	
	public static ArrayList<Integer> removeZeroes(ArrayList<Integer> theList){
		
		ArrayList<Integer> targetList = new ArrayList<>();
		
		for(int i = 0; i < theList.size(); i++) {
			if(theList.get(i).intValue() != 0) {
				targetList.add((theList.get(i)));
			}
		}
		
		return targetList;
	}
	
    public static ArrayList<Integer> filterRange(ArrayList<Integer> theList, int min, int max){
		
		ArrayList<Integer> targetList = new ArrayList<>();
		
		if(max < min) {
			int temp = max;
			max = min;
			min = temp;
		}
		
		for(int i = 0; i < theList.size(); i++) {
			
			if(!(theList.get(i).intValue() <= max && theList.get(i).intValue() >= min)) {
				targetList.add((theList.get(i)));
			}
		}
		
		return targetList;
	}
	
	public static ArrayList<String> clump(ArrayList<String> theList){
		ArrayList<String> targetList = new ArrayList<>();

		for(int i = 0; i < ((theList.size()) / 2) ; i++) {
			targetList.add(theList.get(i * 2) + " " + theList.get((i * 2) + 1));
		}
		
		if((theList.size() % 2) != 0) {
			targetList.add(theList.get(theList.size() - 1));
		}
		
		return targetList;
	}
}
