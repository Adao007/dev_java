package Lab6;

public class CarTest {
	public static void main(String[] args)
	{
		Car c1 = new Car("Ford", "Taurus", 2007);
		Car c2 = new Car("Honda", "Odyssey", 2011);
		Car c3 = new Car("Toyota", "Corolla", 1999);
		Car c4 = new Car("Ford", "Mustang", 1966); 
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		
		c1.setModel("Explorer");
		c2.setYear(2010);
		c3.setMake("Nissan");
		c3.setModel("Maxima");
		
		System.out.println();
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
				
	}
}
