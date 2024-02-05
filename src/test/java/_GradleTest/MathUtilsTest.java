package _GradleTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	// Unit test for Add method
	@Test 
	public void testAdd() {
		MathUtils mu = new MathUtils(); 
		assertEquals(581, mu.add(500, 81), "Expected and actual coefficients don't match!"); 
	}
	
	// Unit test for Subtract method 
	@Test 
	public void testSubtract() {
		MathUtils mu = new MathUtils(); 
		assertEquals(419, mu.subtract(500, 81), "Expected and actual cofficients don't match!"); 
	}
	
	// Unit test for Multiply method
	@Test
	public void testMultiply() {
		MathUtils mu = new MathUtils(); 
		assertEquals(405, mu.multiply(5, 81), "Expected and actual cofficients don't match!"); 
	}
	
	// Unit test for Divide method 
	@Test 
	public void testDivide() {
		MathUtils mu = new MathUtils(); 
		// testing if divide by 0 
		assertEquals(-1, mu.divide(581, 0), "Expected -1 was not returned!"); 
		// testing divide method
		assertEquals(6, mu.divide(500, 81), "Expected and actual cofficients don't match!"); 
	}
}
