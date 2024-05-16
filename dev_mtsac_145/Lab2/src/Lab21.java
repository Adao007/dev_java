import java.util.Scanner;

public class Lab21 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); //command + shift + O to get the import. 
		System.out.print("What is your name? ");
		String name = scan.next();
		System.out.print("How old are you? "); 
		String age = scan.next();
		System.out.print("What college do you attend? ");
		String college = scan.next(); 
		System.out.print("What is your pet's name? "); 
		String pet = scan.next(); 
		
		System.out.println(); 
		System.out.println("Hello my name is " + name + " and I am "
				+ age + "years\nold. I'm enjoying my time at " + 
				college + ", though\nI miss my pet " + pet + "very much!"); 
		scan.close(); // you need to close the connection. 

	}
}
