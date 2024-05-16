package Lab211;


import java.util.Scanner;
	public class Test {
	
		public static void print(int m) 
		{
			if(m == 1)
			{
				System.out.println("1");
				return; 
			}
			
			print(m - 1); 
			System.out.println(m); 
			
		}
	
		public static void main(String[] args)
	
		{
			Scanner scin = new Scanner(System.in);
	
			System.out.print("Enter one integer : ");
	
			int n = scin.nextInt();
	
			print(n);
	
			scin.close();
		}
	
}
