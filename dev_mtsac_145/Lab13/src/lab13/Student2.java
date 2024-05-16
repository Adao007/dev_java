package lab13;

import java.text.DecimalFormat;

public class Student2 {
	private String firstName;
	private String lastName;
	private Address homeAddress;
	private Address schoolAddress; 
	private int test1;
	private int test2;
	private int test3;
	private final int NUM_TESTS = 3; 
	
	// constructor
	public Student2(String first, String last, Address home, Address school, int testScore1, 
					int testScore2, int testScore3)
	{
		firstName = first;
		lastName = last;
		homeAddress = home;
		schoolAddress = school;
		test1 = testScore1;
		test2 = testScore2;
		test3 = testScore3;
	}
	public Student2(String first, String last, Address home, Address school) // constructor
	{
		firstName = first;
		lastName = last;
		homeAddress = home;
		schoolAddress = school;
	}
	
	public void setTestScore(int testNumber, int score) //takes test number and assigns score to them
	{
		switch (testNumber)
		{
			case 1: test1 = score;
					break;
			case 2: test2 = score;
					break;
			case 3: test3 = score; 
					break;
			default: break;
	
		}
	}
	
	public String average() // takes the average of all three tests
	{
		DecimalFormat df = new DecimalFormat("0.##");
		double scores = test1 + test2 + test3;
		return df.format(scores / NUM_TESTS); 
	}
	
	public int getTestScore(int testNumber) // returns test based on the number input
	{
		if(testNumber == 1) {return test1;}
		else if(testNumber == 2) {return test2;}
		else {return test3;}
	}
	
	public String toString() //toString method
	{
		return "----------------------------------------------" + "\n" +
				this.firstName + " " + this.lastName + "\n" +
				"----------------------------------------------" + "\n" +
				"Home Address: \n" + this.homeAddress + "\n\n" + 
				"School Address: \n" + this.schoolAddress + "\n\n" +
				"Test 1 score: " + test1 + "\n" +
				"Test 2 score: " + test2 + "\n" + 
				"Test 3 score: " + test3 + "\n" +
				"Average test Score: " + this.average(); 
	}
	
}
