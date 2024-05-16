
public class ArrayStack <E> implements BareBoneStack <E>{

	// Storage for the stack
	private E[] theData; 		// This is only the reference holder
	private int topOfStack = -1; 	// Variable to store the TOS
	private static final int INITIAL_CAPACITY = 5; // This will be the default capacity of the stack. 
	
	// Constructors for the class
	public ArrayStack() {
		// The actual array needs to be created here, and the reference saved in theData
		this.theData = (E[]) new Object [this.INITIAL_CAPACITY]; 
	}
	
	//Overloaded constructor, to create a stack of user given capacity
	public ArrayStack(int capacity) {
		this.theData = (E[]) new Object [capacity]; 

	}
	
	@Override
	public void push(E obj) {
		// This method adds element to the Stack
		// First check, if there is space to add
		
		if(this.topOfStack == this.theData.length - 1) {
			
			// Meaning if the last element is at location capacity - 1, then it is full
			System.out.println("Stack Overflow!"); // If you want, then use allocate similar to AL.
			return;
		}
		// Otherwise, there is space to insert
		this.topOfStack++;
		this.theData[topOfStack] = obj;
		return;
		
	}

	@Override
	public E pop() {
		// this method deletes an element from the TOS
		if(isEmpty()) { // call the isEmpty method to check, if true then return
			System.out.println("Stack is Empty, no data to pop!"); 
			return null;
		}
		return this.theData[topOfStack--];
		
	}

	@Override
	public E peek() {
		// Returns the TOS without deleting the element
		if(isEmpty()) {
			System.out.print("The Stack is Empty, no data to peek");
			return null;
		}
		return this.theData[topOfStack];
	}

	@Override
	public boolean isEmpty() {
		// returns true if Stack is empty
		return (topOfStack == -1); 
	}
	
	public String toString() {
		String s = "Stack: "; 
		// Iterate over the elements and add to the String
		for(int i = 0; i <= this.topOfStack; i++) {
			s += this.theData[i] + " | "; 
		}
		return s;
	}
}
