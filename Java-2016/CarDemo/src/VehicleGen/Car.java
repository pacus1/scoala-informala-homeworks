package VehicleGen;
/**
 * 
 */

/**
 * @author ser
 *
 */
public class Car implements Vehicle {
	
	protected String chassisNo;
	protected double currentFuelAmount;
	private double fuelTank;
	private int noOfGears;
	protected boolean carOn;
	private int currentGear;
	private double odometer;
	protected double tripDistance;
	private double tripConsumption;

	/*public Car(String chassisNo, double currentFuelAmount) {
		this.chassisNo = chassisNo;
		this.currentFuelAmount = currentFuelAmount;
		this.carOn = false;
	}*/
	
	public Car(){	
	}
	
	@Override
	public void start() {
		this.carOn = true;
		this.tripDistance = 0;
		this.tripConsumption = 0;
		this.currentGear=0;
	}
	
	@Override
	public void stop() {
		this.carOn = false;
	}
	
	@Override
	public void drive(double distance) {
	}

	public void shiftGear (int i){
		this.currentGear = i;
	}
		
	public void refuel (double newFuelAmount){
		this.currentFuelAmount = newFuelAmount;
	}
	
	public double getFuelTank() {
		return fuelTank;
	}

	public void setFuelTank(double fuelTank) {
		this.fuelTank = fuelTank;
	}

	public int getNoOfGears() {
		return noOfGears;
	}

	public void setNoOfGears(int noOfGears) {
		this.noOfGears = noOfGears;
	}
	public int getCurrentGear() {
		return currentGear;
	}
	public void setCurrentGear(int currentGear) {
		this.currentGear = currentGear;
	}
	public double getCurrentFuelAmount() {
		return currentFuelAmount;
	}
	
	public double getAvailableFuel() {
		return currentFuelAmount;
	}
	
	public void setCurrentFuelAmount(double currentFuelAmount) {
		this.currentFuelAmount = currentFuelAmount;
	}

	public double getTripDistance() {
		return tripDistance;
	}

	public void setTripDistance(double tripDistance) {
		this.tripDistance = tripDistance;
	}

	public double getTripConsumption() {
		return tripConsumption;
	}

	public void setTripConsumption(double tripConsumption) {
		this.tripConsumption = tripConsumption;
	}

	public double getAverageFuelConsumption(){
		double averageTripFuelConsumption; //in liters /100 km
		
		//calculates the average fuel consumption for a trip
		averageTripFuelConsumption = this.tripConsumption / (this.tripDistance / 100);
		
		return averageTripFuelConsumption; 
	}
	
	
}
