
public class StackDriver {

	public static void main(String[] args) {
		// Lets create a Stack of Integers
		ArrayStack<Integer> myStack = new ArrayStack<>();
		myStack.push(10);
		System.out.println(myStack);
		
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);
		myStack.push(50);
		System.out.println(myStack); 	// This is a full Stack
		
		myStack.push(60); 				// There will be an overflow here
		System.out.println(myStack); 	// as you can see the Stack does not contain the 60 
		
		myStack.pop(); 					//Removes the TOS
		System.out.println(myStack);
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		myStack.pop();
		
		myStack.push(100);
		System.out.println("The TOS is: " + myStack.peek()); 
	}

}
