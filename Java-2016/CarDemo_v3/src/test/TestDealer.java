package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.sci.Dacia.Duster;
import ro.sci.Dacia.Logan;
import ro.sci.VW.VWGolf;
import ro.sci.VW.VWPassat;
import ro.sci.VehicleGen.Car;
import ro.sci.VehicleGen.Car.FuelType;
import ro.sci.main.BankAccount;
import ro.sci.main.CarDealership;
import ro.sci.main.CarNotInStockException;
import ro.sci.main.Client;
import ro.sci.main.ClientAccount;
import ro.sci.main.ClientType;
import ro.sci.main.InsufficientFundsException;
import ro.sci.main.NoBankAcountException;

/**
 * QUESTIONS FOR TRAINERS
 * 1) I used Set instead of List as I wanted to work without index as I considered that for me will be a good exercise to work without it. 
 * I don't feel comfortable working without index. Please let me know if this approach is reliable or there is a better one?
 * 2) I was not able to fully implement sorting (the issue is if I want to list all the cars I will get only one car from each existing year.
 * If 2 different cars from same year only one will be shown.
 * 3) There is one question in CarDealership class: not sure if this statement must be surrounded with Try and Catch,I don't have 
 * errors but the method throws an Exception 
 * 4) In my program design I did not see any need of using Map containers. Please advise what part of my program could be better develop using Map
 * 5)    
 */


public class TestDealer {
	CarDealership compexit = new CarDealership("Compexit");
	Client client,client2;
	Car desiredCar;
	BankAccount bankAccount;
	Car secondHandCar;
	
	@Before
	public void setUp() throws Exception {
		
//		initialize dealer
//		add cars to Dealer
		//Car car;
		compexit.addCarsToDealerStock(new Duster("Dacia", "Duster", "12345", 2013, FuelType.DIESEL,15000));
		compexit.addCarsToDealerStock(new Duster("Dacia", "Duster", "12346", 2014, FuelType.PETROL,12000));
		compexit.addCarsToDealerStock(new Logan("Dacia", "Logan", "13456", 2016, FuelType.DIESEL,10000));
		compexit.addCarsToDealerStock(new Logan("Dacia", "Logan", "12454", 2011, FuelType.PETROL,8000));
		compexit.addCarsToDealerStock(new VWGolf("VW", "Golf", "43214", 2015, FuelType.PETROL,15500));
		compexit.addCarsToDealerStock(new VWPassat("VW", "Passat", "86541", 2016, FuelType.PETROL,20000));
		compexit.addCarsToDealerStock(new VWPassat("VW", "Passat", "25687", 2016, FuelType.DIESEL,25000));
		
		//add bank account
		compexit.setDealerBankAccount(new BankAccount(987654, 10000));
		
		//add client
		//Client client,client2;
		//BankAccount bankAccount;
		
		bankAccount = new BankAccount(111111, 25000);
		client = new Client("Ionescu",ClientType.PFizica, 135820, bankAccount);
		client2 = new Client("SC Ionel SRL",ClientType.PJuridica, 654654, new BankAccount (222222,20000));
		
		//desired car to buy
		desiredCar = new Logan("Dacia", "Logan", "13456", 2016, FuelType.DIESEL,10000); //third car in the test list
				
//		//sell process
		//compexit.sellCarToClient(desiredCar, client);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sellProcess() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		assertTrue(compexit.sellCarToClient(desiredCar, client));
		compexit.listAllCarsInStock();//initial number of cars in stock 7, remaining 6
		//compexit.listAllCarsInClientFleet(client);
	}

	@Test
	public void sellProcessCheckDealerBankAccount() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		assertTrue(compexit.sellCarToClient(desiredCar, client));
		
		assertEquals(20000, compexit.getDealerBankAccount().getBalance(), 0);
		//compexit.listAllCarsInStock();//initial number of cars in stock 7, remaining 6
	}
	
	@Test
	public void sellProcessCheckClientBankAccount() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		assertTrue(compexit.sellCarToClient(desiredCar, client));
		
		assertEquals(15000, client.getBankAccount().getBalance(), 0);
		//compexit.listAllCarsInStock();//initial number of cars in stock 7, remaining 6
	}
	
	@Test
	public void sellProcessCheckClientFleet() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		assertTrue(compexit.sellCarToClient(desiredCar, client));
		
		compexit.listAllCarsInClientFleet(client);
		
		//assertEquals(desiredCar, compexit.getCustomerAccount().equals(client), 0);
		//compexit.listAllCarsInStock();//initial number of cars in stock 7, remaining 6
	}
	
	@Test
	public void sellProcessCarNotExist() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		//assertTrue(compexit.sellCarToClient(desiredCar, client));
		desiredCar = new Logan("Dacia", "Sandero", "13456", 2016, FuelType.DIESEL,10000); //this car does not exist in dealer's stock
		
		try {
			assertTrue(compexit.sellCarToClient(desiredCar, client));
		} catch (CarNotInStockException e) {
			System.out.println("The car you wish is not in dealers stock at the moment");
		}
	}
	
	@Test
	public void sellProcessInsufficientFunds() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		//assertTrue(compexit.sellCarToClient(desiredCar, client));
		
		bankAccount = new BankAccount(111111, 9999);
		client = new Client("Ionescu",ClientType.PFizica, 135820, bankAccount);
		
		try {
			compexit.sellCarToClient(desiredCar, client);
		} catch (InsufficientFundsException e) {
			System.out.println("you have insufficient funds");
		}
	}
	
	@Test
	public void sellProcessClientNoBankAccount() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		//assertTrue(compexit.sellCarToClient(desiredCar, client));
		
		//bankAccount = new BankAccount(null, 9999);
		client = new Client("Ionescu",ClientType.PFizica, 135820, null);
		
		try {
			compexit.sellCarToClient(desiredCar, client);
		} catch (NoBankAcountException e) {
			System.out.println("you don't have a bank account");
		}
	}
	
	@Test
	public void listDealerCarsByAge() throws CarNotInStockException, InsufficientFundsException, NoBankAcountException {
		
		compexit.listAllCarsInStockByAge();
	}
	
	@Test
	public void buybackFromExternalClient() throws InsufficientFundsException, NoBankAcountException {
		
		bankAccount = new BankAccount(111111, 15000);
		client = new Client("Ionescu",ClientType.PFizica, 135820, bankAccount);
		secondHandCar = new VWGolf("VW", "Golf", "44444", 2010, FuelType.DIESEL,5000);
		
		assertTrue(compexit.buyCarFromClient(secondHandCar, client));
		
		System.out.println("\n after the last car acquisition the dealer stock is the following:");
		compexit.listAllCarsInStock();
	}
	
	@Test
	public void buybackFromInternalClientAccount() throws InsufficientFundsException, NoBankAcountException {
		
		//Initialization of a ClientAccount
		bankAccount = new BankAccount(111111, 15000);
		client = new Client("Ionescu",ClientType.PFizica, 135820, bankAccount);
		secondHandCar = new VWGolf("VW", "Golf", "55555", 2010, FuelType.DIESEL,20000);
		
		ClientAccount existingClient = new ClientAccount(client, secondHandCar);
		compexit.getCustomerAccount().add(existingClient);
		
		assertTrue(compexit.buyCarFromClientAccount(secondHandCar, client));
		
		System.out.println("\n after the last car acquisition from an existing customer the dealer stock is the following:");
		compexit.listAllCarsInStock();
	}
}
