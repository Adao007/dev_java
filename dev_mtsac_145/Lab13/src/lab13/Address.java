package lab13;

public class Address {
	private String streetAddress;
	private String city;
	private String state;
	private long zipCode;
	
	public Address(String street, String town, String st, long zip) // constructor
	{
		streetAddress = street;
		city = town;
		state = st;
		zipCode = zip;
	}
	
	public String toString() // toString method
	{
		String result;
		
		result = streetAddress + "\n";
		result += city + ", " + state + " " + zipCode;
		
		return result;
	}
}
