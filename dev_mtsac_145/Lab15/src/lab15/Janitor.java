package lab15;

public class Janitor extends Administrator{
	
	protected boolean sweeping;
	
	public Janitor(String name, int number, String dept, boolean sweeping)
	{
		super(name, number, dept);
		this.sweeping = sweeping;
	}
	public void setisSweeping(boolean sweeping)
	{
		this.sweeping = sweeping;
	}
	public boolean getisSweeping()
	{
		return sweeping; 
	}
	public String toString()
	{
		return super.toString() + " Sweeping: " + sweeping;
	}
	public void sweep()
	{
		if(sweeping)
		{
			System.out.println(this.name + " is sweeping the floor.");
		}
		else 
			System.out.println(this.name + " is not sweeping the floor.");
	}
}
