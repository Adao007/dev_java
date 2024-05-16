package Lab5;

public class Movie {

	private String name;
	private String direct;
	private int year; 
	
	public Movie(String n, String d, int yr)
	{
		name = n;
		direct = d;
		year = yr; 
	}
	
	public void print()
	{
		System.out.println("title\t: " + name + "\ndirector: " 
				+ direct + "\nyear\t: " + year);
	}
}
