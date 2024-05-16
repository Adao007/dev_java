package in_class_follow2;

import java.util.Scanner;

public class relation {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 1: ");
		int max = scan.nextInt();
	
		int count = 2;
		while(count <= 5)
		{
			System.out.print("Enter " + count++ + ": ");
			int test = scan.nextInt(); 
			if (test > max)
			{
				max = test;
			}
		}
		System.out.println("Max = " + max);
	}
}
