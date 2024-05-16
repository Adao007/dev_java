package lab13;

public class Customer {

	public static int count;
	private int accountNo;
	private String name;
	private double Balance;
	
	public Customer (int accountNo, String name) // constructor 
	{
		this.accountNo = accountNo;
		this.name = name;
	}
	public Customer (int accountNo, String name, double Balance) // constructor
	{
		this(accountNo, name);
		this.Balance = Balance; 
	}
	public void setAccountNo(int accountNo) // sets account number
	{
		this.accountNo = accountNo;
	}
	public void setName(String name) // set name
	{
		this.name = name; 
	}
	public void setBalance (double Balance) // set balance
	{
		this.Balance = Balance; 
	}
	public static void incrementCount() //inc count
	{
		count++;
	}
	public int getAccountNo() // return account number
	{
		return accountNo;
	}
	public String getName() // returns name
	{
		return name;
	}
	public double getBalance() // returns balance
	{
		return Balance;
	}
	public static int getCount() // returns count
	{
		return count;
	}
	public void changeBalance(double Balance) // adds input into balance
	{
		this.Balance += Balance;
	}
	public String toString () //toString method
	{
		return "Account No : " + accountNo + "\n" + "Customer name : " + name + "\n" + 
				"Balance : " + Balance; 
	}
}
