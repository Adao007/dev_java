package edu.csudh.airline.boarding.project;

public class MinHeap <E extends Comparable> implements HeapInterface<E> {

	private DHArrayList<E> heap; 					// ArrayList for heap's data 
	int heapSize; 									// Holds the size of the Heap as well as the bottom of the Heap
	final int ROOT = 0; 							// const variable for root's position 
	final int DEFAULT_CAPACITY = 15; 				// const variable for default constructor 
	
	// Default Constructor
	public MinHeap() {
		heap = new DHArrayList<E>(DEFAULT_CAPACITY); 
		heapSize = 0; 
	}
	
	// Constructor with user-defined capacity 
	public MinHeap(int capacity) {
		heapSize = 0; 						
		heap = new DHArrayList<E>(capacity); 
	}
	
	// METHODS START --- 
	@Override
	public void insert(E item) {
		heap.add(item, heapSize++);					// Adds to heap then increments by 1
		upHeap(heapSize - 1); 						// Calls upHeap on the newest node to keep MinHeap order 
	}

	@Override
	public E remove() {
		if(isEmpty()) {
			System.out.println("ERROR: Heap is currently empty!");
			return null;
		}
		
		E temp = heap.get(ROOT);					// Place item to remove in temp 
		heapSize--; 								// decrement heapSize
		if(heapSize != 0) {
			downHeap(); 							// Call downHeap to maintain heap
		}
		else {
			heap.remove(heapSize);
		}
		return temp; 								// Return min item
	}
	
	private void downHeap() {
		int parent = ROOT; 							// Parent variable for comparing 
		int smaller; 								// smaller variable for swapping 
		heap.set(heap.remove(heapSize), ROOT); 		// Replaces root node with last item in the heap  
		
		while(heap.get((2 * parent) + 1) != null || heap.get((2 * parent + 2)) != null) {			// while parent node has children 
			smaller = getSmaller(parent); 															// calls getSmaller method for comparing children nodes with parent node
			if(smaller == parent) { break; }														// if parent node is smaller than children, break while loop 
			swap(parent, smaller); 																	// Swap parent node with smaller child node (or right child if children nodes == ) 
			parent = smaller; 																		// Set parent to swapped node
		}
	}

	private int getSmaller(int parent) {
		int smaller = parent; 																								// Set smaller to parent (if parent is smaller than children, return parent)
		
		if(heap.get(smaller).compareTo(heap.get((2 * parent) + 1)) == 1) { 													// If (parent > leftchild) 
			smaller = (2 * parent) + 1; 																					// Set smaller to leftchild		
		}
		if(heap.get((2 * parent) + 2) != null && (heap.get(smaller).compareTo(heap.get((2 * parent) + 2)) == 1)) {			// If (smaller > rightchild) : smaller is either leftchild or parent.  
			smaller = (2 * parent) + 2; 																					// Set smaller to rightchild if smaller >= rightchild
		}
		return smaller;
	}

	@Override
	public E getRoot() {
		if(isEmpty()) {															// If heap is empty, then return null and system out error message
			System.out.println("ERROR: Heap is currently empty!"); 
			return null; 
		}
		return heap.get(ROOT);													// Return root of heap 
	}
	
	public boolean isEmpty() {
		return heapSize == 0;													// Returns True if heapSize is 0, Heap is Empty
	}
	
	public int getSize() {
		return heapSize; 
	}
	
	public void upHeap(int bottom) {
		while(bottom != ROOT && heap.get(bottom).compareTo(heap.get(getParent(bottom))) == -1) {	// while ( New item is not at ROOT position and New item < parent node )
			swap(getParent(bottom), bottom); 														// pass in parent, child to swap method
			bottom = getParent(bottom);																// set bottom to parent
		}
	}
	
	public void swap(int parent, int child) {														// Swap Method for swaping parentNode with childNode
		E temp = heap.get(parent);  																// Set Temp to parent item
		heap.set(heap.get(child), parent);															// Set child item, to parentNode
		heap.set(temp, child);																		// Set temp to childNode
	}
	
	public int getParent(int child) {																// getParent method gets parent of childNode 
		return (child - 1) / 2; 
	}
	
	public String toString() {																		// toString method for outputting heap 
		String s = ""; 
		for(int i = 0; i < heapSize; i++) {
			s += heap.get(i) + " \n";  
		}
		return s; 
	}

}

