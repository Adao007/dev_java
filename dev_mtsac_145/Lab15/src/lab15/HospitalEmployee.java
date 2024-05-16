package lab15;

public class HospitalEmployee {
	
	protected String name;
	protected int number; 
	
	public HospitalEmployee(String name, int number)
	{
		this.name = name;
		this.number = number; 
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setNumber(int number)
	{
		this.number = number; 
	}
	public String getName()
	{
		return name;
	}
	public int getNumber()
	{
		return number;
	}
	public String toString()
	{
		return name + " " + number;
	}
	public void work()
	{
		System.out.println(this.getName() + " works for the hospital.");
	}
}
