package lab14;

public class lab142 {
	// takes string and Concats x times where x is c
	public static String multiConcat (String s, int c) 
	{
		String result = s;
		for(int i = 0; i < c; i++)
		{
			result += s; 
		}
		return result;
	}
	public static String multiConcat(String s) // concats string with itself
	{
		String result = s + s;
		return result; 
		
	}
	
	public static void main(String[] args)
	{
		String test = "Tony"; 
		
		String firstMethod = multiConcat(test, 4);
		String secondMethod = multiConcat(test);
		
		System.out.println(firstMethod);
		System.out.println(secondMethod);
		
		
	}
}
