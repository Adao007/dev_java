package lab14;

public class Calculator {
	
	private static int plusSum; 
	private static int minusSum; 
	private static int total = 0;
	
	public Calculator () { }; 
	
	public static void plus (int a, int b) // adds a and b together
	{
		plusSum = a + b;
	}
	
	public static int plusResult() // returns plusSum
	{
		return plusSum;
	}
	
	public static void minus(int a, int b) // subs a and b together
	{
		minusSum = a - b;
	}
	
	public static int minusResult() // returns minusSum
	{
		return minusSum;
	}
	
	public static void plus(int a) // adds input to total
	{
		total += a;
	}
	
	public static int total() //returns total
	{
		return total;
	}
	
	public static void minus(int a) // subs input with total
	{
		total -= a;
	}
}
