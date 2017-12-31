
public class Main {
	public static void main(String[] args) {
		linkList newList = new linkList(5);
		newList.addNew(10);
		newList.addNew(11);
		newList.addNew(12);
		newList.addNew(1);

		newList.printList();
		newList.traverser(4, 3);
	}
}
