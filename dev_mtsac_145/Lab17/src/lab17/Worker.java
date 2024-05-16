package lab17;

public class Worker extends Person {
	private String occupation; 
	private int income; 
	
	public Worker(int age, String location, String occupation, int income)
	{
		super(age, location);
		this.occupation = occupation;
		this.income = income; 
	}
	
	public String toString()
	{
		return super.toString() + "Occupation: " + occupation + "\nIncome: " + income; 
	}
}












