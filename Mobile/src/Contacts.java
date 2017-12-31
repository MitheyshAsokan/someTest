
public class Contacts {
	private String name;
	private int contactNo;
	
	public Contacts(String name, int contactNo) {
		this.name = name;
		this.contactNo = contactNo;
	}
	
	public String getName() {
		return name;
	}
	public int getContactNo() {
		return contactNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
}
