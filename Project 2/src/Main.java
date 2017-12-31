import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		Map<Character, Integer> newMap = new TreeMap<>();
		
		newMap.put('a', 2);
		newMap.put('b', 3);
		newMap.put('c', 3);
		newMap.put('d', 1);
		newMap.put('e', 1);
		
		HuffmanTree newTree = new HuffmanTree(newMap);
		
		//System.out.println(newTree.root.left.left.left.occurence);
		
		Map<Character, String> encodedMap = newTree.createEncodings();
		
		for(Character key : encodedMap.keySet()) {
			System.out.println(key + " " + encodedMap.get(key));
		}	
		
		
		InputStream newInput = new FileInputStream("example.txt");
		
	}

}









