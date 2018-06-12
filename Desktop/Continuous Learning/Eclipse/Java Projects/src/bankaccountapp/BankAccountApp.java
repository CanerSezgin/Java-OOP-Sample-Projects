package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();

		// Read CSV File then create new account based on that data
		// !! Change the string file according to the location of the file 
		String file = "C:\\Users\\Caner\\Desktop\\JavaProjects\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String SSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name, SSN, initDeposit));
			} else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, SSN, initDeposit));
			} else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		
		for (Account acc: accounts) {
			System.out.println("\n***************");
			acc.showInfo();
		}
	}
}
