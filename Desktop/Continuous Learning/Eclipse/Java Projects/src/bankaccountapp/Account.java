package bankaccountapp;

public abstract class Account implements IBaseRate {
	// List common properties for savings & checking accounts
	private String name;
	private String SSN;
	private double balance;
	private static int index = 10000;
	protected String accountNumber;
	protected double rate;
	
	// Constructor to set base properties and initialize the account
	public Account(String name, String SSN, double initDeposit) {
		this.name = name;
		this.SSN = SSN;
		this.balance = initDeposit;
		
		// Set Account Number without Account Type
		this.accountNumber = setAccountNumber();
		setRate();
	}
	
	protected abstract void setRate();
	
	// Set Account Number without Account Type
	private String setAccountNumber() {
		String lastTwoSSN = this.SSN.substring(SSN.length()-2, SSN.length());
		index++;
		int uniqueNo = index;
		int randomNo = 100 + (int)(Math.random() * 900);
		return lastTwoSSN + uniqueNo + randomNo;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance +=accruedInterest;
		System.out.println("Accured Interest: $" + accruedInterest );
		showBalance();
	}
		
	// List common methods (deposit, withdraw, transfer, showInfo)
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println("Deposit $" + amount);
		showBalance();
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
		System.out.println("Withdrawing $" + amount);
		showBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		this.balance -= amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
		showBalance();
	}
	
	public void showBalance() {
		System.out.println("Your balance is now: " + balance);
	}
	
	public void showInfo() {
		System.out.println("NAME: " + name +
		"\nACCOUNT NUMBER: " + accountNumber + 
		"\nBALANCE: " + balance + 
		"\nRate: " + rate + "%");
	}
}
