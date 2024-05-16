package lab8;

import java.util.Scanner;

public class lab83 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter one integer: ");
		int integer = scan.nextInt();
		if (integer <= 0)
		{
			System.out.print("Please enter a positive integer.");
		}
		else
		{
			if (isPrime(integer))
			{
				System.out.println(integer + " is a prime.");
			}
			else System.out.println(integer + " is not a prime.");
		}
	}
	private static boolean isPrime(int i)
	{
		int count = 5;
		if (i == 2 || i == 3)
		{
			return true;
		}
		if (i <= 1 || i % 2 == 0 || i % 3 == 0)
		{
			return false;
		}
		else 
		{
			while (count * count <= i) {
				if (i % count == 0 || i % (count + 2) == 0)
				{
					return false;
				}
				count += 6;
			}
		}
		return true;
	}
}
