
public class Garage {
	private boolean car;
	private boolean tools;
	private boolean storage;
	public String fuel = "Dang ma nigga";
	
	public Garage(boolean car, boolean tools, boolean storage) {
		this.car = car;
		this.tools = tools;
		this.storage = storage;
	}
	
	public boolean getCar() {
		return car;
	}
	public boolean getTools() {
		return tools;
	}
	public boolean getStorage() {
		return storage;
	}
	
	
}
