package Lab212;

public class Test {
	public static int sum(int[] a)
	{
		if(a.length == 1)
			return a[0]; 
		
		int[] copy = new int[a.length - 1];
	 
		for(int i = 0; i < copy.length; i++)
			copy[i] = a[i]; 
		
		int count = a[a.length - 1] + sum(copy); 
		return count; 
			
	}
	
	
	public static void main(String[] args)
	{
		int[] A = {4, 2, 6, 1, 10, 9};
		int sum = sum(A);
		System.out.println("sum of A : " + sum);
	}
		
}
