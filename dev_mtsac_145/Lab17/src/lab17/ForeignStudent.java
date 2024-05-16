package lab17;

public class ForeignStudent extends Student {
	private String nationality;
	
	public ForeignStudent(int age, String location, String university, String nationality)
	{
		super(age, location, university);
		this.nationality = nationality; 
	}
	
	public String toString()
	{
		return super.toString() + "Nationality: " + nationality + "\n"; 
	}
}
