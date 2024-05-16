package Lab4;

import java.util.Scanner;

public class lab42 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter one word: ");
		String word = scan.next(); 
		System.out.print("Enter one character to be replaced in the word: ");
		String character = scan.next(); 
		char firstcharacter = character.charAt(0); 
		System.out.print("Enter one character to be replace the old character: ");
		String character2 = scan.next(); 
		char replacecharacter = character2.charAt(0);
		int a = word.indexOf(firstcharacter);
		int b = word.length();
		String firstpart = word.substring(0, a) + replacecharacter + word.substring(a + 1, b);
		
		System.out.println(word + " ---> " + firstpart); 	
		scan.close(); 
		
	}
}
