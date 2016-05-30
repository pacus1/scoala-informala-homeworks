package ro.sci.VW;
import ro.sci.VehicleGen.*;

public class VWPassat extends VW {

	double[] gearSpecificConsumption = new double[] {0.4,18,13,10,7,4};//consumption in liter/100km; [0] is hourly consumption engine idle
	double tripFuelConsumption;
	double averageFuelConsumption;
	double factoryMediumConsumption = gearSpecificConsumption[0]*0.05+gearSpecificConsumption[1]*0.05+gearSpecificConsumption[2]*0.2+gearSpecificConsumption[3]*0.25+gearSpecificConsumption[4]*0.3+gearSpecificConsumption[5]*0.15;
	/**
	 * @param currentFuelAmount
	 * @param chassisNo
	 */
	public VWPassat(double currentFuelAmount, String chassisNo) {
		super(currentFuelAmount, chassisNo);
		// TODO Auto-generated constructor stub
	}
	
	public VWPassat(String brandName, String model, String chassisNo, int productionYear, FuelType fuelType,
			float carPrice) {
		super(brandName, model, chassisNo, productionYear, fuelType, carPrice);
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
