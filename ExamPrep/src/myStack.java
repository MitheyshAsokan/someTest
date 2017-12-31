import java.util.ArrayList;

public class myStack <type>{
	private ArrayList<type> theArray;
	
	public myStack() {
		theArray = new ArrayList<type>();
	}
	
	public void push(type value) {
		theArray.add(value);
	}
	
	public type pop() {
		
		if(theArray.size() - 1 < 0) {
			throw new IllegalArgumentException();
		}
		
		type stuff = theArray.get(theArray.size() - 1);
		theArray.remove(theArray.size() - 1);
		return stuff;
	}
}
