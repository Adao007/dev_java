package Lab4;

import java.util.Random;
import java.util.Scanner; 

public class Lab41 {

	public static void main(String[] args)
	{
		Random gen = new Random();
		int random = gen.nextInt(90) + 10; 
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your first name: "); 
		String firstname = scan.next();
		System.out.print("Enter your last name: ");
		String lastname = scan.next(); 
		
		System.out.println(firstname.charAt(0) + lastname.substring(0, 5) + random);
		scan.close();
	}
}
