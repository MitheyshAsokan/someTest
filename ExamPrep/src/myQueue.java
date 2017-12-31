import java.util.ArrayList;

public class myQueue <type>{
    private ArrayList<type> theArray;
	
	public myQueue() {
		theArray = new ArrayList<type>();
	}
	
	public void push(type value) {
		theArray.add(value);
	}
	
	public type pop() {
		
		if(theArray.size() == 0) {
			throw new IllegalArgumentException();
		}
		
		type stuff = theArray.get(0);
		theArray.remove(0);
		return stuff;
	}
}
