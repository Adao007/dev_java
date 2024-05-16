package lab10;

import java.util.Scanner;

public class lab101 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = scan.nextInt(); 
		int number = 1;
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j <= i; j++)
			{
				System.out.printf(number + "  ");
				number++;
				
			}
			System.out.println();
		}
		scan.close();
	}
}
