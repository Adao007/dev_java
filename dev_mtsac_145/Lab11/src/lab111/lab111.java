package lab111;

import java.util.Arrays;
import java.util.Scanner;

public class lab111 {
	public static void main(String[] args)
	{
		int[] A = new int[10];
		int max = 0;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		
		for (int a = 0; a < A.length; a++)
		{
			System.out.print("Enter A[" + a + "] = ");
			A[a] = scan.nextInt(); 
		}
		
		System.out.println("----------------------");
		System.out.println("The contents of A");
		
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
		
		System.out.println();
		System.out.println("----------------------");
		
		for (int b = 0; b < A.length; b++)
		{
			if (max <= A[b])
			{
				max = A[b];
				count ++;
			}
		}
		
		System.out.println("max : " + max); 
		System.out.println("count : " + count);
		scan.close();
	}
}
