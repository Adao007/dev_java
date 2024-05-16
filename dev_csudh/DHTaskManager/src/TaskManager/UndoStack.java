package TaskManager;

public class UndoStack <E> implements StackInterface<E>{

	// Storage for the Stack 
	private E[] arrayStack; 								// Reference holder for array
	private int top = -1;									// Top of Stack variable 
	private int capacity; 									// Capacity variable 
	private static final int INITIAL_CAPACITY = 5;  		// Default capacity of the stack 
	
	// Default Constructor for the Stack 
	public UndoStack() {
		this.capacity = this.INITIAL_CAPACITY; 
		this.arrayStack = (E[]) new Object[this.capacity]; 
	}
	
	// User-Defined Capacity - Constructor
	public UndoStack(int capacity) {
		this.capacity = capacity; 
		this.arrayStack = (E[]) new Object[this.capacity];  
	}
	
	// Adds elements to the Stack 
	@Override
	public void push(E object) {
		// Check if there is space to add 
		if(this.top == this.arrayStack.length - 1) {
			System.out.println("ERROR STACK OVERFLOW: Allocating more space!"); 
			reallocate(); 
		}
		this.arrayStack[++top] = object; 					// Updates and adds element on the top of the stack. 
		return; 											// End of push method
		
	}
	
	// Method for allocating more space
	private void reallocate() {
		int neoCapacity = capacity * 2;				  		// Create new capacity variable  
		E[] neoArray = (E[]) new Object[neoCapacity]; 		// Create new array with new size
		
		// For Loop to copy elements into new array
		for(int i = 0; i < arrayStack.length; i++) {
			neoArray[i] = arrayStack[i]; 
		}
		
		// Set variables to updated variables 
		capacity = neoCapacity; 
		arrayStack = neoArray; 
		return; 
	}

	// Removes element off the TOS
	@Override
	public E pop() {
		// Checks to see if Stack is empty
		if(isEmpty()) {
			System.out.println("ERROR STACK UNDERFLOW: Pop on empty Stack"); 
			return null; 
		}
		return this.arrayStack[top--]; 					  // Returns element on TOS, Updates top variable 
	}

	// Return the element on the TOS
	@Override
	public E peek() {
		// Checks to see if Stack is empty
		if(isEmpty()) {
			System.out.println("ERROR STACK UNDERFLOW: Peek on empty Stack"); 
			return null; 
		}
		return this.arrayStack[top]; 					// Returns element on TOS
	}

	@Override
	public boolean isEmpty() {
		// Returns true if stack is empty 
		return (top == -1); 
	}

}
