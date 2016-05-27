package VehicleGen;

public interface Vehicle {

	public void start();
	public void stop();
	public void drive(double distance);
	public double getAvailableFuel(); 
	public double getAverageFuelConsumption();
	
}
