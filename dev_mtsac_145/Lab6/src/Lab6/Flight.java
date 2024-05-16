package Lab6;

public class Flight {
	private String airline;
	private String origin;
	private String des;
	private int number; 
	
	public Flight(String a, String o, String d, int n)
	{
		airline = a;
		origin = o;
		des = d;
		number = n; 
	}
	
	public String getAirline()
	{
		return airline;
	}
	
	public String getOrigin()
	{
		return origin;
	}
	
	public String getDes()
	{
		return des;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public void setAirline(String a)
	{
		airline = a; 
	}
	public void setOrigin(String o)
	{
		origin = o;
	}
	
	public void setDes(String d)
	{
		des = d;
	}
	
	public void setNumber(int n)
	{
		number = n; 
	}
	
	public String toString()
	{
		return airline + " " + number + " --  From: " + origin + ", To: " + des;
	}
}
