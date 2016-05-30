package ro.sci.main;

import ro.sci.Dacia.*;
import ro.sci.VW.*;
import ro.sci.VehicleGen.*;


public class CarDemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Car car = new Car(); // Car should be a base class.
		double currentFuelAmmount = 27;
		String chassisNumber ="oiqe0934hkkadsn";
		//Car car = new Dacia(currentFuelAmmount, chasseNumber); // This should not be allowed! If I want to create a Dacia car, I will need to create an instance of a model.
		Car car = new Logan(currentFuelAmmount,chassisNumber); // Logan can extend from Dacia, while Dacia extends from Car
		car.start();
		car.shiftGear(1);
		car.drive(0.01);// drives 0.01 KMs
		car.shiftGear(2);
		car.drive(0.02);
		car.shiftGear(3);
		car.drive(0.5);
		car.shiftGear(4);
		car.drive(0.5);
		car.shiftGear(4);
		car.drive(0.5);
		car.shiftGear(5);
		car.drive(10);
		car.shiftGear(4);
		car.drive(0.5);
		car.shiftGear(3);
		car.drive(0.1);
		car.stop();
		double availableFuel = car.getAvailableFuel(); // this value must be smaller than the initial value passed in the constructor
		double fuleConsumedPer100Km = car.getAverageFuelConsumption();
		System.out.println("fuel left in tank: " + availableFuel);
		System.out.println("average fuel consumption for last trip: " + fuleConsumedPer100Km + " liters/100km");
		
		
		Vehicle vehicle = new VWGolf(30, "1987ddkshik289"); //available fuel and chassis number
		vehicle.start();
		vehicle.drive(1);
		vehicle.stop();
		
		
//		
//		double availableFuel_2 = vehicle.getAvailableFuel(); // this value must be smaller than the initial value passed in the constructor
//		double fuleConsumedPer100Km_2 = vehicle.getAverageFuelConsumption();
//		System.out.println("fuel left in tank: " + availableFuel_2);
//		System.out.println("average fuel consumption for last trip: " + fuleConsumedPer100Km_2 + " liters/100km");
		
		Car car2 = (Car) vehicle;//downcast
		double availableFuel_3 =car2.getAvailableFuel();
		double fuleConsumedPer100Km_3 =car2.getAverageFuelConsumption();
		System.out.println("fuel left in tank: " + availableFuel_3);
		System.out.println("average fuel consumption for last trip: " + fuleConsumedPer100Km_3 + " liters/100km");
		
	}

}
