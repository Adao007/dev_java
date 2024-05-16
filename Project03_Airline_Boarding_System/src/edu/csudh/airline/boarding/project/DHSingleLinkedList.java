package edu.csudh.airline.boarding.project;

public class DHSingleLinkedList <E> implements BareBonesLinkedList <E>{
	
	// We need to create a node class for this LinkedList 
	private class Node<F> {
		private F data; 		// Data at the node 
		private Node<F> next; 	// The link to the next node
		
		// Constructors to the next Node 
		// This creates a node with data and the next value supplied by the user
		
		public Node(F data, Node<F> next) {
			this.data = data; 
			this.next = next; 
		}
		
		// When only the data is supplied, and the next is null
		public Node(F data) {
			this(data, null); // This calls the other constructor to create the node
			
		}
	}
	
	// Data and Methods for the Linked List 
	
	private Node<E> head; 		// Reference to the head of the linked list
	private int size; 			// How many nodes are there in the linked list 
	
	// Constructor for the Linked List 
	// Default Constructor that creates the head node that points to Null
	public DHSingleLinkedList() {
		this.head = new Node<E>(null); 
		// The head has no data, or next value at the beginning
		this.size = 0; 	// When the Linked List is created, there are no other data besides the head
		
	}
	
	@Override
	public void add(int index, E item) {
		// When you have an index, you must check if the index is valid 
		// Depending on the index, it adds to the first location using addFirst()
		// or adds after a node using addAfter()
		
		if(index < 0 || index > size) { // checking for a valid index
			System.out.println("Invalid Index!");
		}
		else if(index == 0) {
			// We are adding at the first location 
			addFirst(item);
		}
		else {
			// We are going to add after some node
			// We need the reference of that node first 
			Node<E> node = getNode(index); // Get the reference of the previous node
			addAfter(node, item); 
		}
	}
	
	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next);
		size++; 
		
	}
	
	private Node<E> getNode(int index) {
		
		if(index < 0 || index > size) { // checking for a valid index
			System.out.println("Invalid Index!");
			return null; 
		}	
		// this method loops over the LL, and returns the reference of the Node at the index
		
		Node<E> node = head; // this is a reference copy of the head
		for(int i = 0; i < index && node != null; i++) {
			node = node.next; 
		}

		return node; 		// return the reference at the index given 
	}
	
	private void addFirst(E item) {
		// We create a node, with item as data, and head.next as the next
		// Then we update the head.next to point to this newly created node
		// Finally, we increment the size
		
		head.next = new Node<E>(item, head.next); 
		size++; 
	}
	
	@Override
	public E remove(int index) {
		// This method removes an element from the LL at given Index
		if(index < 0 || index > size) { // checking for a valid index
			System.out.println("Invalid Index!");
			return null;
		}
		else if(index == 0) {
			return removeFirst(); 
		}
		else {
			Node<E> node = getNode(index); 
			return removeAfter(node);
		}
	}

	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next; 
		if(temp != null) {
			node.next = temp.next; 
			size--;
			return temp.data; 
		}
		return null;
	}

	private E removeFirst() {
		// Delete the first node
		Node<E> temp = head; 
		if(temp != null) {
			head = head.next; 
			size--;
			return temp.data; 
		}
		return null;
	}

	@Override
	public E get(int index) {
		if(index < 0 || index > size) { // checking for a valid index
			System.out.println("Invalid Index!");
			return null;
		}
		Node<E> node = getNode(index); 
		Node<E> temp = node.next; 
		return	temp.data; 
		
	}

	@Override
	public E set(int index, E newValue) {
		if(index < 0 || index > size) { // checking for a valid index
			System.out.println("Invalid Index!");
			return null;
		}
		Node<E> node = getNode(index);
		Node<E> temp = node.next; 
		temp.data = newValue; 
		return temp.data; 
	}

	@Override
	public int size() {
		// Returns the size of the linked list 
		return this.size;
	}
	
	// Implement the toString() to print the LL data 
	public String toString() {
		String s = "["; 
		Node<E> p = head;  // This reference will be used to iterate over the Linked List
		if (p != null) {	// When there is no head, check the error
			while(p.next != null) {
				// Iterate over the nodes one by one 
				s += p.next.data + " -> "; 	//adds the data to the string
				p = p.next; 
			}
			
		}
		// End of the LL 
		s += "]"; 
		return s; 
	}
}
