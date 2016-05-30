package ro.sci.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ro.sci.VehicleGen.Car;

public class ClientAccount {
	private Client client;
	private Set <Car> clientFleet = new HashSet<>();
	
	public ClientAccount(Client client, Set<Car> clientFleet) {
		super();
		this.client = client;
		this.clientFleet = clientFleet;
	}
	
	public ClientAccount(Client client, Car car) {
		super();
		this.client = client;
		this.clientFleet.add(car);
	}
	
	public ClientAccount(Client client) {
		super();
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Car> getClientFleet() {
		return clientFleet;
	}

	public void setClientFleet(Set<Car> clientFleet) {
		this.clientFleet = clientFleet;
	}
	
}
