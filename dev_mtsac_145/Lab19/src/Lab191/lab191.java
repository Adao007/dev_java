package Lab191;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class lab191 {
	public static void main(String[] args)
	{
		Random gen = new Random();
		int compRandom = gen.nextInt(100) + 1;
		Scanner scan = new Scanner(System.in); 
		int userGuess = 0;
		int count = 0;
		
		while(userGuess != compRandom) {

			try {
				System.out.print("Input one integer between 1 and 100 : ");
				userGuess = scan.nextInt();

				if (userGuess < compRandom) System.out.println("--> Enter a larger number");
				
				if(userGuess > compRandom)	System.out.println("--> Enter a smaller number");
	
				if(userGuess == compRandom) System.out.println("Good Job!");
			}
			catch(InputMismatchException e)
			{
				scan.next();
				System.out.println("***** Invaild input. Start over. *****");
				System.out.println();
			}
			
			count++;
		}
		
		System.out.println("You tried " + count + " times.");
	}
}
