package Lab221;

import java.util.ArrayList;
	public class Test {
	
	public static int add(ArrayList a)
	{
		int sum = 0; 
		int add = (int)a.get(0); 
		a.remove(0); 
		
		if(a.size() == 0)
		{ 
			sum += add;
			return sum; 
		}
		
		return sum = add + add(a);
		
	}
	public static void main(String[] args)
{
	ArrayList<Integer> al = new ArrayList<Integer>();
	al.add(10);
	al.add(5);
	al.add(11);
	al.add(22);
	al.add(3);
	int result = add(al) ;
	System.out.println("sum of al : " + result);
}
}