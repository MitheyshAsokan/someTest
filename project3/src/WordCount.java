//Mitheysh Asokan
//Project 3
//Input: NON
//Output: NON

//A class that relates the word and the count of all its occurences
//Implements comparable to let the objects of the class be compared in terms of the count.


public class WordCount implements Comparable<WordCount>{
    public String word;
    public int count;
    
    //Quick constructor, when a word is introduced
    public WordCount(String word) {
    	this.word = word;
    	this.count = 1;
    }
    
    //A contructor to help migrate data from the dictionaries to the priority queue
    public WordCount(String word, int count) {
    	this.word = word;
    	this.count = count;
    }
    
    //Quick method to increment the count one by one
    public void addOne() {
    	this.count += 1;
    }
    
    //Setting up comparable, to be able to compare two WordCount objects based on their count integer values.
	@Override
	public int compareTo(WordCount o) {
		if(this.count < o.count) {
			return 1;
		}else if(this.count == o.count) {
			//If the counts are the same, order them by comparing the strings
			return (this.word.compareTo(o.word));
		}
		
		return -1;
	}
}
