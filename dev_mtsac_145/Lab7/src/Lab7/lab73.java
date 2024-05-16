package Lab7;

import java.util.Scanner;

public class lab73 {

	public class Main{
		static void isValid(int s1, int s2, int s3)
		{
			if (s1 + s2 > s3)
				System.out.println("The three sides (" + s1 + ", " + s2 + ", " + s3 + ") \"can\" make a triangle.");
			else
				System.out.println("The three sides (" + s1 + ", " + s2 + ", " + s3 + ") \"cannot\" make a triangle.");
		}
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter side 1: ");
		int side1 = scan.nextInt();
		System.out.print("Enter side 2: ");
		int side2 = scan.nextInt();
		System.out.print("Enter side 3: ");
		int side3 = scan.nextInt();
		
		isValid(side1, side2, side3);
		scan.close();
		
		
	}
	private static void isValid(int s1, int s2, int s3) {
		if (s1 + s2 > s3)
			System.out.println("The three sides (" + s1 + ", " + s2 + ", " + s3 + ") \"can\" make a triangle.");
		else
			System.out.println("The three sides (" + s1 + ", " + s2 + ", " + s3 + ") \"cannot\" make a triangle.");
		
	}
	
	
	
}
