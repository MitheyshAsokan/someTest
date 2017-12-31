
public class Main {
	public static void main(String[] args) {
		compound(1000, 10, 2);
		System.out.println(compoundVal(1000, 10, 2));
	}
	
	public static void compound(double sum, double rate, int year) {
		double netReturn = sum * (rate / 100);
		System.out.println("O/balance " + sum );
		sum += netReturn;
		System.out.println("C/balance " + sum );
		System.out.println();
		
		if(year > 1) {
			compound(sum, rate, (year - 1));
		}
	}
	
	public static double compoundVal(double sum, double rate, int year) {
		double netReturn = sum * (rate / 100);
		sum += netReturn;
		System.out.println();
		
		if(year > 1) {
			return compoundVal(sum, rate, (year - 1));
		}
		
		return sum;
	}
	
	
}
