package Lab3;

import java.util.Scanner;

public class lab33 {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter celsius temperature: ");
		double celTemp = scan.nextDouble(); 
		double fahrenheit = ((double)9 / 5) * celTemp + 32; 
		
		System.out.println("Celsius Temperature: " + celTemp); 
		System.out.println("Fahrenheit Equivalent " + fahrenheit); 
		scan.close();
		
	}
}
