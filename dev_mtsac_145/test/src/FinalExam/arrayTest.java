package FinalExam;

public class arrayTest {
	static public void main(String[] args)
	{
		int A[] = {4, 5, 1,9, 7}; 
		System.out.println(A.length); // prints out 5 (the array has elements 0 - 4 tho) 
		
		for(int i = A.length - 1; i > 0; i--)
		{
			System.out.println(i); // prints to 1 then ends for loop. 
		}
		
		for(int i = A.length - 1; i > 0; i--)
		{
			A[i] = A[ i - 1]; 
		}
		
		for(int i = 0; i < A.length; i++)
		{
			System.out.print(A[i] + " ");
		}
	}
}