package ro.sci.Dacia;
import ro.sci.VehicleGen.*;


/**
 * 
 */

/**
 * @author ser
 *
 */
public class Dacia extends Car {

	/**
	 * @param chassisNo
	 * @param currentFuelAmount
	 */
	
	public Dacia (double currentFuelAmount, String chassisNo) {
	this.chassisNo = chassisNo;
	this.currentFuelAmount = currentFuelAmount;
	this.carOn = false;
	this.tripDistance = 0;
	}

	public Dacia(String brandName, String model, String chassisNo, int productionYear, FuelType fuelType,
			float carPrice) {
		super(brandName, model, chassisNo, productionYear, fuelType, carPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public int compareTo(Car o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

//	@Override
//	public int compareTo(Object arg0) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	
}
