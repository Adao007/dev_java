// Methods for the Queue
public interface BareBonesQueue <E> { // <E> uses genetics 

	public void offer (E obj); 		// Adding data

	public E poll(); 				// Removing data

	public boolean isEmpty();		// Check if the Queue is empty

	public boolean isFull();		// Checks if the Queue is full

	public E peek(); 				// Returns the first element without deleting it. 
}
