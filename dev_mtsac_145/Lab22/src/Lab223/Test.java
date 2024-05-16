package Lab223;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args)
	{
		LinkedList<Login> sign = new LinkedList<Login>();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Filename: ");
		File file = new File(scan.next());
		
		if(file.exists())
		{
			try
			{
				scan = new Scanner(file);
				while(scan.hasNext())
				{
					String username = scan.next();
					String pass = scan.next(); 
					sign.add(new Login(username, pass)); 
				}
			}
			catch(IOException e) {}
		}
		
		for(int i = 0; i < sign.size(); i++)
		{
			System.out.println(sign.get(i));
		}
		
		System.out.println("==================================="); 
		
		boolean u = false; 
		boolean p = false;
		for(int i = 0; i < 3; i++)
		{
			scan = new Scanner(System.in); 
			System.out.print("Enter username: ");
			String user = scan.next();
			System.out.print("Enter password: ");
			String password = scan.next(); 
		
			for(int j = 0; j < sign.size(); j++)
			{
				if(user.equals(sign.get(j).getUsername()))
				{
					u = true; 
					if(password.equals(sign.get(j).getPassword())) {
						p = true; 
					}
					
				}	
				
			}
			if (u == true && p == true)
			{
				break; 
			}
			else if (u == false)
				System.out.println("No such id '" + user +"'"); 
			else if (p == false)
				System.out.println("Wrong Password!");
		}
		if(u == true && p == true) 	System.out.println("Login succeed!!");
		else
			System.out.println("Failed Three Times!");
	}
}
