package vehicles;

public class Motorbike extends FueledVehicle {

	private static String id = "Motorbike";
	private static int carQuantity = 0;

	// declare instance variables 
	
	public Motorbike(String brandAndModel, double vehiclePrice, double tank, double fuel, double ratio) {
		super(brandAndModel, vehiclePrice, tank, fuel, ratio);
		carQuantity += 1;
	}

	public static int getMotorbikeQuantity() {
		return carQuantity;
	}

	// declare instance variables 
	
	
	// constructor
		// initialization 
			
		// increments car quantity
	
	
	//??
	//public ?? toString()
	

}
