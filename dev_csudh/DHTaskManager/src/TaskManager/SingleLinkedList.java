package TaskManager;

public class SingleLinkedList<E> implements LinkedListInterface<E> {

	// NODE CLASS START 
	private class Node<F> {
		// Data Members 
		private F data;							// Data that the node holds				
		private Node<F> next;					// Link to the next node
	
		// Constructors to the next Node
		// This creates a node with data and the next value supplied by the user
		
		public Node(F data, Node<F> next) {
			this.data = data;
			this.next = next; 
		}
		
		// Constructor for data only, next is null 
		public Node(F data) {
			this(data, null); 					// Calls other constructor to create the node
		}
	}
	
	// Data Members of LinkedList 
	private Node<E> head; 						// Reference to the head of the Linked List 
	private int size; 							// Number of Nodes inside the Linked List 
	
	// Constructor: Creates head node that points to null
	public SingleLinkedList() {
		this.head = new Node<E>(null); 			// Linked List is created with head pointer 
		this.size = 0; 							// Linked List contains no data yet, size = 0
	}
	
	
	@Override
	public void add(int index, E item) {
		if (index < 0 || index > size) {
			System.out.println("ERROR[Invalid Index]: Please enter an index within range of LinkedList.");
		}
		else if(index == 0) {
			addFirst(item); 					// Add item to the first location of the Linked List
		}
		else {
			Node<E> node = getNode(index); 		// Call Helper Method to get Node needed to add
			addAfter(node, item); 				// Add item to correct index using node given by getNode method
		}
	}

	// HELPER METHODS FOR ADD 
	private void addAfter(Node<E> node, E item) {
		node.next = new Node<E>(item, node.next); 
		size++; 
	}

	// GETNODE METHOD HERE
	private Node<E> getNode(int index) {
		// Checking for index validity 
		if(index < 0 || index > size) {
			System.out.println("ERROR[Invalid Index!]"); 
			return null;
		}
		
		// Loops over Linked List, and returns reference of the node at the given index
		Node<E> node = head; 
		for(int i = 0; i < index && node != null; i++) {
			node = node.next; 
		}
		return node; 							// Returns the reference at the index found
	}


	private void addFirst(E item) {
		head.next = new Node<E>(item, head.next); 	// Create node, with item as data, and head.next as the next node
		size++; 									// Update size counter
		
	}

	
	@Override
	public E get(int index) {
		if(index < 0 || index > size) {
			System.out.println("ERROR[Invalid Index!]"); 
			return null; 
		}
		
		Node<E> node = getNode(index);
		Node<E> tempNode = node.next; 
		return tempNode.data; 						// Returns data at index
	}

	// REMOVE METHOD HERE 
	@Override
	public E remove(int index) {
		if(index < 0 || index > size) {
			System.out.println("ERROR[Invalid Index]");
			return null; 
		}
		else if(index == 0) {
			return removeFirst(); 					// Removes the first item in the Linked List 
		}
		else {
			Node<E> node = getNode(index); 
			return removeAfter(node); 				// Removes the !first items in the Linked List 
		}
	}

	// REMOVE HELPER METHODS 
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
		Node<E> temp = head; 
		if(temp != null) {
			head = head.next; 
			size--; 
			return temp.data; 
		}
		return null;
	}

	// Sets new value in node at the given index 
	@Override
	public E set(int index, E newValue) {
		if(index < 0 || index > size) {
			System.out.println("ERROR[Invalid Index]"); 
			return null; 
		}
		Node<E> node = getNode(index); 
		Node<E> temp = node.next; 
		temp.data = newValue; 
		return temp.data; 
	}

	// Returns the size of the Linked List 
	@Override
	public int size() {
		return this.size;
	}

	// Implement the toString method to print the Linked List data
	public String toString() {
		String s = ""; 
		Node<E> p = head; 
		if(p != null) {
			while(p.next != null) {
				s += p.next.data + "\n"; 
				p = p.next; 
			}
		}
		return s; 
	}
}
