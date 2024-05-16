package in_class_follow2;

public class Rectangle {

	private int length;
	private int width;
	
	public Rectangle(int len, int wid){
		length = len;
		width = wid; 
	}
	
	public Rectangle() {
		System.out.println("Hello, I am called!!");
	}
	
	public void setLength(int len)
	{
		length = len; 
	}
	public void setWidth(int wid)
	{
		width = wid; 
	}
	public void print()
	{
		System.out.println("Length : " + length + " Width: " + width); 
	}
}
