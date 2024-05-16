package lab14;

public class lab141 {
	// shifts the first char in String to end
	public static void shiftLeft (String shift)
	{
		String result = ""; 
		
		result = shift.substring(1, shift.length()) + shift.charAt(0); 
		
		System.out.println("original: " + shift);
		System.out.println("shifted: " + result);
	}
	
	public static void main(String[] args)
	{
		String test = "programming";
		shiftLeft(test); 
	}
}
