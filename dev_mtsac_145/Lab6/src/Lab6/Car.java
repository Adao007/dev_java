package Lab6;

public class Car {
	private int year;
	private String make;
	private String model; 
	
	public Car(String maker, String m, int y)
	{
		make = maker; 
		model = m;
		year = y; 
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public void setYear(int y)
	{
		year = y;
	}
	
	public void setMake(String m)
	{
		make = m;
	}
	
	public void setModel(String m)
	{
		model = m; 
	}
	
	public String toString() {
		return year + " " + make + " " + model;
	}
}
