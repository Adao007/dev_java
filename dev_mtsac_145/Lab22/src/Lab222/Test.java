package Lab222;

import java.util.ArrayList;

public class Test {
	public static void reverse(ArrayList a)
	{
		Object[] temp = a.toArray();
		
		for(int i = 0; i < a.size(); i++)
			a.set(i, temp[a.size() - 1 - i]); 
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);  A.add(7);  A.add(2);  A.add(1);
		A.add(6);  A.add(4); A.add(5);
		System.out.println("Before reverse : " + A);
		reverse(A);
		System.out.println("After reverse  : " + A);
	}
}