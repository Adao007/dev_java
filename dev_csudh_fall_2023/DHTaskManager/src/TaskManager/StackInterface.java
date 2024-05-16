package TaskManager;
// Interface for Stack
public interface StackInterface<E> {
	
	void push(E obj); 				// This adds element to the stack 
	
	E pop(); 						// This is to remove the elements from the stack
	
	E peek();						// Returns the top element without deleting it
	
	boolean isEmpty(); 				// Checks to see if the stack is empty 
	
}
