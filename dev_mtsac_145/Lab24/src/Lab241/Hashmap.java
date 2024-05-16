package Lab241;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hashmap {
	static public void main(String[] args)
	{
		HashMap<String, String> map = new HashMap<>(); 
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter name of file: "); 
		File file = new File(scan.next());
		
		if(file.exists())
		{
			try
			{
				scan = new Scanner(file);
				while (scan.hasNext())
				{
					String name = scan.next();
					String password = scan.next();
					
					map.put(name, password);
				}
			}
			catch(IOException e) {}
		}
		System.out.println(String.format("%15s %15s", "ID", "PASSWORD"));
		System.out.println("------------------------------------------------------"); 
		
		for( Map.Entry<String, String> e : map.entrySet() ) {
			String key = e.getKey();
			String value = e.getValue();
			System.out.println(String.format("%15s %15s", key, value));
			
		}
	}
}
