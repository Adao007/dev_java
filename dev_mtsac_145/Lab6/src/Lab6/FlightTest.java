package Lab6;

public class FlightTest {

	public static void main(String[] args)
	{
		Flight f1 = new Flight("US Air", "Boston", "Los Angeles", 347);
		Flight f2 = new Flight("Delta", "Philadelphia", "London", 212);
		Flight f3 = new Flight("Continental", "Atlanta", "Chicago", 822);
		
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		
		f1.setAirline("Anthony's Air");
		f2.setDes("Pomona");
		f3.setNumber(3003);
				
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
	}
}
