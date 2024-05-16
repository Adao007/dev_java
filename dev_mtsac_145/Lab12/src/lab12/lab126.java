package lab12;

import java.util.Arrays;

public class lab126 {
	
	public static void setZero(int[] x, int[] y) {
		
	int[] a = new int[y.length];
	
	for (int i = 0; i < x.length - y.length + 1; i++)
	{
		for (int j = 0; j < y.length; j++)
			a[j] = x[i + j];
		
		if (Arrays.equals(a, y))
			for (int k = 0; k < y.length; k++)
				x[i + k] = 0;
		
	}		
		 
	}
	
	public static void main(String[] args) {
		int[] a1 = {1, 2, 3, 4, 1, 2, 3, 4, 5};
		int[] a2 = {2, 3, 4};
		int[] b1 = {3, 3, 1, 3, 5, 3, 3, 3, 6, 7, 3, 3};
		int[] b2 = {3, 3};
		int[] c1 = {1, 2, 3, 1, 2, 3, 1, 1, 2, 3};
		int[] c2 = {1};
		int[] d1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 1, 2, 3, 4, 5, 1, 2, 3};
		int[] d2 = {1, 2, 3, 4, 5};
		
		System.out.println("Original Array");
		System.out.println("----------------------------------------");
		System.out.println("a1 : " + Arrays.toString(a1));
		System.out.println("a2 : " + Arrays.toString(a2));
		System.out.println("b1 : " + Arrays.toString(b1));
		System.out.println("b2 : " + Arrays.toString(b2));
		System.out.println("c1 : " + Arrays.toString(c1));
		System.out.println("c2 : " + Arrays.toString(c2));
		System.out.println("d1 : " + Arrays.toString(d1));
		System.out.println("d2 : " + Arrays.toString(d2));
		
		setZero(a1, a2);
		setZero(b1, b2);
		setZero(c1, c2);
		setZero(d1, d2);
		System.out.println("\n\nAfter set zero");
		System.out.println("----------------------------------------");
		System.out.println("a1 : " + Arrays.toString(a1));
		System.out.println("a2 : " + Arrays.toString(a2));
		System.out.println("b1 : " + Arrays.toString(b1));
		System.out.println("b2 : " + Arrays.toString(b2));
		System.out.println("c1 : " + Arrays.toString(c1));
		System.out.println("c2 : " + Arrays.toString(c2));
		System.out.println("d1 : " + Arrays.toString(d1));
		System.out.println("d2 : " + Arrays.toString(d2));
		}
	}

