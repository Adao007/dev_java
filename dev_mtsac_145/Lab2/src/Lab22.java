import java.util.Scanner;

public class Lab22 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); //command + shift + O to get the import. 
		System.out.print("Enter x : ");
		int x = scan.nextInt();
		int y = (2 * (x * x) + ( 3 * x) + 1); 
		System.out.println("y = " + y + ", when x = " + x);  
		scan.close(); // you need to close the connection. 

	}
}
