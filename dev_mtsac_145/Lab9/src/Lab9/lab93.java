package Lab9;

import java.util.Scanner;

public class lab93 {
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
		
		while(true) {
			System.out.print("One more time? (y/n): ");
			char ans = scan.next().charAt(0);
			if (ans == 'n') 
				break;
			else 
			{
				System.out.print("Enter an operator (+, - , *, /, %) : ");
				sym = scan.next();
				System.out.print("Enter two integers: ");
				first = scan.nextInt(); 
				second = scan.nextInt(); 
				
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
			}
		}
	}
}

