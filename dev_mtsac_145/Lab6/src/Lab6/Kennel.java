package Lab6;

public class Kennel {
	public static void main(String[] args)
	{
		Dog d1 = new Dog("Spot" , 4);
		Dog d2 = new Dog("Fluffy", 1);
		Dog d3 = new Dog("Killer", 7);
		Dog d4 = new Dog("King Tut", 3);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		System.out.println(d4);
		System.out.println("Happy Birthday, Killer"); 
		System.out.println("You are now " + (d3.humanAge() + 7) + " years old in person-years." );
	}
}
