package lab13;

public class StudentBody2 {
	
	public static void main(String[] args)
	{
		Address school = new Address("800 Lancaster Ave.", "Villanova", "PA", 19085);
		Address jHome = new Address("21 Jump Street", "Blacksburg", "VA", 24551);
		Student2 john = new Student2("John", "Smith", jHome, school);
		
		Address mHome = new Address("123 Main Street", "Euclid", "OH", 44132);
		Student2 marsha = new Student2("Marsha", "Jones", mHome, school, 100, 80, 94);
		
		System.out.println(john);
		System.out.println(marsha);
		
		john.setTestScore(1, 78);
		john.setTestScore(2, 92);
		john.setTestScore(3, 80);
		
		marsha.setTestScore(2, 83);
		System.out.println(); 
		
		System.out.println("John's score on test 1: " + john.getTestScore(1));
		System.out.println("Marsha's score on test 2: " + marsha.getTestScore(2));
		System.out.println();
		System.out.println(john);
		System.out.println(marsha);
	}
	
}
