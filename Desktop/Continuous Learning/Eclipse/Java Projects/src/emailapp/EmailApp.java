package emailapp;

public class EmailApp {
	public static void main(String[] args) {
		Email em1 = new Email("John", "Smith"); 
		// Alternative Mail is not compulsory
		em1.setAlternateEmail("js@mail.com");
		System.out.println(em1.showInfo());
	}
}
