package lab111;

import java.util.Random;

public class lab112 {
	public static void main(String[] args)
	{
		Random gen = new Random();
		int [] A = new int[10];
		for (int i = 0; i < A.length; i++)
		{
			int random = gen.nextInt(50) + 1;
			A[i] = random;
		}
		
		System.out.println("Original Array");
		System.out.println("----------------------------");
		for (int a = 0; a < A.length; a++)
		{
			System.out.print(A[a] + " ");
		}
		System.out.println();
		System.out.println();
		
		System.out.println("After swapping");
		System.out.println("-----------------------------");
		
		int count = 0;
		int temp = 0;
		int first = 0;
		int second = 0;
		
		for(int x = 0; x < A.length; x += 2)
		{
			first = A[x];
			second = A[x + 1];
			A[x] = second;
			A[x + 1] = first;
		}
		
		for (int a = 0; a < A.length; a++)
		{
			System.out.print(A[a] + " ");
		}
				
	}
}
