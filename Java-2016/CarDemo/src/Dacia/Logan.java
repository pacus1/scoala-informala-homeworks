package Dacia;
import VehicleGen.Vehicle;

/**
 * 
 */

/**
 * @author ser
 *
 */
public class Logan extends Dacia implements Vehicle {
		
	double[] gearSpecificConsumption = new double[] {0.5, 20,16,12,8,4};//consumption in liter/100km
	double tripFuelConsumption;
	double averageFuelConsumption;
	
	/**
	 * @param chassisNo
	 * @param currentFuelAmount
	 */
	
	public Logan(double currentFuelAmount, String chassisNo) {
		super(currentFuelAmount, chassisNo);
		// TODO Auto-generated constructor stub
	}
	
	public void drive(double distance){
		int currentGear;
		double consumptionPerDistance;
		double availableFuel;
		double tripDistance;
		double tripConsumption;
		
		//calculate fuel consumption by distance and gear
		currentGear = getCurrentGear();
		consumptionPerDistance =  (distance/100) * gearSpecificConsumption [currentGear];
		
		//updating trip distance
		tripDistance = getTripDistance();
		setTripDistance(tripDistance + distance);
		
		//updating trip fuel consumption 
		tripConsumption = getTripConsumption();
		setTripConsumption(tripConsumption + consumptionPerDistance);
				
		//update fuel tank level
		availableFuel = getCurrentFuelAmount();
		setCurrentFuelAmount(availableFuel - consumptionPerDistance); //update remaining fuel amount after driving a certain distance
		
	}
	
}
