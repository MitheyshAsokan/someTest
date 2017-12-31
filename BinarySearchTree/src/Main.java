
public class Main {
	public static void main(String[] args) {
		SearchTree newTree = new SearchTree(9);

		newTree.addItem(1);
		newTree.addItem(9);
		newTree.addItem(8);
		newTree.addItem(6);
		newTree.addItem(8);
		
		newTree.printTree();
		
		if(newTree.contains(45)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
}
