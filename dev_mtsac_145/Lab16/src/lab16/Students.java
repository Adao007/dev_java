package lab16;

public class Students extends Person{
	private String major;
	private double gpa;
	
	public Students(String id, String name, String email, String major, double gpa)
	{
		super(id, name, email);
		this.major = major;
		this.gpa = gpa; 
	}
	
	public void setMajor(String major)
	{
		this.major = major;
	}
	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}
	public String getMajor()
	{
		return major;
	}
	public double getGpa()
	{
		return gpa;
	}
	
	public String toString()
	{
		return super.toString() + "    " + major + " " + gpa; 
	}
}
