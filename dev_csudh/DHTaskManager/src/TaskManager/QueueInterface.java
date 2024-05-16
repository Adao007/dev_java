package TaskManager;

// Queue Interface
public interface QueueInterface<E> {
	
	public boolean isEmpty(); 									// Check to see if Queue is empty
	
	public boolean isFull();									// Check to see if Queue is Full 
	
	public void enqueue(E obj); 								// Adds to the Queue
	
	public E dequeue(); 										// Removes from the Queue
	
	public E peek(); 											// Returns the element at the front of the Queue 
}
