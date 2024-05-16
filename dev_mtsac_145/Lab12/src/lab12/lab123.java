package lab12;

public class lab123 {

	public static void main(String[] args)
	{
		int count = 0;
		
		String s = new String(args[0]);
		String s2 = new String(args[1]);
		
		for (int i = 0; i < s.length(); i++)
			count++;
		for (int i = 0; i < s2.length(); i++)
			count++;
		
		System.out.println("length : " + count);
	}
}
