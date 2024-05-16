package test;

public class MyException extends Exception {
	private int x; 
	public MyException(int x)
	{
		this.x = x; 
	}
	
	public String toString()
	{
		return "I am " + x + " in MyException class";
		
	}
} 


