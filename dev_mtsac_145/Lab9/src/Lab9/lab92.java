package Lab9;

import java.util.Scanner;

public class lab92 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter an operator (+, - , *, /, %) : ");
		String sym = scan.next();
		System.out.print("Enter two integers: ");
		int first = scan.nextInt(); 
		int second = scan.nextInt(); 
		
		switch (sym)
		{
		case "+":
			System.out.println("===> " + first + " + " + second + " = " + ((int)first + second));
			break; 
		case "-":
			System.out.println("===> " + first + " - " + second + " = " + ((int)first - second));
			break; 
		case "*":
			System.out.println("===> " + first + " * " + second + " = " + ((int)first * second));
			break; 
		case "/":
			System.out.println("===> " + first + " / " + second + " = " + ((int)first / second));
			break; 
		case "%":
			System.out.println("===> " + first + " % " + second + " = " + ((int)first % second));
			break; 
		}
		scan.close();
	}
}
