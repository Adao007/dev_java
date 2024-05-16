package lab8;

import java.util.Scanner;

public class lab82 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter one integer: ");
		int integer = scan.nextInt();
		
		if (integer <= 0)
		{
			System.out.println("Please enter a positive integer.");
		}
		else
		{
			fibonacci(integer);
		}
	}
	private static void fibonacci(int i)
	{
		int count = 3; 
		int firstNumber = 0;
		int secondNumber = 1;
		int store = 0;
		if (i == 1)
		{
			System.out.print("fibonacci(" + i + ") = " + firstNumber);
		}
		else
		{
			while (count++ <= i)
			{
				store = secondNumber;
				secondNumber += firstNumber; 
				firstNumber = store;
			
			}
			System.out.print("fibonacci(" + i + ") = " + secondNumber);
		}
}
}
