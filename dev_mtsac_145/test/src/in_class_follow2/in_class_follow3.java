package in_class_follow2;

import java.util.Random;

public class in_class_follow3 {

	public static void main(String[] args)
	{
		String name = new String ("Anthony Dao");
		String firstname = new String("Anthony");
		String lastname = new String("Dao"); 
		System.out.println(name); 
		
		System.out.println("His first name is " + firstname + '.');
		System.out.println("His last name is " + lastname + '.'); 
		
		firstname = ("Darth");
		lastname = ("Tonest");
		
		System.out.println("After his dark descent and plege to the dark lord... " 
					+ "His name is now... \n" + firstname + ' ' + lastname + '.'); 
		
		int characters = name.length(); 
		System.out.println("Yo how long is his name? : " + characters + " letters long."); 
		
		Random gen = new Random(); 
		int n = gen.nextInt(); 
		System.out.println("n : " + n); 
		
	}
}
