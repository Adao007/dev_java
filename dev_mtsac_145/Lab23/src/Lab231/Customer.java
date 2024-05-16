package Lab231;

import java.util.Objects;

public class Customer {
	private int id; 
	private String first_name; 
	private String last_name;
	private float balance; 
	
	public Customer(int id, String first_name, String last_name, float balance)
	{
		this.id = id;
		this.first_name = first_name; 
		this.last_name = last_name; 
		this.balance = balance; 
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return id + first_name.hashCode() + last_name.hashCode() + (int)balance; 
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer)
		{
			Customer temp = (Customer)obj; 
			return id == temp.id && first_name.equals(temp.first_name) && last_name.equals(temp.last_name)
					&& balance == temp.balance; 
		}
		return false; 
	}
	
	public String toString()
	{
		return String.format("%1s %3s (%1d) - $%.2f", first_name, last_name, id, balance); 
	}
	
	
}
