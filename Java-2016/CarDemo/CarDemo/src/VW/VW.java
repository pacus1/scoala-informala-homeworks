package VW;
import VehicleGen.Car;
import VehicleGen.Vehicle;

/**
 * 
 */

/**
 * @author ser
 *
 */
public class VW extends Car implements Vehicle {

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
}