package lab8;

import java.util.Scanner;

public class lab81 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter one integer: ");
		int integer = scan.nextInt(); 
		if(integer < 0)
		{
			System.out.print("Please enter 0 or positive integer.");
		}
		else
		{
			factorial(integer);
		}
	}
	
	private static void factorial(int pos)
	{
		int update = 1;
		System.out.print(pos + "! = ");
		while (pos > 0)
		{
			update *= pos--; 
		}
		System.out.print(update);
	}
}
