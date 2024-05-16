package lab111;

import java.util.Arrays;

public class lab113 {
	static void rearrange(int[] A, int[] B)
	{
		int count = 0;
		int count2 = 0;
		for(int i = 0; i < A.length; i++)
		{
			if (A[i] % 2 == 0) count ++;
			else count2 ++;
		}
		
		int holdEven[] = new int[count];
		int holdOdd[] = new int[count2];
		count = 0;
		count2 = 0;
		
		for(int i = 0; i < A.length; i++)
		{
			if(A[i] % 2 == 0) 
				holdEven[count++] = A[i];
			else
				holdOdd[count2++] = A[i];
		}
		count = 0;
		count2 = 1;
		
		for(int e : holdEven)
		{
			B[count] = e;
			count += 2;
		}
		for(int o : holdOdd)
		{
			B[count2] = o;
			count2 += 2;
		}
	
		
	}
	
	public static void main(String[] args)
	{

		int A1[] = {3, 2, 1, 5, 7, 6, 9, 7};
		int A2[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int A3[] = {1, 3, 5, 7, 9, 2, 4};
		int A4[] = {2, 2, 2, 1, 2, 5};
		int A5[] = {4};
		int A6[] = {7};
		
		// Create arrays B1, B2, B3, B4, B5, and B6.
		// And fill them using rearrange() method.  
		
		int B1[] = new int[A1.length * 2];
		int B2[] = new int[A2.length * 2];
		int B3[] = new int[A3.length * 2];
		int B4[] = new int[A4.length * 2];
		int B5[] = new int[A5.length * 2];
		int B6[] = new int[A6.length * 2];
		
		rearrange(A1, B1);
		rearrange(A2, B2);
		rearrange(A3, B3);
		rearrange(A4, B4);
		rearrange(A5, B5);
		rearrange(A6, B6);
		
		System.out.println("B1 : " + Arrays.toString(B1));
		System.out.println("B2 : " + Arrays.toString(B2));
		System.out.println("B3 : " + Arrays.toString(B3));
		System.out.println("B4 : " + Arrays.toString(B4));
		System.out.println("B5 : " + Arrays.toString(B5));
		System.out.println("B6 : " + Arrays.toString(B6));
	}
}
