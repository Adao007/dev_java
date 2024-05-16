package lab10;

import java.util.Scanner;

public class lab102 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = scan.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			for(int j = n; j >= i; j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
