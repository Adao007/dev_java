package Math;

public class RecursiveUtility {
	
	// FACTORIAL METHODS HERE 
	public int rFactorial(int n) {
		if(n == 0) {													// If factorial equals 0, return 1 (0! = 1)
			return 1; 
		}
		else {
			return n * rFactorial(n - 1); 								// Recursively calls rFactorial with base number - 1
		}
	}
	
	// POWER METHODS HERE
	public int rPower(int base, int power) {							// Takes type int base and int power
		if (power == 0) {												// Base Case: if power equals 0 base equals 1
			return 1;
		}
		else {
			return base * rPower(base, power - 1); 						// Recursively calls rPower with power - 1 until Base Case is reached
		}
	}
	
	// OVERLOAD rPOWER METHOD WITH DOUBLE TYPE FOR BASE NUMBER
	public double rPower(double base, int power) {
		if(power == 0) {
			return 1; 
		}
		else {
			return base * rPower(base, power - 1); 
		}
	}
	
	// FIBONACCI SEQUENCE: Ever wanted to know what number lays behind what sequence? Ask no more... 
	public int fib(int seq) {
		if(seq <= 2) {
			return 1; 
		}
		else {
			return fib (seq - 1) + fib(seq - 2); 
		}
	}
	
	
}
