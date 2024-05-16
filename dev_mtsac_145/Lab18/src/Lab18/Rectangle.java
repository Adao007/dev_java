package Lab18;

public class Rectangle implements Shape {
	private int height;
	private int width; 
	
	public Rectangle (int width, int height)
	{
		this.width = width;
		this.height = height; 
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	public void setHeight(int height)
	{
		this.height = height; 
	}
	
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		return width; 
	}
	
	public double area()
	{
		return height * width; 
	}
	
	public double perimeter()
	{
		return (height *  2) + (width * 2);
	}
	
	public String toString()
	{
		return "width (" + width + ") and height (" + height + ")";
	}
	
	public boolean equals(Object obj)
	{
		if (this.height==((Rectangle)obj).height && this.width == ((Rectangle)obj).width) 
			return true;
		else
			return false;
	}	
}
