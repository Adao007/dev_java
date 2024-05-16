// Interface for the Linked List

public interface BareBonesLinkedList<E>{
	// Add element to the Linked List at specific index
	public void add(int index, E item);
	// Remove an element from the Linked List at specific index
	public E remove(int index);
	//Getters and Setters
	public E get(int index);
	public E set(int index, E newValue);
	// Get the current size of the Linked List
	public int size(); 
	
}
