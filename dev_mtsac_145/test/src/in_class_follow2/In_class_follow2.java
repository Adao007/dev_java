package in_class_follow2;

import java.util.Arrays;

public class In_class_follow2 {
	
	public static void main(String[] args)
	{
		int A[] = {5, 3, 7, 9, 2};
		for (int i=A.length-1; i>=0; i--) {
		for (int j=0; j<A.length; j ++) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
		}
		}
		System.out.println(Arrays.toString(A));
	}

}
