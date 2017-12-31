import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
	private static ArrayList<Contacts> newList = new ArrayList<Contacts>();
	//private static Scanner console = new Scanner(System.in);
	private static Scanner console2 = new Scanner(System.in);
	
	public static void main(String[] args) {
		myMenu();
	}
	
	public static void myMenu() {
		System.out.println("Menu activated... \n");
		System.out.println("Press 0 to quit.");
		System.out.println("Press 1 to view contacts.");
		System.out.println("Press 2 to add new contacts.");
		System.out.println("Press 3 to modify contact.");
		System.out.println("Press 4 to remove contact.");
		
		boolean test = true;
		while(test) {
			System.out.println("Enter a navigation choice: ");
			int result = console2.nextInt();
			
			switch(result) {
			case 0: 
				test = false;
				break;
			case 1:
				printContacts();
				break;
			case 2:
				addContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				removeContact();
				break;	
			default:
				test = true;
				break;
			}
		}
	}
	
	public static void addContact() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a new name: ");
		String name = console.nextLine();
		System.out.println("Enter a new number: ");
		int number = console.nextInt();
				
		Contacts newContact = new Contacts(name,number);
		
		boolean issueBar = false;
		
		for(int i = 0; i < newList.size(); i++) {
			if(newContact.getName().equals(newList.get(i).getName()) && newContact.getContactNo() == newList.get(i).getContactNo()) {
				System.out.println("This contact already exists...");
				issueBar = true;
			}
		}
		
		if(issueBar == false) {
			newList.add(newContact);
		}
	}
	
	public static void updateContact() {
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a name to search: ");
		String name1 = console.nextLine();
		for(int i = 0; i < newList.size(); i++) {
			if(newList.get(i).getName().equals(name1)) {
				System.out.println("Enter a new name: ");
				newList.get(i).setName(console.nextLine());
				System.out.println("Enter a new number: ");
				newList.get(i).setContactNo(console.nextInt());
				System.out.println("Contact updated");
			}
		}
	}
	
	public static void removeContact() {
		Scanner console = new Scanner(System.in);
		printContacts();
		System.out.println("Who would you like to remove: ");
		String remove = console.nextLine();
		
		for(int i = 0; i < newList.size(); i++) {
			if(newList.get(i).getName().equals(remove)) {
				newList.remove(i);
				System.out.print(remove + " has been successfully removed from contacts...\n");
			}
		}
	}
	
	public static void printContacts() {
		System.out.println("Your current contacts are: ");
		for(int i = 0; i < newList.size(); i++) {
			System.out.println((i + 1) + ". " + newList.get(i).getName() + " " + newList.get(i).getContactNo());
		}
	}
	
	
}















