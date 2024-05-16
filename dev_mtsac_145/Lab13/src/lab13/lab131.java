package lab13;

import java.text.DecimalFormat;

public class lab131 {

	public static void main (String[] args)
	{
		Point p1 = new Point(3, 4);
		Point p2 = new Point(4, 3); 
		
		double distance = PointUsage.getDistance(p1, p2); 
		
		DecimalFormat df = new DecimalFormat("0.###"); 
		System.out.println("p1 : " + p1);
		System.out.println("p2 : " + p2); 
		System.out.println("distance between p1 and p2 : " + df.format(distance)); 
	}
}
