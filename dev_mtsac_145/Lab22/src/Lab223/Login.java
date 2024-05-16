package Lab223;

public class Login {
	private String username;
	private String password; 
	
	public Login(String username, String password)
	{
		this.username = username; 
		this.password = password; 
	}
	
	public String getUsername()
	{
		return this.username; 
	}
	public String getPassword()
	{
		return this.password;
	}
	public String toString()
	{
		return String.format("%20s %20s ", username, password); 
	}
	
	

}
