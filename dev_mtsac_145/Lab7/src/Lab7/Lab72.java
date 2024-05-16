package Lab7;

import java.util.Scanner;

public class Lab72 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int age = scan.nextInt();
		System.out.print("Enter your height: ");
		int height = scan.nextInt();
		
		if(age >= 8 && height >= 120)
			System.out.println("Welcome! You are allowed to ride this rides.");
		else if(age < 8 && height < 120)
			System.out.println("You must be at least 8 years old and 120cm tall to ride this rides.");
		else if(height < 120)
			System.out.println("You must be at least 120cm to ride this rides.");
		else if (age < 8)
			System.out.println("You must be at least 8 years old to ride this rides.");
		
		scan.close();
	}
}
