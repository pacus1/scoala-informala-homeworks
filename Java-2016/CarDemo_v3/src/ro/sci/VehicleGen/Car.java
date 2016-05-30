package ro.sci.VehicleGen;

import java.util.Comparator;
import ro.sci.main.CarDealership;

/**
 * 
 */
/**
 * @author ser
 *
 */
public abstract class Car implements Vehicle, Comparable  {
	
	protected String chassisNo;
	protected double currentFuelAmount;
	private double fuelTank;
	private int noOfGears;
	protected boolean carOn;
	private int currentGear;
	private double odometer;
	protected double tripDistance;
	private double tripConsumption;
	private int productionYear;
	private FuelType fuelType;
	private String brandName;
	private String model;
	private float carPrice;
	
	CarDealership dealer = new CarDealership();
	
	/*public Car(String chassisNo, double currentFuelAmount) {
		this.chassisNo = chassisNo;
		this.currentFuelAmount = currentFuelAmount;
		this.carOn = false;
	}*/
	
	public Car(String brandName, String model, String chassisNo, int productionYear, FuelType fuelType,
			float carPrice) {
		super();
		this.brandName = brandName;
		this.model = model;
		this.chassisNo = chassisNo;
		this.productionYear = productionYear;
		this.fuelType = fuelType;
		this.carPrice = carPrice;
	}

	public enum FuelType {
		DIESEL, PETROL, ELECTRIC, HYBRID;
	}
 
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
	
	public void setCarPrice(float carPrice) {
		this.carPrice = carPrice;
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

	public String getChassisNo() {
		return chassisNo;
	}

	public boolean isCarOn() {
		return carOn;
	}

	public double getOdometer() {
		return odometer;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public String getBrandName() {
		return brandName;
	}

	public String getModel() {
		return model;
	}

	public float getCarPrice() {
		return carPrice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)//for objects is the same refference so this is the same object
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (this.brandName != other.brandName)
			return false;
		if (this.model != other.model)
			return false;
		if (this.chassisNo != other.chassisNo)
			return false;
		if (this.productionYear != other.productionYear)
			return false;
		if (this.fuelType != other.fuelType)
			return false;
		if (this.carPrice != other.carPrice)
			return false;
		
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.brandName + ", " + this.model + ", " + this.chassisNo + ", " + this.fuelType + 
					", " + this.productionYear + ", " + this.carPrice + " euro" + "\n";
	}
}
