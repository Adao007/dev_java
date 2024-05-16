package lab16;

public class Furniture {
	private String type;
	private String color;
	private int number; 
	
	public Furniture(String type, String color, int number)
	{
		this.type = type;
		this.color = color;
		this.number = number;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public String getType()
	{
		return type;
	}
	public String getColor()
	{
		return color;
	}
	public int getNumber()
	{
		return number;
	}
	
	public String toString()
	{
		if(number == 1)
			return "There is " + number + " " + color + " " + type;
		else 
			return "There are " + number + " " + color + " " + type;
	}
	
	public boolean equals(Object obj)
	{
		if (this.type.equals(((Furniture)obj).type) && this.color.equals(((Furniture)obj).color) && this.number ==((Furniture)obj).number)
			return true;
		else
			return false;
	}
}
