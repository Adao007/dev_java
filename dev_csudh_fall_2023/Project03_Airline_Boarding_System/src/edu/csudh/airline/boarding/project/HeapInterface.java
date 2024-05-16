package edu.csudh.airline.boarding.project;

public interface HeapInterface <E> {
	public void insert(E item); 		// Insert item into the heap
	
	public E remove(); 					// Removes root item and replaces it with correct root
	
	public E getRoot(); 				// Returns root of Heap
}
