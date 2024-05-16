package arraylist;

public class DHArrayList<E> implements BareBonesArrayList <E> {

	// Data
	private int size; // How many elements are there
	private int capacity; // How big is the array? 
	private E[] myArray; 	//Reference to the actual array, yet to be created
	private static final int INITIAL_CAPACITY = 1;  // Default capacity
	
	// Constructors
	public DHArrayList() {
		this.capacity = this.INITIAL_CAPACITY; 
		this.size = 0; 	//There are no elements when the Arraylist is begin created
		myArray = (E[]) new Object[this.capacity]; 	// This creates the actually array for the AL	
	}
	
	//Overloaded constructor, with user supplied capacity
	public DHArrayList(int capacity) {
		this.capacity = capacity;	//capacity set to user supplied capacity
		this.size = 0; // there are no elements when the ArrayList is being created
		myArray = (E[]) new Object[this.capacity]; 
	}
	@Override
	public void add(E a) {
		// This method adds an element to the end of the list 
		// First we need to check if there is space to add
		if(this.size < this.capacity) {
			// This means there is space
			// The index where the data is to be inserted is given by size
			myArray[size] = a; // Insert without issues
			size++; 			// Update the number of elements 
			
		}
		else {
			// No space! We need to call reallocate()
			System.out.println("There isn't space, calling reallocate");
			this.reallocate();
			this.add(a); // Once reallocate provides the space, call add again
		}
		
	}
	
	private void reallocate() {
		// This will double the size of the array 
		this.capacity *= 2;
		E[] temp = (E[]) new Object[this.capacity]; // New array with double capacity created
		//Copy over the elements from the old array to the new array
		for(int i = 0; i < myArray.length; i++) {
			// Iterate over the array, and insert the elements into the new one
			temp[i] = myArray[i];
			
		}
		// Once the copying is done, update the reference
		this.myArray = temp; // Pointing to the new array
	}
	
	@Override
	public void add(E a, int index) {
		// This method adds at a given index
		// First thing we need to is check validity of the index
		if(index < 0 || index > size) {
			System.out.println("Invalid index!");
			return;
		}
		else if (index == size) {
			this.add(a);
		}
		else {
			// we have a valid index, and need shifting of elements
			
			if(this.size == this.capacity) {
				// The array is full
				this.reallocate();
			}
			// Once reallocate is done, we have space to shift elements
			// we need to shift all elements from index to end one position to the right
			// Copy over the elements from the last one to the index
			for(int i = size; i > index; i--) {
				this.myArray[i] = this.myArray[i - 1];
				
			}
			// Once the elements are shifted, insert the data
			this.myArray[index] = a;
			this.size++; 
		}
	}

	@Override
	public E remove(int index) {
		// This will delete the element at index
		// First check the validity of the index
		if(index < 0 || index >= size) {
			System.out.println("Invalid Index!");
			return null;
		}
		// Now shifting might be required
		// Save the element to be deleted so that it can be returned
		E temp = myArray[index];
		// Shifting left
		for(int i = index; i < size -1; i++) {
			this.myArray[i] = this.myArray[i + 1];
		}
		this.size--;
		return temp; 
	}

	@Override
	public E get(int index) {
		// this method returns the elements at index, but does not delete it
		if(index < 0 || index >= size) {
			System.out.println("Indvaild Index!");
			return null;
			
		}
		return this.myArray[index]; // if the index if valid, return the element at the index
	}

	@Override
	public void set(E a, int index) {
		// This method will update the element at given index
		//First check the validity of the index
		if(index < 0 || index >= size) {
			System.out.println("Invaild Index!");
			return;	
		}
		myArray[index] = a; //If the index is valid update the value.
		
	}	
	@Override
	public int getSize() {
		// This returns how many elements are inside the arrayList
		return this.size;
	}

	@Override
	public int indexOf(E a) {
		// This method finds the first location of an element given
		for(int i = 0; i < size; i++) {
			if(a == this.myArray[i]) {
				return i; 		// returns index of element given by user
			}
		}
		System.out.println("Element not found!");
		return -1; // returns -1 if element not found. Index cannot be -1
			
	}

	
	//Implement toString() method
	// Converts the data in the data Structure into a String, and returns it
	
	public String toString() {
		// This method returns the contents of the array in a String
		String s = "";
		// We will iterate over the elements and add to the String
		for (int i = 0; i < this.size; i++) {
			s = s + myArray[i] + ", "; // ", " for formatting
			
		}
		// Returns the String
		return s; 
	}
	
	
	
	
	
	
}
