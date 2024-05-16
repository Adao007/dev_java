package lab15;

public class Administrator extends HospitalEmployee {

	protected String department;
	
	public Administrator(String name, int number, String dept)
	{
		super(name, number);
		this.department = dept;
	}
	public void setDepartment(String dept)
	{
		this.department = dept;
	}
	public String getDepartment()
	{
		return department;
	}
	public String toString()
	{
		return super.toString() + " works in " + department;
	}
	public void administrate()
	{
		System.out.println(this.name + " works in the " + department + " department.");
	}
}
