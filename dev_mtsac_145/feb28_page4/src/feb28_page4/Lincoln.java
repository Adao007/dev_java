/* When you have a long comment then your can use this way to write down your notes
 * 
 */


package feb28_page4;

public class Lincoln {

	public static void main(String[] args) 
	{
		int count = 10; 
		
		System.out.println("a quote by Abraham Lincoln:");
		//System.out is a class & println is a method 
		System.out.println("Whatever you are, be a good one.");
		//there is print and println (the ln works the same way that endl in c++) 
		System.out.print("This line will not skip a line"); 
		System.out.print(" *** this is so messy *** ");
		System.out.println("The next line will skip a line"); 
		System.out.println("You see this line is on the next line"); 
		//if you have a long message, you can + the two quotes together
		//The " " must be on the same line otherwise you will get an error. 
		System.out.println("This is a long message and you will need to use " 
							+ "plus symbol to connect the two lines together"); 
		//if you want to have an extra line you can use the following
		System.out.println(); // it is like press enter 
		System.out.println("There is two lines above me"); 
		System.out.println(count); 
							
		//At this point you have gone thru 2.1 & 2.2 
	}
}
