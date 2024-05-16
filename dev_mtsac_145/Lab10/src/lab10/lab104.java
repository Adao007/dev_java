package lab10;

import java.util.Random;
import java.util.Scanner;

public class lab104 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		while (true)
		{
			Random gen = new Random(); 
			int first = gen.nextInt(10);
			int second = gen.nextInt(10);
			int third = gen.nextInt(10);
			
			System.out.println(first + " " + second + " " + third);
			if (first == second && first == third && second == third)
			{
				System.out.println("Jackpot!!!!");
			}
			else if (first == second || first == third || second == third)
			{
				System.out.println("Matched 2!!");
			}
			
			System.out.println("Play again (y/n)?: ");
			char ans = scan.next().charAt(0);
			if (ans == 'n') break;
		}
	}
}
