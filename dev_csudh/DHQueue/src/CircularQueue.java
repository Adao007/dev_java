// This is the Queue class using circular array concept
public class CircularQueue <E> implements BareBonesQueue<E> {

	
	// Data
	private E[] Q;							// Array reference for the actual Queue
	private int front;						// Front of the Queue
	private int rear;						// Rear of the Queue
	private int size;						// Number of elements in the queue	
	private int capacity;					// Total number of spots in the queue
	private final int DEFAULT_CAPACITY = 5;	// Default capacity 
	
	
	// Default Constructor 
	public CircularQueue() {
		this.Q = (E[]) new Object[this.DEFAULT_CAPACITY];		//Queue is created here
		this.front = 0;											// Front and rear 0, no element to begin with
		this.rear = 0;
		this.size = 0;
		this.capacity = this.DEFAULT_CAPACITY;
		
	}
	
	public CircularQueue(int capacity) {
		this.capacity = capacity; 								// Capacity is given by the user
		Q = (E[]) new Object[this.capacity];
		this.front = 0;
		this.rear = 0;
		this.size = 0; 
		
	}
	
	
	@Override
	public void offer(E obj) {
		// Adds elements at rear
		// First check if there is space to add
		if(isFull()) {
			System.out.println("Queue is out of space; calling reallocate");
			reallocate(); 
			this.offer(obj); 									// Once the space is available, this method is called again
		}
		else {
			// If we have space to add element at the rear of the queue
			Q[rear] = obj;										// Inserts the element
			rear = (rear + 1) % this.capacity; 					// Updates the rear
			size++;												// Updates the number of elements in the Q
		}
	}

	private void reallocate() {
		int neoCapacity = 2 * capacity; 						// Creates new doubled capacity
		E[] neoQ = (E[]) new Object[neoCapacity];		// Creates new Queue with doubled capacity 				
		int tempFront = front; 
		// Copy content of old queue into new queue
		for(int i = 0; i < this.size; i++) {
			neoQ[i] = Q[tempFront]; 
			tempFront = (tempFront + 1) % capacity; 
		}
		front = 0; 
		rear = size - 1; 
		capacity = neoCapacity;
		Q = neoQ; 
	}
	
	@Override
	public E poll() {
		// Remove an element from the front of the queue, if there is one
		if(isEmpty()) {
			System.out.println("Queue underflow!");
			return null; 
		}
		// So the Queue is not empty
		// We will remove the data from the front and return it back
		E temp = Q[front];										// Store the data to be returned
		front = (front + 1) % this.capacity; 					// Update the front
		size--;													// Update the size
		return temp; 
	}

	@Override
	public boolean isEmpty() {
		return(this.size == 0); 
	}

	@Override
	public boolean isFull() {
		return (this.size == this.capacity); 
	}

	@Override
	public E peek() {
		if(isEmpty() ) {
			System.out.println("Queue underflow!");
			return null;
		}
		return Q[front]; 
	}

	// Implement the toString method to display the contents of the queue
	public String toString() {
		String s = "Q: ";
		// Loop over the elements in the queue from the front to the rear
		for (int i = front; i < front + size; i++) {
			s += Q[i % this.capacity] + " | ";
		}
		return s; 
	}
}
