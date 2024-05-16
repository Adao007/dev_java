package Lab202;

public class P2 {
	public static int count(String src, String target)
	{
		int count = 0;
		String check = target;
		String letter = " ";
		for (int i = 0; i < src.length() - 1; i++) {
			letter = src.substring(i, i + 2);
			if(check.equals(letter)) count++; 
		}
			
		return count; 
	}
	
	public static void main(String[] args) {
	String[] codes = {"12345AB12AB1AB333AB1234",
			"12345A3B1234",
			"13A453A453B123AB1233AB4433AB77",
			"1234512345A12AB345",
			"AB1AB2AB3AB4AB5AB6AB",
			"ABCDABCD1234ABCD"};
	
	for (String code : codes) 
		System.out.println(code + " : " + count(code, "AB"));
	
		}
	}
