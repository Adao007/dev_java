import java.util.Scanner;

public class Lab23 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); //command + shift + O to get the import. 
		System.out.print("Enter radius : ");
		int radius = scan.nextInt();
		
		double perimeter = 2 * 3.14159 * radius; 
		double area = 3.14159 * (radius * radius);
		
		System.out.println("Perimeter = " + perimeter); 
		System.out.println("Area = " + area); 
	}
}
