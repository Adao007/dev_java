package Lab201;

public class StringTooLongException extends Exception{
	
	public StringTooLongException()
	{ }
	
	public String getMessage()
	{
		return "String has too many characters"; 
	}
}
