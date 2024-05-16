package lab10;

import java.util.Scanner;

public class lab103 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first integer a : ");
		int first = scan.nextInt();
		System.out.print("Enter the second integer b: ");
		int second = scan.nextInt(); 
		System.out.print("pow(" + first + ", " + second + ") = ");
		int temp = first;
		do 
		{
			first = first * temp;
			second--;
		}
		while(second > 1);
		
		System.out.print(first);
	}
}
