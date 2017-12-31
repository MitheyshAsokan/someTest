//Mitheysh Asokan
//Homework 2 Problem 1

//Changes made according to #3 and #16


public class LinkedIntList {
	private ListNode front;    // first value in the list       
	// post: constructs an empty list
	
	public LinkedIntList() {
		front = null;
	}        
	
	// post: returns the current number of elements in the list
	public int size() {
		int count = 0;    
		ListNode current =  front;
		while (current != null) {   
			current =  current.next; 
			count++;   
		} 
		
		return count;        
	}        
	
	//   pre   : 0 <= index < size()       
	// post: returns the integer at the given index in the list
	public int get(int index) {   
		return nodeAt(index).data;       
	}
	
	
    // post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (front == null) {   
			return "[]"; 
		} else { 
			String result =  "["   +  front.data; 
			ListNode current =  front.next; 
			while (current != null) {
				result +=   ", "    +  current.data;
				current =  current.next; 
			} result +=   "]"; 
			return result; 
		}       
	}
	
    // post : returns the position of the first occurrence of the given       
	//        value (-1 if not found)
	public int indexOf(int value) {   
		int index = 0;    
		ListNode current =  front; 
		
		while (current !=  null) {   
			if (current.data    ==   value) {
				return index; 
			} index++;   
			
			current =  current.next; 
		} 
		
		return -1;         
	}        
	// post: appends the given value to the end of the list
	public void add(int value) {   
		if (front == null) {   
			front = new ListNode(value);  
		} else { 
			ListNode current =  front; 
			while (current.next != null) {   
				current =  current.next   ; 
			} 
		
		current.next = new ListNode(value);  
	   }       
	}
	
	
    //   pre  : 0 <= index <= size()       
	// post: inserts the given value at the given index
	
	public void add(int index, int value) {   
		if (index == 0) {
			front = new ListNode(value,  front);  
		} else { 
			ListNode current = nodeAt(index - 1);
			current.next = new ListNode(value,  current.next   );  
		} 
	}
      
	
    //   pre   : 0 <= index < size()       
	// post: removes value at the given index
	public void remove(int index) {   
		if (index == 0) {
			front =  front.next; 
		} else { 
			ListNode current = nodeAt(index - 1);   
			current.next =  current.next.next; 	
		    }        
		}        
	
	//   pre   : 0 <= i < size()       
	// post: returns a reference to the node at the given index
	
	private ListNode nodeAt(int index) {   
		ListNode current =  front; 
		for (int i = 0; i <  index;  i++) {
			current =  current.next   ; 
		} 
		
		return current;        
	}
	
	
	public boolean isSorted() {
		ListNode runner = front;
		if(runner == null) {
			return true;
		}
		int data = 0;
		while(runner != null) {
			int currentData = runner.data;
			if(currentData < data) {
				return false;
			}
			data = currentData;
			runner = runner.next;
		}
		return true;
	}
	
	public LinkedIntList removeEvens() {
        LinkedIntList list2 = new LinkedIntList();
		
		ListNode runner = front;
		double size = 0;
		
		while(runner != null) {
			size += 1;
			runner = runner.next;
		}
		
		if(size == 0) {
			System.out.println("List empty...");
			return list2;
		}
		
		if(size == 1) {
			list2.front = this.front;
			this.front = this.front.next;
			return list2;
		}
		
		list2.front = this.front;
		ListNode list2R = list2.front;
		
		this.front = this.front.next;
		ListNode listR = this.front;
		
		if(size == 2) {
			list2R.next = listR.next;
			return list2;
		}
		
		double oddEven = size % 2;
		
		double aRuns = 0;
		double bRuns = 0;
		
		if(oddEven != 0) {
			aRuns = (size * 0.5) - 0.5;
		}
		
		if(oddEven == 0) {
			bRuns = 1;
			
			aRuns = (size * 0.5) - 1;
		}
		
		for(double i = 0; i < aRuns; i++) {
			list2R.next = listR.next;
			listR.next = list2R.next.next;
			
			list2R = list2R.next;
			listR = listR.next;
		}
		
		for(double i = 0; i < bRuns; i++) {
			list2R.next = listR.next;
		}
		
		return list2;
	}

}




















