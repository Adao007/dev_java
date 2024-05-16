package lab15;

public class Receptionist extends Administrator{
	
	protected boolean answering;
	
	public Receptionist(String name, int number, String dept, boolean answering)
	{
		super(name, number, dept);
		this.answering = answering;
	}
	public void setisAnswering(boolean answering)
	{
		this.answering = answering;
	}
	public boolean getisAnswering()
	{
		return answering; 
	}
	public String toString()
	{
		return super.toString() + " Answering: " + answering;
	}
	public void answer()
	{
		if(answering)
		{
			System.out.println(this.name + " is answering the phone.");
		}
		else
			System.out.println(this.name + " is not answering the phone");
	}
}