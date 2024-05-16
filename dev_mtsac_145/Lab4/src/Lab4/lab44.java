package Lab4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class lab44 {
	public static void main(String[] args)
	{
		DecimalFormat df = new DecimalFormat("0.###");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first coordinates: ");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.print("Enter the second coordinates: ");
		int c = scan.nextInt();
		int d = scan.nextInt();
		double number = Math.sqrt(Math.pow((c - a), 2) + Math.pow((d - b), 2)); 
		String numberPrint = df.format(number);
		System.out.println("The distace between ( " + a + ',' + b + " ) and ( " + c + "," + d
				+ " )" + "is " +  numberPrint);
		scan.close();
	}


}
