package lab13;

public class CustomerTest {
	public static void main(String[] args)
	{
		Customer c1 = new Customer (1000, "Steve"); //balance is 0
		Customer.incrementCount(); // increment count by 1
		Customer c2 = new Customer (1100, "Cindy", 200.0);
		Customer.incrementCount();
		
		System.out.println(c1);
		System.out.println("--------------------");
		System.out.println(c2);
		System.out.println("--------------------");
		System.out.println();
		
		System.out.println("After changing balances");
		System.out.println("=========================");
		c1.changeBalance(136.50);
		System.out.println(c1);
		System.out.println("--------------------");
		c2.changeBalance(-29.50);
		System.out.println(c2);
		System.out.println("--------------------");
		
		System.out.println("\nThere are " + Customer.getCount() + " customers.");
		
	}
}
