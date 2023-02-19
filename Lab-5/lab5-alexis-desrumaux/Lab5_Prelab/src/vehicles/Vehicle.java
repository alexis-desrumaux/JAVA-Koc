package vehicles;

public abstract class Vehicle implements Drivable  {
	
	private static int vehicleQuantity = 0;
	protected String brandAndModel;
	private double vehiclePrice;
	protected double vehicleMaxRange;
	protected double vehicleCurrentRange;

	// declare instance variables 
	
	// constructor
		// controlled initialization of instance variables
	
	public Vehicle(String brandAndModel, double vehiclePrice) {
		if (brandAndModel.isEmpty() || vehiclePrice < 0) {
			this.brandAndModel = "";
			this.vehiclePrice = 0;
		} else {
			this.brandAndModel = brandAndModel;
			this.vehiclePrice = vehiclePrice;
		}
		this.vehicleMaxRange = 0;
		this.vehicleCurrentRange = 0;
		vehicleQuantity += 1;
	}

	public String getBrandAndModel() {
		return this.brandAndModel;
	}

	public void setBrandAndModel(String brandAndModel) {
		this.brandAndModel = brandAndModel;
	}

	public double getVehiclePrice() {
		return this.vehiclePrice;
	}

	public void setVehiclePrice(double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}

	public double getVehicleMaxRange() {
		return this.vehicleMaxRange;
	}

	public void setVehicleMaxRange(double vehicleMaxRange) {
		this.vehicleMaxRange = vehicleMaxRange;
	}

	public abstract void setVehicleMaxRange();

	public double getVehicleCurrentRange() {
		return this.vehicleCurrentRange;
	}

	public void setVehicleCurrentRange(double vehicleCurrentRange) {
		this.vehicleCurrentRange = vehicleCurrentRange;
	}
	
	public abstract void setVehicleCurrentRange();

	public abstract String toString();

	public static int getVehicleQuantity() {
		return vehicleQuantity;
	}



	// ?? ?? ?? drive(double km);
	// ?? ?? ?? setVehicleCurrentRange();
	// ?? ?? ?? setVehicleMaxRange();
    	// ?? ?? ?? toString();
    
    	// getters and setters
	

}
