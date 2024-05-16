package Lab7;

import java.util.Scanner;

public class lab74 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter id: ");
		String id = scan.next(); 
		System.out.print("Enter password: ");
		String password = scan.next();
		
		if (id.equals("mtsac") && password.equals("computer"))
			System.out.println("Welcome!!");
		else if ((!id.equals("mtsac") && !password.equals("computer")))
				System.out.println("Wrong id and password!!");
		else if (!(id.equals("mtsac")))
			System.out.println("Wrong id!!");
		else if(!(password.equals("computer")))
			System.out.println("Wrong password!!"); 

		
		scan.close();
		
			
		
	}
}
