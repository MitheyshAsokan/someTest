
public class testAnalysis {
	public static void main(String[] args) {
		
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			
			System.out.println(sum);
			
			for(int j = 1; j <= i; j += 2) {
				sum += 1;
				
			}
		}
		
		System.out.println(sum);
	}
}
