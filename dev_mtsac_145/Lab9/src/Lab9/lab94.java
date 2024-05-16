package Lab9;

import java.util.Scanner;

public class lab94 {
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = scan.nextInt(); 
		
		int sum = addAll(n);
		System.out.println("Sum = " + sum);
		
	}

	
public static int addAll(int n)
{
	int sum = 0;
	int i = n;
	
	
	
	while(i > 0)
	{
		int j = 0;
		int count = i;
		while (j < i)
		{
			sum += count;
			count --;
			j++;
		}
		i--;
	}
	
	return sum;
			
}
}

