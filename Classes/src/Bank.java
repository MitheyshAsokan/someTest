
public class Bank {
	private int balance;
	private String holderName;
	private String password;
	
	public Bank() {
		this(0,"Unknown","Not Set");
		System.out.println("This is empty");
	}
	
	public Bank(String password) {
		this(0,"Unknown");
		System.out.println("This is empty");
	}
	
	public Bank(int balance, String name) {
		System.out.println("new constructor");
		this.balance = balance;
		this.holderName = name;
	}
	
	public Bank(int balance, String name, String password) {
		System.out.println("new constructor");
		this.balance = balance;
		this.holderName = name;
		this.password = password;
	}
	
	public void setHolderName(String name) {
		this.holderName = name;
	}
	
	public String getHolderName() {
		return this.holderName;
	}
	
	public void setInitialBalance(int balance) {
		this.balance = balance;
	}
	
	public int getInitialBalance() {
		return this.balance;
	}
	
	public void deposit(int value) {
		this.balance += value;
	}
	
	public void withdraw(int value) {
		this.balance -= value;
	}
	
	
	
}
