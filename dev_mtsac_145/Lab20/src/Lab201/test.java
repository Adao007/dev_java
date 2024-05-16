package Lab201;

import java.util.Scanner;

public class test {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String input = ""; 
		
		System.out.println("Enter strings, enter DONE when finished: ");
		StringTooLongException counter = new StringTooLongException();
		
		try
		{
			int count = 0; 
			input = scan.nextLine();
			
			for(int i = 0; i < input.length() - 4; i++)
			{
				
				if(input.charAt(i) != ' ') 
					count++; 
			}
			
			if(count > 20)
				throw counter;
			else
				System.out.println("You entered: " + input);
		
		}
		catch(StringTooLongException e)
		{
			System.out.print("Exception in thread \"main\" ");
			e.printStackTrace(); 
		}

}
}
