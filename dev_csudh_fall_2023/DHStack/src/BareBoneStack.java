
public interface BareBoneStack <E>{
	
	void push (E obj); // This is to add elements to the stack
	
	E pop();	// This is to remove the elements from the stack
	
	E peek(); // Returns the top element without deleting it
	
	boolean isEmpty(); //Checks to see if the stack is empty
}
