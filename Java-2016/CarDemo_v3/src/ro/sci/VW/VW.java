package ro.sci.VW;

import ro.sci.VehicleGen.*;

/**
 * 
 */

/**
 * @author ser
 *
 */
public abstract class VW extends Car {

	/**
	 * 
	 */
	public VW(double currentFuelAmount, String chassisNo) {
		// TODO Auto-generated constructor stub
		this.chassisNo = chassisNo;
		this.currentFuelAmount = currentFuelAmount;
		this.carOn = false;
		this.tripDistance = 0;
	}

	public VW(String brandName, String model, String chassisNo, int productionYear, FuelType fuelType, float carPrice) {
		super(brandName, model, chassisNo, productionYear, fuelType, carPrice);
		// TODO Auto-generated constructor stub
	}	
	
	
	
}