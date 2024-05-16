package Lab18;


public class Circle implements Shape{
	private static int radius; 
	
	public Circle(int radius)
	{
		this.radius = radius; 
	}
	
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	
	public int getRadius()
	{
		return radius; 
	}
	
	public double area()
	{
		return Math.PI * Math.pow(radius, 2); 
	}
	
	public double perimeter()
	{
		return 2 * Math.PI * radius; 
	}
	
	public String toString()
	{
		return "radius (" + radius + ")";
	}
	
	public boolean equals(Object obj)
	{
		if (this.radius==((Circle)obj).radius) 
			return true;
		else
			return false;
	}	
	
}
