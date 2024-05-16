package Lab5;

public class Course {
	

	private String crn;
	private String name;
	private int number;
	
	public Course(String crn, String n, int num)
	{
		crn = crn;
		name = n;
		number = num;
	}
	
	public void setNumofStudents(int num)
	{
		number = num;
	}
	
	public void print()
	{
		System.out.println(crn + "\t" + name + "\t" + number);
	}
}
