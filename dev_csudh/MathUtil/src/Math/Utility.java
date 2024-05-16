package Math;

public class Utility {
	
	public int factorial(int base) {
		int factorial = 1; 
		for(int i = 1; i <= base; i++) {
			factorial = factorial * i; 
		}
		return factorial; 
	}
	
	// POWER METHOD
	public int power(int base, int power) {
		if(power < 0) {																			// Check for negative powers: return -1 if true
			System.out.println("ERROR: Base type integer cannot hold decimal values!"); 
			return -1; 
		}
		
		int number = 1; 
		for(int i = 0; i < power; i++) {
			number *=  base; 
		}
		return number;
	}
	
	public double power(double base, int power) {
		int number = 1; 
		
		if(power < 0) {
			for(int i = 0; i > power; i--) {
				number /= base; 
			}
			return number; 
		}
		else {
			for(int i = 0; i < power; i++) {
				number *= base;
			}
			return number;
		}
	}
}
