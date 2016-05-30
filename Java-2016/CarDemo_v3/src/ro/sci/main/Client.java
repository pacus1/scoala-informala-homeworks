package ro.sci.main;

import ro.sci.VehicleGen.Car;

public class Client {
	private String name;
	private ClientType clientType; // Pfizica, Pjuridica
	private int clientIndentificationNo;
	private BankAccount bankAccount;
	
	public Client(String name, ClientType clientType, int clientIndentificationNo, BankAccount bankAccount) {
		super();
		this.name = name;
		this.clientType = clientType;
		this.clientIndentificationNo = clientIndentificationNo;
		this.bankAccount = bankAccount;
	}
	
	public Client(String name, ClientType clientType, int clientIndentificationNo) {
		super();
		this.name = name;
		this.clientType = clientType;
		this.clientIndentificationNo = clientIndentificationNo;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	public int getClientIndentificationNo() {
		return clientIndentificationNo;
	}

	public void setClientIndentificationNo(int clientIndentificationNo) {
		this.clientIndentificationNo = clientIndentificationNo;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)//for objects is the same refference so this is the same object
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (this.name != other.name)
			return false;
		if (this.clientIndentificationNo != other.clientIndentificationNo)
			return false;
//		
//		
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
		return true;
	}
	
	
	
	
}
