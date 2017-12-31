//Mitheysh Asokan
//2014/Oct/31
//Inputs: None
//Outputs: None

//Problems solving using recursions.


public class homework4 {
	public static void writeSequence(int value) {
		
		int print = (value + 1) / 2; 
		
		if(value < 1) {
		   throw new IllegalArgumentException();
		} else if(value == 1) {
			System.out.print("1");
		} else if(value == 2) {
			System.out.print("11");
		} else {
			System.out.print(print);
			writeSequence(value - 2);
			System.out.print(print);
		}	
	}
	
	public static int multiplyEvens(int value) {
		if(value < 1) {
		    throw new IllegalArgumentException();
		}else if (value == 1) {
			return 2;
		}
		return (value * 2) * multiplyEvens(value - 1);
	}
	
	public static int permut(int n, int r) {
		if (n < r) {
			throw new IllegalArgumentException();
		}
		if (r == 0) {
			return 1;
		}
		return n * permut((n - 1), (r - 1));
	}
}











