package edu.csudh.airline.boarding.project;

import java.util.NoSuchElementException;

public class CircularQueue<E> implements Queue<E>{

	// Data variables for Queue START
	private E array[]; 										//Array reference for the Queue's array 
	private int front; 										//Pointer to the front of the Queue
	private int back; 										//Pointer to the back of the Queue 
	private int size;										//Total number of elements in the Queue
	private int capacity; 									//Total number of spots in the Queue
	private int DEFAULT_CAPACITY = 5; 						//DEFAULT CAPACITY 
	// Data variables for Queue END -----
	
	// Default Constructor 
	public CircularQueue() {
		this.array = (E[]) new Object[DEFAULT_CAPACITY]; 	//Creates the array for the Queue HERE
		this.front = 0; 									//Queue has no elements yet: Front, Back, Size are all 0
		this.back = 0; 
		this.size = 0; 
		this.capacity = this.DEFAULT_CAPACITY; 				//Sets capacity to the default capacity 
	}
	
	// Constructor for User-Defined Capacity 
	public CircularQueue(int capacity) {
		this.capacity = capacity; 							//Sets capacity to the capacity given by the user
		this.array = (E[]) new Object[this.capacity]; 		//Creates array for the Queue with user capacity
		this.front = 0; 									//Queue has no elements: Front, Back, Size are all 0
		this.back = 0; 
		this.size = 0; 
	}
	
	// True/False Tests for the QUEUE START: Empty AND Full methods
	public boolean isEmpty() {
		if(this.size == 0) {
			return true; 									//Return true: The Queue is empty (Size equals 0)
		}
		
		return false;										//Return false: The Queue is not empty (Size > 0)
	}

	public boolean isFull() {
		if(this.size == this.capacity) {
			return true; 									//Return true: Size equals capacity (Queue is full)
		}
		
		return false;										//Return false: Size < capacity (Queue is not full)
	}
	// True/False Tests for the Queue END -----
		
	// Methods to interact with the Queue: ENQUEUE, DEQUEUE, PEEK
	// offer method START: adds an element into the Queue 
	@Override
	public boolean offer(E obj) {
		// Check if Queue is full call allocate method 
		if(isFull()) {
			System.out.println("Queue is full: reallocating Queue!"); 
			reallocate(); 
		}
		
		// If there is space then proceed to enqueue element
		array[back] = obj; 									//Element is added to the back of the Queue
		back = (back + 1) % this.capacity;					//Update the back pointer
		size++; 											//Increase size counter
		return true; 
	}
	
	// Method to add more space for Queue 
	private void reallocate() {
		int neoCapacity = capacity * 2; 					//Doubles the current capacity
		E[] neoArray = (E[]) new Object[neoCapacity]; 		//Creates new array with new capacity
		int tempFront = front; 
		// Copy old array into new array 
		for(int i = 0; i < this.capacity; i++) {
			neoArray[i] = array[tempFront]; 
			tempFront = (tempFront + 1) % capacity; 
		}
		front = 0; 
		back = size; 
		capacity = neoCapacity; 
		array = neoArray; 									//Set queue array equal to the temp array
		
	}
	// offer method ENDS ----

	// remove method START: removes an element and throws exception 
	public E remove() {
		try {
			return poll(); 
		} catch (NoSuchElementException e) {
			System.err.println("ERROR: No such element!"); 
			return null;
		}
	}
	
	//poll method START: removes an element from the Queue 
	@Override
	public E poll() {
		// Check to see if the Queue is empty: CANNOT DEQUEUE ON EMPTY QUEUE 
		if(isEmpty()) {
			System.out.println("ERROR[Queue underflow]: Dequeue on empty Queue!"); 
			return null; 
		}
		
		E temp = array[front]; 							//Saves soon-to-be deleted element for return 
		front = (front + 1) % this.capacity; 			//Updates front pointer
		size--;											//Updates size counter
		return temp; 									//Returns removed element HERE
	}
	//poll method end --- 
	
	//PEEK method START: returns element in front of the Queue
	@Override
	public E peek() {
		// Check to see if the Queue is empty: CANNOT PEEK ON EMPTY QUEUE
		if(isEmpty()) {
			System.out.println("ERROR[Queue underflow]: Peek on empty Queue!"); 
			return null; 
		}
		return array[front]; 							//Returns element in the front of the Queue 
	}
	//PEEK method END -----
	
	// RETURN SIZE of QUEUE
	public int getSize() {
		return this.size; 
	}
	
	// element START 
	public E element() {
		try {
			return peek(); 
		} catch(NoSuchElementException e) {
			System.err.println("ERROR: No such element!"); 
			return null; 
		}
	}

	//toString method to print out contents of Queue 
	public String toString() {
		//Return message "Queue is Empty if user tries to print queue, when size = 0" 
		if(isEmpty()) {
			return "Queue is Empty"; 
		}
		
		String s = ""; 									//Variable to contain contents of Queue 
		for(int i = front; i < front + size; i++) {		//For Loop to copy contents into s String 
			s += array[i % this.capacity] + "\n"; 
		}
		return s; 										//Returns completed s 
	}
}
