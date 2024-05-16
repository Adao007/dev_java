package Lab18;

import java.text.DecimalFormat;

public class ShapeTest {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0.##");
		
		Rectangle rec1 = new Rectangle(2, 7);
		System.out.println("rec1's dimension : " + rec1);
		System.out.println("the area of rec1 : " + df.format(rec1.area()));
		System.out.println("the perimeter of rec1 : " + df.format(rec1.perimeter()));
		
		Rectangle rec2 = new Rectangle(2, 6);
		System.out.println("\nrec2's dimension : " + rec2);
		System.out.println("the area of rec : " + df.format(rec2.area()));
		System.out.println("the perimeter of rec : " + df.format(rec2.perimeter()));
		
		if (rec1.equals(rec2)) System.out.println("\nrec1 and rec2 has the same dimensions");
		else System.out.println("\nrec1 and rec2 has different dimensions");
		
		System.out.println("--------------------------------------------");
		Circle cir1 = new Circle(5);
		System.out.println("cir1's radius : " + cir1);
		System.out.println("the area of cir1 : " + df.format(cir1.area()));
		System.out.println("the perimeter of cir1 : " + df.format(cir1.perimeter()));
		
		Circle cir2 = new Circle(5);
		System.out.println("\ncir2's dimension : " + cir2);
		System.out.println("the area of cir2 : " + df.format(cir2.area()));
		System.out.println("the perimeter of cir2 : " + df.format(cir2.perimeter()));
		
		if (cir1.equals(cir2)) 
			System.out.println("\ncir1 and cir2 has the same radius");
		else 
			System.out.println("\ncir1 and cir2 has different radius");
		}
}
