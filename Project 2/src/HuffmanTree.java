//Mitheysh Asokan 
//Project 2
//Date : 2017/11/18
//Input : None
//Output : None

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class HuffmanTree {
	//holds the root refence to the huffman tree.
	private HuffmanNode root;
	
	//A constructor that accepts a map of relaated values (Character -> counts)
	public HuffmanTree(Map<Character,Integer> counts) {
		//A priority queue of huffman nodes sorted in terms of occurence.
		PriorityQueue<HuffmanNode> newQue = createPQ(counts);
		setUpTree(newQue);
	}
	
	//Create a priority queue of huffman nodes, using the map recieved from the huffman main
	private PriorityQueue<HuffmanNode> createPQ(Map<Character,Integer> counts) {
		PriorityQueue<HuffmanNode> thePQ = new PriorityQueue<>();
		
		//Using a for loop, extract char and int data from the parameter map
		//and add them to the Priority queue, simultaneously calling the huffmanNode constructor.
		for(Character key: counts.keySet()) {
			thePQ.add(new HuffmanNode(key, counts.get(key)));
		}
		
		return thePQ;
	}
	
	//Using the priority queue by the createPQ method, create a huffman tree within the priroity queue
	//and attach its peek to the root huffman node.
	private void setUpTree(PriorityQueue<HuffmanNode> thePQ) {
		
		//Run while the contents of the PQ is greater than 1
		while(thePQ.size() > 1) {
			//remove the two lowest occurences
			HuffmanNode temp1 = thePQ.remove();
			HuffmanNode temp2 = thePQ.remove();
			
			//create a bigger node, by calling the specific constructor, which sums the two node occurences
			// and reattach it to the PQ
			HuffmanNode temp3 = new HuffmanNode((temp1.occurence + temp2.occurence), temp1, temp2);
			thePQ.add(temp3);
		}
		
		//make the root huffman node point at the only node in the PQ
		this.root = thePQ.peek();
	}
	
	//Creates a map with values of characters corresponding to their binary form
	public Map<Character, String> createEncodings(){
        Map<Character, String> encodedMap = new TreeMap<>();
        String tracker = "";
		
		createEncodedMap(root, tracker, encodedMap);
		
		return encodedMap; 
	}
	
	//A recursive function that traverses each root of the huffman tree until it finds the last node 
	//which is designed to house a specific charater.
	//Each each movement deep within the tree will concatinate the tracker string variable with a 0 or 1
	//producing the binary correspondent to the specific character.
	private void createEncodedMap(HuffmanNode root, String tracker ,Map<Character, String> encodedMap){
		if(root.charater == '\u0000') {
			createEncodedMap(root.right, tracker + "1" ,encodedMap);
			createEncodedMap(root.left, tracker + "0" ,encodedMap);
		}
		
		//once you are at the end of a root, add the specific charater and its binary correspondent (tracker)
		//to the new map
		encodedMap.put(root.charater, tracker);
	}
	
	//Read individual bytes from a file and cast them to char,
	//Utilize the encoded map you created to identify the particular characters huffman binary form
	//using the character as a key
	//Once you find the binary form, write it to the BitOutputStream.
	public void compress(InputStream input, BitOutputStream output) throws IOException {
		 Map<Character, String> encodedMap = createEncodings();
		 boolean test = true;
		 
		 while(test) {
			 int data = input.read();
			 if(data == -1) {
				 test = false;
			 }
			 
			 if(data != -1) {
				 char key = (char) data;
				 String bits = encodedMap.get(key);
				 output.writeBits(bits);
			 }
		 }
		 
		 output.close();
		 input.close();
	}
	
	//Using the BitInputStream, read individual bits (0,1) and traverse the root node, until you find the particular 
	//charater at the end of a particular root.
	public void decompress(BitInputStream input, OutputStream output) throws IOException{
		HuffmanNode travel = root;
		//A supporting method that keeps track of the root node and the traversing node
		decompress(output, input, root, travel);
	}
	
	public void decompress(OutputStream output, BitInputStream input, HuffmanNode root, HuffmanNode travel) throws IOException {
		//run past individial bit
		while(input.hasNextBit()) {
			int data = input.readBit();
			//If the current node is a defaulting char value, it means that it is not at the end of the root.
			//so keeping moving deeper into the root.
			if(travel.charater != '\u0000') {
				//when you reach the end, cast the char into an int
				//and pass the byte onto the outputstream
				output.write((int)travel.charater);
				//Once you are done traverse back to the top of the root
				travel = root;
			}
			
			if(data == 0) {
				travel = travel.left;
			}
			
			if(data == 1) {
				travel = travel.right;
			}
		}
		
		input.close();
		output.close();
	}
	
}



















