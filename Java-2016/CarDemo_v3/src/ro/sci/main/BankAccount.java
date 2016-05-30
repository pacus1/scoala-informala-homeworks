package ro.sci.main;

public class BankAccount {
	private int accountNumber;
	private float balance;

	public BankAccount(int accountNumber, float balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public boolean payment(float amount) throws InsufficientFundsException {
		
		if (amount > this.balance){
			throw new InsufficientFundsException("Not enough funds");
		}
		
		this.balance = this.balance - amount;
		return true;
	}
	
	public void deposit (float amount){
		this.balance = this.balance + amount;
	}
	
}
