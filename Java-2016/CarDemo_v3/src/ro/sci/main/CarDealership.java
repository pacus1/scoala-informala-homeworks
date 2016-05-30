package ro.sci.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import ro.sci.Dacia.Duster;
import ro.sci.Dacia.Logan;
import ro.sci.VW.VWGolf;
import ro.sci.VW.VWPassat;
import ro.sci.VehicleGen.Car;
import ro.sci.VehicleGen.Car.FuelType;


public class CarDealership  {

	private String dealerName;
	private Set<Car> carDealerStock = new HashSet<>();
	private Set<ClientAccount> customerAccount = new HashSet<>();
	private BankAccount dealerBankAccount;
	
	
	public String getDealerName() {
		return dealerName;
	}

	public Set<Car> getCarDealerStock() {
		return carDealerStock;
	}

	public Set<ClientAccount> getCustomerAccount() {
		return customerAccount;
	}

	//constructors
	public CarDealership (String dealerName){
		this.dealerName = dealerName;
	}
	
	//constructors
	public CarDealership (){
		}
	
	public CarDealership (String dealerName, BankAccount bankAccount){
		this.dealerName = dealerName;
		this.dealerBankAccount = bankAccount;
	}
	
	public  void addCarsToDealerStock(Car car){
		this.carDealerStock.add(car);
		//return this.carDealerStock;
	}
	
	public boolean sellCarToClient (Car desiredCar, Client client) throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		Boolean existBankAccount;
		//Flow
		//verify if the car exists in dealer's stock
		checkDesiredCarInDealerStock (desiredCar);//QUESTION - not sure if this statement must be surrounded with Try and Catch, 
												  //I don't have errors but the method throws an Exception
		
		//verify if the transaction can be made; withdraw the car price from client bank account; 
		//throws "InsufficientFundsException"
		if (client.getBankAccount()==null){
			throw new NoBankAcountException("you don't have a bank account, please open one an come back again");
		}
		
		client.getBankAccount().payment(desiredCar.getCarPrice());

		//add car price to dealer bank account
		this.dealerBankAccount.deposit(desiredCar.getCarPrice());
		
		//check if the client has been registered as clientAccount before
		//if it has been registered only the new car
		//otherwise add new client account and the car acquired 
		if(checkExistClientAccount(client)){
			for (ClientAccount customer:this.customerAccount){
				if(customer.getClient().equals(client)){
					customer.getClientFleet().add(desiredCar);
				}
			}
		}else{
			this.customerAccount.add(new ClientAccount(client, desiredCar));
			}
	
		//delete car from dealer stock
		removeCarFromDealer(desiredCar);

		return true;		
	}
	
	public boolean buyCarFromClient(Car secondHandCar, Client client) throws InsufficientFundsException, NoBankAcountException {
		//Flow
		//check the existence of Client bank account
		if (client.getBankAccount()==null){
			throw new NoBankAcountException("you don't have a bank account, please open one an come back again");
		}
		
		//withdraw funds (car price) from dealer account
		this.dealerBankAccount.payment(secondHandCar.getCarPrice());
	
		//add the car amount to seller account; throw error if the bank account does not exist
		client.getBankAccount().deposit(secondHandCar.getCarPrice());
		
		//add car to dealer stock
		this.carDealerStock.add(secondHandCar);
		
		return true;
	}

	public boolean buyCarFromClientAccount(Car secondHandCar, Client client) throws InsufficientFundsException {
		float secondHandCarPrice;
		int currYear = Calendar.getInstance().get(Calendar.YEAR);
		//Flow
		//evaluate the car price as (new car price) * (8 - (curr year - car production year))/8; no cars older than 8 years
		secondHandCarPrice = (float) (secondHandCar.getCarPrice() * 0.2);//((8 - (currYear - secondHandCar.getProductionYear())/8));
		secondHandCar.setCarPrice(secondHandCarPrice);
		
		//withdraw funds (car price) from dealer account
		this.dealerBankAccount.payment(secondHandCarPrice);
	
		//add the car amount to seller account; throw error if the bank account does not exist
		client.getBankAccount().deposit(secondHandCarPrice);
		
		//add car to dealer stock
		this.carDealerStock.add(secondHandCar);
		
		//remove car from ClientAccount fleet
		removeCarFromClientAccount(secondHandCar, client);
		
		return true;
	}
	
	public BankAccount getDealerBankAccount() {
		return dealerBankAccount;
	}

	public void setDealerBankAccount(BankAccount dealerBankAccount) {
		this.dealerBankAccount = dealerBankAccount;
	}
	
	public void checkDesiredCarInDealerStock (Car desiredCar) throws CarNotInStockException {
		Set<Car> dealerStock = this.carDealerStock;
		
		for(Car car:this.carDealerStock)
			if(car.equals(desiredCar)){
				return;
			}
		throw new CarNotInStockException("The car you want is not currently in the dealer's stock");
	}
	
	public boolean checkExistClientAccount (Client client){
		Set<ClientAccount> dealerClientAccount = this.customerAccount;	
		
		for(ClientAccount newClient:this.customerAccount){
			if(newClient.getClient().equals(client)){
				return true;
			}
		}
		return false;
	}	
	
	public void removeCarFromDealer(Car desiredCar){
			for (Car car:this.carDealerStock){
				if (desiredCar.equals(car)){
					this.carDealerStock.remove(car);
					return;
				}
			}
	}
	
	public void removeCarFromClientAccount(Car secondHandCar, Client client){
		
		for(ClientAccount sellerClient:this.customerAccount){
			if(sellerClient.getClient().equals(client)){
				sellerClient.getClientFleet().remove(secondHandCar);
			}
		}
}
	
	public void listAllCarsInStock(){
		System.out.println("The following cars are available at dealer: \n");
		for (Car car : carDealerStock) {
			System.out.print(car.toString());
		}
	}
	
	public void listAllCarsInClientFleet(Client client){
		System.out.println("The following cars are available for client: \n" + client.getName());
		for (ClientAccount existClient: this.customerAccount) {
			if (existClient.getClient().equals(client)){
				
				for(Car car:existClient.getClientFleet()){
					System.out.print(car.toString());
				}	
			}
		}
	}
	
	
	public void listAllCarsInStockByAge(){
		System.out.println("The following cars are available at dealer, sorted by age: \n");
		
		SortedSet<Car> set= new TreeSet<>(Comparator.comparing(Car::getProductionYear));
		for (Car car : carDealerStock) {
			set.add(car);
		}
		System.out.println("Set after sorting:");
		
		Iterator it =set.iterator(); 
		while (it.hasNext()) {
			Car test = (Car) it.next();
			System.out.print(test.toString());
		}

	}
}
