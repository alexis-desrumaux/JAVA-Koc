package vehicles;

public class Car extends FueledVehicle {

	private static String id = "Car";
	private static int carQuantity = 0;

	// declare instance variables 
	
	public Car(String brandAndModel, double vehiclePrice, double tank, double fuel, double ratio) {
		super(brandAndModel, vehiclePrice, tank, fuel, ratio);
		carQuantity += 1;
	}

	public static int getCarQuantity() {
		return carQuantity;
	}
	
	// constructor
		// initialization 
			
		// increments car quantity
	
	
	//??
	//public ?? toString()
	

}
