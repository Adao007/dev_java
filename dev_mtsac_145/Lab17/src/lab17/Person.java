package lab17;

public class Person {
	private int age; 
	private String location; 
	
	public Person(int age, String location)
	{
		this.age = age;
		this.location = location; 
	}
	
	public String toString()
	{
		return "Age: " + age + "\nLocation: " + location + "\n"; 
	}
}
