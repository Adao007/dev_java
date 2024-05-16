package test;

public class thrower {
	public static void makeArray() throws ArrayIndexOutOfBoundsException //if this method has this problem then main must handle the exception
	{
	int A[] = new int[3]; 
	A[0] = 10; 
	A[1] = 20; 
	A[2] = 30; 
	A[3] = 40; 	//ArrayIndexOutOfBoundsExeption occurs
	A[4] = 50;  
	}
	
	public static void main(String[] args)
	{
		System.out.println("Main Starts"); 
		try {
			makeArray();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("You know why its wrong you fool! Btw: " + e.getMessage());
		}
		System.out.println("main ends");
	}
}
