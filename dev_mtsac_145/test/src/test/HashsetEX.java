package test;

import java.util.HashSet;

public class HashsetEX {
	public static void main(String[] args)
	{
		HashSet<String> set = new HashSet<> ();
		set.add(new String("David")); 
		set.add(new String("Anthony")); 
		set.add(new String("David")); 
		set.add(new String("Anthony"));
		set.add(new String("Tony")); 
		
	}
}
