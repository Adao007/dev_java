package _GradleTest;

public class MathUtils {
	
	// method returns the sum of two integers 
		int add(int a, int b) {
			return a + b; 
		}
			
		// method returns the difference of two integers 
		int subtract(int a, int b) {
			return a - b; 
		}
			
		// method returns the product of two integers 
		int multiply(int a, int b) {
			return a * b; 
		}
			
		// method returns the result of dividing two integers
		double divide(int a, int b) {
			// checks if b is 0, if true then return -1
			if(b == 0) {
				return -1.0; 
			}
			return a/b; 
		}

}


