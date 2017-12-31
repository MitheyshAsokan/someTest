import java.util.ArrayList;
import java.util.ListIterator;

public class Mobile {
	private String ownerName;
	private String ownerNumber;
	private String brandName;
	private String modelName;
	private ArrayList<Contact> contacts;
	
	public Mobile(String ownerName, String ownerNumber, String brandName, String modelName) {
		this.ownerName = ownerName;
		this.ownerNumber = ownerNumber;
		this.brandName = brandName;
		this.modelName = modelName;
		this.contacts = new ArrayList<Contact>();
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerNumber() {
		return ownerNumber;
	}

	public void setOwnerNumber(String ownerNumber) {
		this.ownerNumber = ownerNumber;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	
	public void addContact(String name, String number) {
		Contact newPerson = new Contact(name,number);
		contacts.add(newPerson);
		System.out.println("Contact:" + name + " added successfully...");
	}
	
	public void printContacts() {
		ListIterator<Contact> newIter = contacts.listIterator();
		System.out.println();
		System.out.println("Your contacts are as follows: ");
		while(newIter.hasNext()) {
			Contact someContact = newIter.next();
			System.out.println( someContact.name + " " + someContact.number);
		}
	}
	
	private class Contact{
		private String name;
		private String number;
		
		public Contact(String name, String number) {
			this.name = name;
			this.number = number;
		}	
	}
	
	
}





















