package Lab231;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
	public static void main(String[] args)
	{
		HashSet<Customer> set = new HashSet<> ();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter filename: ");
		File file = new File(scan.next());
		
		if(file.exists())
		{
			try
			{
				scan = new Scanner(file);
				while(scan.hasNext())
				{
					int id = scan.nextInt();
					String first = scan.next();
					String last = scan.next();
					float balance = scan.nextFloat();
				
					set.add(new Customer(id, first, last, balance));
				}
			}
			catch(IOException e) {}
		}
		
	Iterator iter = set.iterator(); 
	while (iter.hasNext())
	{
		System.out.println(iter.next());
	}
		
	}
}
