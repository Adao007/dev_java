package TaskManager;

public interface LinkedListInterface<E> {
	// METHOD ADD - Add item to LinkedList at index 
	public void add(int index, E item); 
	// METHOD GET - Returns the item at index 
	public E get(int index); 
	// METHOD REMOVE - Removes item at index 
	public E remove(int index); 
	// METHOD SET - Sets item at index to the value given
	public E set(int index, E newValue); 
	// METHOD SIZE - Returns size of the Linked List
	public int size(); 
}
