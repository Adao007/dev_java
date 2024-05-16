package lab13;

public class PointUsage {
	public static double getDistance (Point p1, Point p2) // calculates the distance between two points
	{
		double x1 = p1.getXcoord();
		double x2 = p2.getXcoord(); 
		double y1 = p1.getYcoord();
		double y2 = p2.getYcoord(); 
		
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)); 
	}
}
