package Lab6;

public class Dog {
	private String name;
	private int age; 
	
	public Dog(String n, int a)
	{
		name = n;
		age = a;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setAge(int a)
	{
		age = a;
	}
	
	public int humanAge()
	{
		return age * 7; 
	}
	
	public String toString()
	{
		return "Dog: " + name + "\tAge: " + age + "\tPerson-Years: " + humanAge(); 
	}
}
