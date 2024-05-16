package edu.csudh.airline.boarding.project;

import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable> implements Queue<E> {
	// Data Members 
	private MinHeap<E> heap;
	private int size; 
	
	// Default Constructors 
	public PriorityQueue() {
		heap = new MinHeap<E>(); 
		size = 0;
	}
	// Constructors with inputed capacity
	public PriorityQueue(int capacity) {
		heap = new MinHeap<E>(capacity); 
		size = 0; 
	}
	
	// "inserts an item into the queue. Returns true if successful 
	@Override
	public boolean offer(E item) {
		heap.insert(item);
		size++; 
		return true; // Array-list handles failed "insert" always returns true. 
	}

	// "removes the smallest entry and returns it if the queue is not empty 
	@Override
	public E remove() {
		try {	
			E temp = heap.remove(); 
			size--; 
			return temp; 
	
		} catch(NoSuchElementException e) { // If the queue is empty, throws an exception 				
			System.err.println("ERROR: No such element!"); 
			return null;
		}
	}
	
	// Returns the smallest entry and returns it. 
	@Override
	public E poll() {
		E temp = heap.remove(); // If the queue is empty, heap returns null;
		size--; 
		return temp; 
	}

	// Returns the smallest entry without removing it. 
	@Override
	public E peek() {
		return heap.getRoot(); // If the queue is empty, heap returns null; 
	}

	// Returns the smallest entry without removing it. 
	@Override
	public E element() {
		try {
			heap.getRoot(); 
		} catch(NoSuchElementException e) {	// If the queue is empty, throw an exception 
			System.err.println("ERROR: No such element!"); 
		}
		return null;
	} 
	
	public boolean isEmpty() {
		if(size == 0) {
			return true; 
		}
		return false; 
	}
}
