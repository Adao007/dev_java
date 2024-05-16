package test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class test2 {
	public static void main(String[] args)
	{
		int a = 5, b = 0, c; 
		int guess = 0; 
		try {
			c = a / b; 
			System.out.println("c : " + c); 
		}
		catch(ArithmeticException e)
		{
			System.out.println("There was an exception throw!"); 
		}
		
		System.out.println("Enter a number (1 ~ 100): ");
		Scanner scan = new Scanner(System.in);
		while(guess != 101) {
			try {
				guess = scan.nextInt();
				System.out.println("Your guess is " + guess); 
			}
			catch(InputMismatchException e)
			{
				scan.next(); // refreshes the reader! 
			}
		}
		
	}
}
