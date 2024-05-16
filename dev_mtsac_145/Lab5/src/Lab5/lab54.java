package Lab5;

import java.text.DecimalFormat;
import java.util.Scanner;

public class lab54 {
	
	public static void main(String[] args){
		
	DecimalFormat df = new DecimalFormat("0.####");
	Scanner scan = new Scanner (System.in);
	System.out.print("Enter a value for a: ");
	int a = scan.nextInt();
	System.out.print("Enter a value for b: ");
	int b = scan.nextInt();
	System.out.print("Enter a value for c: ");
	int c = scan.nextInt();
	double firstpart = Math.sqrt(Math.pow(b, 2) - 4 * a * c); 
	
	double firstX = ((-b) + firstpart) / (2 * a);
	double secondX = ((- b) - firstpart) / (2 * a);
 
	System.out.println("The roots are " + firstX + " and " + secondX); 
	}
}
