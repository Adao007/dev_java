package lab192;

public class book {
	private int code;
	private String title;
	private int price; 
	
	public book(int code, String title, int price)
	{
		this.code = code;
		this.title = title;
		this.price = price; 
	}
	
	public int getCode()
	{
		return this.code;
	}
	public String getTitle()
	{
		return this.title;
	}
	public int getPrice()
	{
		return this.price;
	}
	
	public boolean equals(Object obj)
	{
		if(this.code == ((book)obj).code && this.title.equals(((book)obj).title) 
						&& this.price == ((book)obj).price)
			return true;
		else
			return false;
	
	}
	
	public String toString()
	{
		return String.format("[%1d] %20s $%2d", code, title, price); 
	}
}
