package bankaccountapp;

public class Savings extends Account {
	// List properties for valid only Savings ()
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	// constructor to initialize settings for savings account
	public Savings(String name, String SSN, double initDeposit) {
		super(name, SSN, initDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	
	protected void setRate() {
		this.rate = getBaseRate() - .25;
	}
	
	// List methods for valid savings account
	private void setSafetyDepositBox() {
		safetyDepositBoxID = 100 + (int)(Math.random() * 900);
		safetyDepositBoxKey = 1000 + (int)(Math.random() * 9000);
	}
	
	@Override
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Savings");
		super.showInfo();
		System.out.println("** Saving Account Features **" + 
							"\n   Safety Box ID: " + safetyDepositBoxID + 
							"\n   Safety Box PIN: " + safetyDepositBoxKey);
	}
}
