package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int defaultPasswordLength = 10;
	private String department;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companyDomain = "company.com";

// Constructor to receive firstName & lastName
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("New Worker: " + this.firstName + " " + this.lastName);
	
	// Call a method that returns Department
		this.department = setDepartment();
		
	// Call a method that returns Random Password
		this.password = randomPassword(defaultPasswordLength);
		
	// Create Email 
		email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + this.companyDomain; 
	}
	
// Asks for the department
	private String setDepartment() {
		System.out.print("DEPARTMENT CODE\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {return "sales";}
		else if (depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "actt";}
		else {return "";}
	}
	
// Generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!#$%&{";
		char [] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
// Set the mailboxCapacity
	public void setMailboxCapacity(int cap) {
		this.mailboxCapacity = cap;
	}
	
// Set the alternateEmail
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return this.mailboxCapacity;}
	public String getAlternateEmail() {return this.alternateEmail;}
	public String getPassword() {return this.password;}
	
	public String showInfo() {
		return 	"\nWorker Name: " + firstName + " " + lastName +
				"\nDepartment: " + department +
				"\nComp.Mail: " + email +
				"\nPassword: " + password +
				"\nMail Capacity: " + mailboxCapacity + " mb" +
				"\nAlternative Mail: " + alternateEmail;
	}
}


