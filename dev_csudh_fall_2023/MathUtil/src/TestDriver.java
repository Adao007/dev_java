import Math.Utility;
import Math.RecursiveUtility;

public class TestDriver {
	static int i = 0; 
	
	public static void main(String[] args) {
		int i = 0; 
		Utility helper = new Utility (); 
		RecursiveUtility rHelper = new RecursiveUtility(); 
		
		System.out.println(helper.factorial(3)); 
		System.out.println(helper.power(2, 1));
		System.out.println(helper.power(2.0, -2));
		System.out.println(rHelper.fib(40));
		System.out.println(rTowersOfHanoi(4, 'S', 'D', 'T'));
		
		
	}
	
	public static String rTowersOfHanoi(int plate, char start, char dest, char temp) {
		if (plate == 1) {
			return "Move disk 1 from peg " + start + " to peg " + dest + "\n";
		}
		else {
			return rTowersOfHanoi(plate - 1, start, temp, dest) + 
					"Move disk " + plate + " from peg " + start + 
					" to peg " + dest + "\n" + 
					rTowersOfHanoi(plate - 1, temp, dest, start); 
		}
	}
		
}
