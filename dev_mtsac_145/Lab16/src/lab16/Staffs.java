package lab16;

public class Staffs extends Person{
	private String title;
	private int career; 
	
	public Staffs(String id, String name, String email, String title, int career)
	{
		super(id, name, email);
		this.title = title;
		this.career = career;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	public void setCareer(int career)
	{
		this.career = career;
	}
	public String getTitle()
	{
		return title;
	}
	public int getCareer()
	{
		return career;
	}
	public String toString()
	{
		return super.toString() + "   " + title + " " + career; 
	}
}
