package bankaccountapp;

public class Checking extends Account {
	// List properties for valid only Checking (DebitCard, PIN, )
	private long debitCardNumber;
	private int debitCardPIN;
	
	// constructor to initialize checking account
	public Checking(String name, String SSN, double initDeposit) {
		super(name, SSN, initDeposit);  // Constructor: Account (String name) is invoked. 
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	protected void setRate() {
		this.rate = getBaseRate() * .15;
	}
	
	// List methods for valid checking account
	private void setDebitCard() {
		debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
		debitCardPIN = 1000 + (int)(Math.random() * 9000);
	}
	
	@Override
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking");
		super.showInfo();
		System.out.println("** Checking Account Features **" + 
							"\n   Debit Card Number: " + debitCardNumber + 
							"\n   Debit Card PIN: " + debitCardPIN);
	}
}
