package helloworld;

public class Hello {
	
	public static void main(String[] args)
	{
		
		int thisIsValue = 10;
		final int NEVER_TO_CHANGE = 1000; 
		
		System.out.println("This statement plus a number, "
				+ "will make the number into a string " + (180 + 180)); 
		
		System.out.println("There is an order of operations with the strings and numbers."); 
		
		System.out.println("And so we begin our study of \"escape sequences\"."); 
		System.out.println("The most important escape sequences mentioned by the proffessor is "
				+ "escape sequences that are for tab, quotes, newline, and backslash."); 
		System.out.println("The symbols for the tab is (\\t).");
		System.out.println("The symbol for the newline is (\\n)"); // is it more effective to use an \n or println?
		System.out.println("The symbol for the double quote is (\\\")"); 
		System.out.println("The symbol for the backslash is (\\\\)");
		System.out.println();
		System.out.println("In 1987, Tony began his study of Computer Science. And by his own hands perished in 1989; "
				+ "similarly, Anthony began his study of CS in 1991.\nHe also perished akin to Tony in 1992."
				+ " And now we must begin our study of CS..."); 
		
		System.out.println(); 
		System.out.println("When the night was young but dark against the foul stetch of blood,\n"
				+ "\t you wander forward. With fear in your heart, you search for eyes.\n"
				+ "\t Granted by Kos (some say Kosm). They seek with fool's intent.\n"
				+ "\t Never to find the truth if eyes remain outwards.\n");
		
		System.out.println("\"Thank you for letting into your home\nIt is a lovely night with the"
				+ " moonlight \nshining against your fair skin...\"");
		
		System.out.println(thisIsValue + thisIsValue + NEVER_TO_CHANGE);
	}
	
}