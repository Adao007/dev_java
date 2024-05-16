import java.util.Scanner;

public class Lab24 {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in); //command + shift + O to get the import. 
		System.out.print("Enter one 4-digit integer : ");
		int x = scan.nextInt();
		int thousand = 1000; 
		int hundred = 100;
		int tens = 10;  
		
		System.out.println("thousands : " + x / thousand);
		x -= thousand * (x / thousand);
		System.out.println("hundreds  : " + x / hundred);
		x -= hundred * (x / hundred);
		System.out.println("tens \t  : " + x / tens);
		x -= tens * (x / tens); 
		System.out.println("ones \t  : " + x);
	
		scan.close(); 
	}
}
