package lab17;

public class Student extends Person {
	private String university; 
	
	public Student(int age, String location, String university)
	{
		super(age, location);
		this.university = university; 
	}
	
	public String toString()
	{
		return super.toString() + "University: " + university + "\n"; 
	}

}
