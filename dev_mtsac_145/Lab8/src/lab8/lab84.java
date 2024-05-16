package lab8;

import java.util.Scanner;

public class lab84 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter count: ");
		int count = scan.nextInt();
		int max = 0;
		if (count <= 0)
		{
			System.out.println("No number will be inputted");
		}
		else
		{
			int countTwo = 1;
			while (count-- != 0)
			{
				System.out.print("Enter an integer #" + countTwo++ + " : ");
				int input = scan.nextInt();
				if (input > max) max = input;
			}
			System.out.print("Max number : " + max);
	}
}
}
