package Lab3;

import java.util.Scanner;

public class lab34 {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter fahrenheit temperature: ");
		int fahrenheit = scan.nextInt();
		double celsius = ((double)fahrenheit - 32) * ((double) 5 / 9);
		System.out.println("Fahrenheit Equivalent: " + (double) fahrenheit);
		System.out.println("Celsius Temperature: " + celsius);
		scan.close();
				
	}
}
