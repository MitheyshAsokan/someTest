import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		PriorityQueue<Integer> newStuff = new PriorityQueue<>();
		newStuff.add(5);
		newStuff.add(2);
		newStuff.add(1);
		newStuff.add(3);
		newStuff.add(4);
		newStuff.add(2);
		
		for(int i = 0; i < 6; i++) {
			System.out.println(newStuff.remove());
		}
		
	}
}
