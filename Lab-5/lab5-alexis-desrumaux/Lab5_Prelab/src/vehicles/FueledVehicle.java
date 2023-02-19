package vehicles;

public class FueledVehicle extends Vehicle implements Refuelable {
	private double fuelTank;
	private double fuelLevel;
	private double fuelToRangeRatio;

	// declare instance variables 
	

	public void setVehicleMaxRange() {
		this.vehicleMaxRange = this.fuelTank * this.fuelToRangeRatio;
	}

	public void setVehicleCurrentRange() {
		this.vehicleCurrentRange = this.fuelLevel * this.fuelToRangeRatio;
	}

	public double getFuelTank() {
		return this.fuelTank;
	}

	public double getFuelLevel() {
		return this.fuelLevel;
	}

	public double getFuelToRangeRatio() {
		return this.fuelToRangeRatio;
	}

	public void drive(double km) {
		if (km < 0) {
			System.out.println("Error. Km must be greater than 0");
			System.exit(1);
		}
		if (this.vehicleCurrentRange == 0) {
			System.out.printf("Fueled Vehicle %s couldnt drive... %.2f liters of fuel left", this.brandAndModel, this.fuelLevel);
			System.out.println("Please Refuel !!");
		}
		else if (this.vehicleCurrentRange - km < 0) {
			this.vehicleCurrentRange = 0;
			this.fuelLevel = this.vehicleCurrentRange / this.fuelToRangeRatio;
			System.out.printf("Fueled Vehicle %s could only drive %.2f kilometers, %.2f liters of fuel left", this.brandAndModel, this.vehicleCurrentRange, this.fuelLevel);
			System.out.println("Please Refuel !!");
		} else {
			this.vehicleCurrentRange -= km;
			this.fuelLevel = this.vehicleCurrentRange / this.fuelToRangeRatio;
			System.out.printf("Fueled Vehicle %s drove %.2f kilometers, %.2f liters of fuel left", this.brandAndModel, km, this.fuelLevel);
		}
		System.out.printf("Fueled Vehicle Current Range: %.2f kilometers", this.vehicleCurrentRange); 
	}

	public FueledVehicle(String brandAndModel, double vehiclePrice, double tank, double fuel, double ratio ) {
		super(brandAndModel, vehiclePrice);
		if (fuelTank < 10 || fuelLevel < 0 || fuelLevel > fuelTank || fuelToRangeRatio < 1) {
			System.out.println("Error in FueledVehicle constructor");
			System.exit(1);
		}
		this.fuelTank = tank;
		this.fuelLevel = fuel;
		this.fuelToRangeRatio = ratio;
		this.vehicleMaxRange = fuelTank * fuelToRangeRatio;
		this.vehicleCurrentRange = fuelLevel * fuelToRangeRatio;
	}

	public String toString() {
		return "";
	}

	public void refuel(double fuelLevel) {
		if (fuelLevel < 0) {
			System.out.println("fuelLevel must be greater than 0");
			System.exit(1);
		}
		if (fuelLevel > fuelTank) {
			this.fuelTank = fuelLevel;
		}
		this.fuelLevel = fuelLevel;
		this.setVehicleCurrentRange();
		this.setVehicleMaxRange();
		if (this.fuelLevel == this.fuelTank) {
			System.out.printf("Fueled Vehicle %s's tank is fully refueled!!", this.brandAndModel);
		} else {
			System.out.printf("Fueled Vehicle %s's tank is refueled! Added: %.2f liters of fuel!", this.brandAndModel, fuelLevel);
		}
		System.out.printf("Fueled Vehicle %s's Current Range: %.2f kms", this.brandAndModel, this.vehicleCurrentRange);
	}



	// constructor
		// intialization 
		
		// controlled initialization of instance variables
		
		// sets current and max ranges
	

	// getters
	
	
	
	//??
	//public ?? setVehicleCurrentRange() 
	
	
	//??
	//public ?? setVehicleMaxRange() 
	

	// ??
	//public ?? refuel(double fuelLevel) 
		
	
	// ??
	//public ?? drive(double km) 
	
	
	// ??
	//public ?? toString() 
	
	
	
	
	
}
