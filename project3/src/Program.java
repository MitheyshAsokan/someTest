//Mitheysh Asokan
//Project 3
//Input: NON
//Output: The total word count, the time each implementation takes, the count on the uniques wordds counted, 
//and the top 20 most occuring words.

//Program that counts an arraylist of strings and creates a 3 differnt dictionaries
//implementing 3 different data structures.


import java.io.File;
import java.io.FilenameFilter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {
        try {
            // TODO: Copy and paste your directory here. Your directory should
            // ONLY contain the books! D:/JavaPro/project3/p3-books
            String directoryContainingBooks = "D:/JavaPro/project3/p3-books";

            File dirInfo = new File(directoryContainingBooks);
            if (!dirInfo.exists()) {
                throw new Exception("Directory " + directoryContainingBooks + " does not exist.");
            }

            // We are going to read all of the words in and store them in a list
            // to make the rest of your project easier for you. This is NOT the
            // way one would normally operate. There is no reason to store
            // all of the data in RAM. We only need to read words from the file,
            // count them, and then move on to the rest of the file.
            ArrayList<String> words = new ArrayList<>();
            words.ensureCapacity(4500000); // pre-allocate needed space
            FilenameFilter filter = new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.toLowerCase().endsWith(".txt");
                }
            };

            for (File file : dirInfo.listFiles(filter)) {
                byte[] bytes = Files.readAllBytes(file.toPath());
                tokenize(new String(bytes, StandardCharsets.UTF_8), words);
            }

            System.out.println("Finished reading " + words.size() + " words.");

            // ************************ IMPORTANT
            // ***************************************
            //
            // NOTE: You may NOT change the words list! Do NOT change the words
            // list!
            // You are to only read the words from index 0 to index
            // words.Count-1.
            // Do NOT sort the list of words or change it in any way.
            //
            // **************************************************************************

            // ------------------------------------------------------------
            //
            // TODO: Add your code here to count the words, etc. You
            // will do best to create many methods to organize
            // your work and experiments.
            //
            
            //Dictionary1 implements the Arraylist<WordCount>
            
            ArrayList<WordCount> Dictionary1 = new ArrayList<>();
            Map<String, Integer> Dictionary2 = new TreeMap<>();
            Map<String, Integer> Dictionary3 = new HashMap<>();
            
            //Implementations are commented to stop overlap! 
            //Uncomment when use.
            
            
            implementation1(words, Dictionary1);
            //implementation2(words, Dictionary2);
            //implementation3(words, Dictionary3);

            // ------------------------------------------------------------
        } catch (Exception ex) {
            System.err.println("Caught unhandled exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // This function takes a string and breaks it up into "words" and
    // adds them to the given list.
    //
    // Based on SimpleTokenizer by Trevor Strohman,
    // http://www.lemurproject.org/galago.php
    static public void tokenize(String text, ArrayList<String> words) {
        text = text.toLowerCase();

        int start = 0;

        int i;
        for (i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (!Character.isLetter(c)) {
                if (start != i) {
                    String token = text.substring(start, i);
                    words.add(token);
                }
                start = i + 1;
            }
        }

        if (start != i) {
            words.add(text.substring(start, i));
        }
    }
    
    
    public static void implementation1(ArrayList<String> words, ArrayList<WordCount> Dictionary1) {
    	Stopwatch newWatch = new Stopwatch();
    	//setup a boolean flag
		boolean test = false;
    	newWatch.start();
    	//Iterate through the entire list of words
    	for(String e : words) { 
    		//If the dictionary is not empty compare the word of focus to the words in the Arraylist
        	if(!(Dictionary1.isEmpty())) {
        		//iterate through the words in the dictionary
        		for(WordCount wrdCnt : Dictionary1) {
        			//If the either of the word is a match
        			if(wrdCnt.word.equals(e)) {
        				//Alert the flag and add one to the count
        				test = true;
        				wrdCnt.addOne();
        				//Stop looping through the dictionary if a match was found!
        				break;
        			}
        		}
        		//If the flag was not alerted, add the word to the list
        		if(test == false) {
        			Dictionary1.add(new WordCount(e));
        		}
        		//Reinstate the flag
        		test = false;
        	}
        	//If the dictionary is empty, add the first word to it.
        	if(Dictionary1.isEmpty()) {
        		Dictionary1.add(new WordCount(e));
        	}
        }
    	newWatch.stop();
        //Sort the list
        Collections.sort(Dictionary1);
        System.out.printf("To count the words with an ArrayList took %.3f seconds.", newWatch.getElapsedSeconds());
        System.out.println();
        System.out.println("Found " + Dictionary1.size() + " unique words");
        System.out.println("The 20 most frequent words and their counts are:");
        
        //Print the first 20 words in the dictionary
        for(int i = 0; i < 20; i++) {
        	System.out.println(Dictionary1.get(i).word + " " + Dictionary1.get(i).count);
        }
    }
    
    public static void implementation2(ArrayList<String> words, Map<String, Integer> Dictionary2) {
    	PriorityQueue<WordCount> newPQ = new PriorityQueue<>();
    	Stopwatch newWatch = new Stopwatch();
        
    	newWatch.start();
    	//Iterate through the list of words in the pile
        for(String e : words) {
        	//If the dictionary has the word in it increment the count
			if(Dictionary2.containsKey(e)) {
				//the smart way to increment the count it to remove the old pair and reinsert with a new pair, +1 to count
				int value = Dictionary2.get(e);
				Dictionary2.remove(e);
				Dictionary2.put(e, value + 1);
			}
			//If the word is not in the map, add it as a new word with a count of 1
			if(!(Dictionary2.containsKey(e))) {
				Dictionary2.put(e, 1);
			}
		}
        newWatch.stop();
        
        System.out.printf("To count the words with a TreeMap took %.3f seconds.", newWatch.getElapsedSeconds());
        System.out.println();
        System.out.println("Found " + Dictionary2.size() + " unique words");
        System.out.println("The 20 most frequent words and their counts are:");
        
        //Pass the entire dictionary to a Priorirty queue
        for(String key : Dictionary2.keySet()) {
        	newPQ.add(new WordCount(key, Dictionary2.get(key)));
        }
        
        //Print the top 20 words in the prioirty queue's head.
        for(int i = 0; i < 20; i++) {
        	WordCount newWord = newPQ.remove();
        	System.out.println(newWord.word + " " + newWord.count);
        }
    }
    
    public static void implementation3(ArrayList<String> words, Map<String, Integer> Dictionary3) {
    	PriorityQueue<WordCount> newPQ2 = new PriorityQueue<>();
    	Stopwatch newWatch = new Stopwatch();
    	
    	newWatch.start();
    	//Iterate through the list of words in the pile
        for(String e : words) {
        	//If the dictionary has the word in it increment the count
			if(Dictionary3.containsKey(e)) {				
				//the smart way to increment the count it to remove the old pair and reinsert with a new pair, +1 to count
				int value = Dictionary3.get(e);
				Dictionary3.remove(e);
				Dictionary3.put(e, value + 1);
			}
			//If the word is not in the map, add it as a new word with a count of 1
			if(!(Dictionary3.containsKey(e))) {
				Dictionary3.put(e, 1);
			}
		}
        newWatch.stop();
        
        
        System.out.printf("To count the words with an HashMap took %.3f seconds.", newWatch.getElapsedSeconds());
        System.out.println();
        System.out.println("Found " + Dictionary3.size() + " unique words");
        System.out.println("The 20 most frequent words and their counts are:");
        
        //Pass the entire dictionary to a Priorirty queue
        for(String key : Dictionary3.keySet()) {
        	newPQ2.add(new WordCount(key, Dictionary3.get(key)));
        }
        
        
        //Print the top 20 words in the prioirty queue's head.
        for(int i = 0; i < 20; i++) {
        	WordCount newWord = newPQ2.remove();
        	System.out.println(newWord.word + " " + newWord.count);
        }
    }
    
    
    
}
