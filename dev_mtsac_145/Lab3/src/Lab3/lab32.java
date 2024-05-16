package Lab3;

import java.util.Scanner;

public class lab32 {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); 
		System.out.print("Enter seconds: ");
		int seconds = scan.nextInt(); 
		int printSecs = seconds; 
		int hours = seconds / 3600;
		seconds %= 3600; 
		int minutes = seconds / 60; 
		seconds %= 60; 
		System.out.println(printSecs + " == " + hours + "h " 
							+ minutes + "m " + seconds + "s"); 
		scan.close(); 
		
	}
}
