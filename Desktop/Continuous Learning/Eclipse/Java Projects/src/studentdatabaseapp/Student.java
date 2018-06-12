package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String courses = "";
	private String studentID;
	private int tuitionBalance;
	private static int courseCost = 600; //USD
	private static int id = 1000;
	
	// Constructor: Student's name & Year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter student First Name: ");
		this.firstName = in.nextLine();
		
		System.out.print("Enter student Last Name: ");
		this.lastName = in.nextLine();
		
		System.out.print("1 - Freshmen\n2 - Sophmore\n3 - Junior\n4 - Senior"
							+ "\nEnter student Class Level: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();
	}
	
	// Generate ID
	private void setStudentID() {
		id++;
		this.studentID = this.gradeYear + "" + id;
	}
	
	// Enroll in course
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Q for Quit)");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				this.courses = this.courses + "\n   " + course;
				this.tuitionBalance += courseCost;
			} else {
				break;
			}
		} while (1 != 0);
	}
	
	// View Balance
	public void viewBalance() {
		System.out.println("Your Balance is: $" + this.tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		this.tuitionBalance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
	}
	
	// Show status
	public String showStatus() {
		return 	"Name: " + firstName + " " + lastName + 
				"\nGrade Level: " + gradeYear + 
				"\nStudentID: " + studentID + 
				"\nCourses Enrolled: " + courses + 
				"\nTuition Balance: " + tuitionBalance;
	}
}
