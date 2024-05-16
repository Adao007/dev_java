package Lab3;

import java.util.Scanner;

public class lab3 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of hours: ");
		int hours = scan.nextInt(); 
		System.out.print("Enter the number of minutes: "); 
		int minutes = scan.nextInt(); 
		System.out.print("Enter the number of seconds: ");
		int seconds = scan.nextInt(); 
		
		hours *= 3600; 
		minutes *= 60; 
		System.out.println("Total seconds: " + (seconds + hours + minutes)); 
		scan.close(); 
	}
}
