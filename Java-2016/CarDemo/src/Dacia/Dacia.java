package Dacia;
import VehicleGen.Car;
import VehicleGen.Vehicle;

/**
 * 
 */

/**
 * @author ser
 *
 */
public class Dacia extends Car implements Vehicle {

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
	
	//public Dacia(String chassisNo, double currentFuelAmount) {
				
		//super(chassisNo, currentFuelAmount);
		// TODO Auto-generated constructor stub
	//}
	
}
