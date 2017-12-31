
public class House {
	private Bathroom bathRoom;
	private Livingroom livingRoom;
	private Garage garage;
	private Furniture furniture;
	
	public House(Bathroom bathRoom, Livingroom livingRoom, Garage garage, Furniture furniture) {
		this.bathRoom = bathRoom;
		this.livingRoom = livingRoom;
		this.garage = garage;
		this.furniture = furniture;
	}

	public Bathroom getBathRoom() {
		return bathRoom;
	}

	public Livingroom getLivingRoom() {
		return livingRoom;
	}

	public Garage getGarage() {
		return garage;
	}

	public Furniture getFurniture() {
		return furniture;
	}
	
}
