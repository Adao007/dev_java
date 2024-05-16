package lab13;

public class Point {
	private int xcoord; 
	private int ycoord; 
	
	public Point (int xcoord, int ycoord) // constructor
	{
		this.xcoord = xcoord;
		this.ycoord = ycoord; 
	}
	
	public void setXcoord (int xcoord) // set x coordinates
	{
		this.xcoord = xcoord;
	}
	
	public void setYcoord(int ycoord) // set y coordinates 
	{
		this.ycoord = ycoord; 
	}
	
	public int getXcoord () // return x
	{
		return xcoord; 
	}
	
	public int getYcoord() // return y
	{
		return ycoord; 
	}
	
	public String toString() // toString method for print
	{
		return "The xcoord is " + xcoord + " and the ycoord is " + ycoord; 
	}
}
