package Lab7;

import java.util.Scanner;

public class Lab71 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter today's temperature: ");
		int temp = scan.nextInt(); 
		
		if (temp <= 50)
		{
			System.out.println("It is cool.");
			System.out.println("Dress warmly.");
		}
		else if (temp > 80)
		{
			System.out.println("It is warm.");
			System.out.println("Dress coolly.");
		}
		else
		{
			System.out.println("It is pleasant.");
			System.out.println("Dress pleasantly.");
		}
		scan.close();
	}
}
