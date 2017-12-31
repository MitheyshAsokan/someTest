
public class linkList {
	
	public listNode newNode;
	public int size = 0;
	
	public linkList(int value) {
		
		if(value == 0) {
			throw new IllegalArgumentException();
		}
		
		newNode = new listNode(value);
		countNodes();
	}
	
	public void addNew(int value) {
		
		listNode travel = newNode;
		listNode setNode = new listNode(value);
		
		while(travel.getNext() != null) {
			travel = travel.getNext();
		}
		
		setNode.setPrev(travel);
		travel.setNext(setNode);
		
		countNodes();
	}
	
	
	public void printList() {
		listNode travel = newNode;
		
		while(travel.getNext() != null) {
			System.out.println(travel.getValue());
			travel = travel.getNext();
		}
		
		System.out.println(travel.getValue());
	}
	
	public void countNodes() {
		listNode travel = newNode;
		int count = 1;
		
		while(travel.getNext() != null) {
			count += 1;
			travel = travel.getNext();
		}
		
		this.size = count;
	}
	
	public void replace(int place, int value) {
		countNodes();
		
		if(place > size && place < 1) {
			throw new IllegalArgumentException();
		}
		
		listNode setNode = new listNode(value);
		listNode travel = newNode;
		listNode travel2 = newNode;
		
		if(place == 1) {
			travel = travel.getNext();
			setNode.setNext(travel);
			travel.setPrev(setNode);
			newNode = setNode;
		}
		
		if(place == size) {
			
			for(int i = 1; i < size - 1; i++) {
				travel = travel.getNext();
			}
			
			travel.setNext(setNode);
			setNode.setPrev(travel);
		}
		
		if(place > 1 && place < size) {
			
			for(int i = 1; i < place - 1; i++) {
				travel = travel.getNext();
			}
			
			travel2 = travel.getNext().getNext();
			
			setNode.setNext(travel2);
			setNode.setPrev(travel);
			
			travel.setNext(setNode);
			travel2.setPrev(setNode);
			
		}
	}
	
	public void traverser(int front, int back) {
		
		
		if(front > size || back > size || back > front) {
			throw new IllegalArgumentException();
		}
		
		listNode travel = newNode;
		
		for(int i = 1; i < front; i++) {
			travel = travel.getNext();
		}
		
		for(int i = 1; i < back; i++) {
			travel = travel.getPrev();
		}
		
		System.out.println(travel.getValue());
	}

}






















