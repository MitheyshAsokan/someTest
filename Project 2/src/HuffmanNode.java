//Mitheysh Asokan 
//Project 2
//Date : 2017/11/18
//Input : None
//Output : None

//A class that holds individuals nodes of characters and their corresponding counts.
public class HuffmanNode implements Comparable<HuffmanNode>{
	public char charater;
	public int occurence;
	public HuffmanNode right;
	public HuffmanNode left;
	
	//A constrcutor to create nodes with no references to other nodes
	public HuffmanNode(char Character, int Occurence) {
		this.charater = Character;
		this.occurence = Occurence;
		
		this.right = null;
		this.left = null;
	}
	
	//A constructor that adds the occurences between two huffman nodes and
	//creates a new node with an occurence of their sum.
	//The new node had a left, right references to the initial nodes.
	//Supportes the create of the huffman tree, within the priority queue.
	public HuffmanNode(int sum, HuffmanNode left, HuffmanNode right) {
		this.occurence = sum;
		this.left = left;
		this.right = right;
	}
	
	//The comparable implementation facilitates the comparison of two objects
	//the compareTo function specifies what field to compare to when two objects are 
	//compared. 
	
	//It is useful in facilitating a priority queue in sorting the huffman nodes.
	@Override
	public int compareTo(HuffmanNode temp1) {
		if(this.occurence > temp1.occurence) {
			return 1;
		}else if (this.occurence == temp1.occurence) {
			return 0;
		}
		
		return -1;
	}
}
