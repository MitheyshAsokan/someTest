
public class Main {
	public static void main(String[] args) {
		Car fiat = new Car();
		fiat.setModel("Soprano");
		System.out.println(fiat.getModel());
		
		Bank newAcc = new Bank();
		newAcc.setHolderName("Jeff");
		newAcc.setInitialBalance(1000);
		
		newAcc.deposit(500);
		newAcc.withdraw(300);
		
		System.out.println(newAcc.getInitialBalance());
		
		Bank newerAcc = new Bank(5000,"Ronny");
	}
}
