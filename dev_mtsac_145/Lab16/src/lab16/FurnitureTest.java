package lab16;

public class FurnitureTest {
	public static void main(String[] args)
	{
		Furniture f1 = new Furniture("table", "blue", 5);
		Furniture f2 = new Furniture("chair", "white", 1);
		Furniture f3 = new Furniture("table", "black", 5);
		Furniture f4 = new Furniture("table", "blue", 5);
		Furniture f5 = new Furniture("chair", "white", 2);
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		System.out.println(f5);
		System.out.println("------------------------");
		if (f1.equals(f3)) System.out.println("f1 and f3 are equal");
		else System.out.println("f1 and f3 are not equal");
		if (f1.equals(f4)) System.out.println("f1 and f4 are equal");
		else System.out.println("f1 and f4 are not equal");
		if (f2.equals(f5)) System.out.println("f2 and f5 are equal");
		else System.out.println("f2 and f5 are not equal");
	}
}
