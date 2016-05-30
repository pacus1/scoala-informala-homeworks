package ro.sci.Dacia;

import ro.sci.VehicleGen.Car.FuelType;
import ro.sci.VehicleGen.Vehicle;

public class Duster extends Dacia {
		
		double[] gearSpecificConsumption = new double[] {0.5, 25,18,14,9,5};//consumption in liter/100km
		double tripFuelConsumption;
		double averageFuelConsumption;
		double factoryMediumConsumption = gearSpecificConsumption[0]*0.05+gearSpecificConsumption[1]*0.05+gearSpecificConsumption[2]*0.2+gearSpecificConsumption[3]*0.25+gearSpecificConsumption[4]*0.3+gearSpecificConsumption[5]*0.15;
		
		/**
		 * @param chassisNo
		 * @param currentFuelAmount
		 */
		
		public Duster(double currentFuelAmount, String chassisNo) {
			super(currentFuelAmount, chassisNo);
		}
		
		public Duster(String brandName, String model, String chassisNo, int productionYear, FuelType fuelType,
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
