package Lab6;

public class SphereTest {
	public static void main(String[] args)
	{
		Sphere s1 = new Sphere(4.75);
		Sphere s2 = new Sphere(20.0);
		Sphere s3 = new Sphere(11.946);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		s1.setDiameter(s1.getDiameter() + 2);
		s2.setDiameter(s2.getDiameter() + 2);
		s3.setDiameter(s3.getDiameter() + 2);
		
		System.out.println("---------------------------------------------");
		System.out.println("Increase each diameter by 2");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
	}
}
