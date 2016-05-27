package VW;
import VehicleGen.Vehicle;

/**
 * 
 */

/**
 * @author ser
 *
 */
public class VWGolf extends VW implements Vehicle {

	double[] gearSpecificConsumption = new double[] {0.4,18,13,10,7,4};//consumption in liter/100km; [0] is hourly consumption engine idle
	double tripFuelConsumption;
	double averageFuelConsumption;
	/**
	 * @param currentFuelAmount
	 * @param chassisNo
	 */
	public VWGolf(double currentFuelAmount, String chassisNo) {
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
		//the car automatically shifts to first gear if the driver press the acceleration pedal 
		if (currentGear == 0){
			this.shiftGear(1);
			currentGear = getCurrentGear();
		}
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
