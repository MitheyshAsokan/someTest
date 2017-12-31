
public class listNode {
	private int value = 0;
	private listNode next = null;
	private listNode prev = null;
	
	public listNode(int value) {
		this.value = value;
	}

	public listNode getNext() {
		return next;
	}

	public listNode getPrev() {
		return prev;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setNext(listNode next) {
		this.next = next;
	}

	public void setPrev(listNode prev) {
		this.prev = prev;
	}
}
