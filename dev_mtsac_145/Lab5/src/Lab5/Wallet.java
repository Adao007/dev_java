package Lab5;

public class Wallet {
 
	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies; 
	
	public Wallet(int q, int d, int n, int p)
	{
		quarters = q;
		dimes = d;
		nickels = n;
		pennies = p;
	}
	
	public void amount()
	{
		double amount; 
		amount = (quarters * 0.25) + (dimes * 0.10) + (nickels + 0.05) + (pennies + 0.01);
		System.out.println("Number of Quarters: " + quarters);
		System.out.println("Number of Dimes " + dimes);
		System.out.println("Number of Nickels " + nickels);
		System.out.println("Number of pennies " + pennies); 
		System.out.println("Amount : $" + amount); 
	}
	
	public void updateAll(int q, int d, int n, int p)
	{
		quarters = q;
		dimes = d;
		nickels = n;
		pennies = p;
	}
}
