package lab12;

public class lab125 {
	public static int distance (int ... x)
	{
		int sum = 0;
		for (int i = 0; i < x.length; i++)
		{
			sum += x[i];
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		int a = distance(80, 23, 58, 33);
		int b = distance(100, 120, 300);
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
}
