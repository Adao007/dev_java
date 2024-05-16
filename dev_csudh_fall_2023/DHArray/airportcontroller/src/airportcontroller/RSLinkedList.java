package airportcontroller;

public class RSLinkedList {
	
	// Flight Node Class for LinkedList
	private class Flight {
		private String uniqueId; 
		private boolean status; 
		private boolean priority; 
		private int timestamp; 
		private int runway; 			
		private Flight next; 
		private Flight prev;
		
		//Constructor for Head Flight Node
		public Flight(Flight next) {
			this.next = next;
			this.prev = null;
		}
	
		// Constructor for Flight Node Class
		public Flight(String uniqueId, boolean status, boolean priority, int timestamp, int runway, Flight next) {
			this.uniqueId = uniqueId; 
			this.status = status;
			this.priority = priority; 
			this.timestamp = timestamp; 
			this.runway = runway;
			this.next = next; 
		}
		
		// When only data is supplied and the next pointer is null.
		public Flight(String uniqueId, boolean status, boolean priority, int runway, int timestamp) {
			this(uniqueId, status, priority, timestamp, runway, null); 
		}
		
		public String getUniqueId() {
			return this.uniqueId;
		}
		
		public void setUniqueId(String uniqueId) {
			this.uniqueId = uniqueId;  
		}
		
		public boolean getStatus() {
			return this.status;
		}
		
		public int getTimestamp() {
			return this.timestamp;
		}
		public void setTimestamp(int timestamp) {
			this.timestamp = timestamp; 
		}
		
	}
	
	private Flight head; 			// Reference to the head of the linked list
	private Flight tail;			// Reference to the tail of the linked list
	private int size; 				// Variable to track the amount of nodes in the linked list
	private int runwayNumber; 		// Variable to track which runway to give to flights
	
	// Constructor for the Custom Linked List 
	// Default Constructor that creates and head node that points to Null 
	public RSLinkedList() {
		this.head = new Flight(null);
		this.tail = this.head;
		this.size = 0; 
		this.runwayNumber = 1; 
	}
	
	public void add(String uniqueId, boolean status, boolean priority, int timestamp) {
		// Check to see if index is valid 
		
		if(size == 0) {
			addFirst(uniqueId, status, priority, timestamp);										// Adds first flight onto the Linked List
		}
		else { 
			if(checkTime(timestamp) && priority) {													// checks time and priority 
				int position = getPosition(timestamp);
				reschedule(position); 																// reschedules flights to move priority flight into position
				addAfter(position, uniqueId, status, priority, timestamp, runwayNumber); 			// adds priority flight onto the Linked List
			}
			int position = getPosition(timestamp);							
			addAfter(position, uniqueId, status, priority, timestamp, runwayNumber); 				// adds non-priority flight onto the Linked List
		}
	}
	
	// Method to change timestamp if priority flight is added with conflicted times
	private void reschedule(int position) {
		Flight change = head; 
		for(int i = 0; i > position; i++) {
			change = change.next;
		}
		for(int i = position; i > size; i++) {
			change.setTimestamp(change.getTimestamp() + 5);
			change = change.next;
		}
	}
	
	// Method to check if there is conflicting times
	private boolean checkTime(int timestamp) {
		int tempTime = timestamp;
		Flight search = head;
		for(int i = 0; i < size; i++) {
			if(search.getTimestamp() == tempTime) {
				return true;
			}
		}
		return false;
	}

	// Method to get Position before adding methods
	private int getPosition(int timestamp) {
		
		int tempTime = timestamp; 
		int position = 0;
		Flight search = head; 
		
		for(int i = 0; i < size; i++) {
			if(tempTime < search.getTimestamp()) {
				position = i - 1; 
				return position; 
			}
			search = search.next;
			position = i; 
		}
		
		return position; 
	}
	
	// method to add flight nodes in between other flight nodes
	private void addAfter(int position, String uniqueId, boolean status, boolean priority, int timestamp, int runwayNumber) {
		Flight temp = new Flight(uniqueId, status, priority, timestamp, runwayNumber); 
		
		if(position == 1) {
			addFirst(uniqueId, status, priority, timestamp); 
		}
		else {
			Flight search = head; 
			for(int i = 1; i < position; i++) {
				search = search.next; 
				if( search == null ) {
					addEnd(uniqueId, status, priority, timestamp);
				}
				else {
					temp.next = search; 
					temp.prev = search.prev;
					search.prev.next = temp; 
					search.prev = temp; 
					size++;
				}
			}
		}
		
	}

	// method that adds to the end of the linked list
	private void addEnd(String uniqueId, boolean status, boolean priority, int timestamp) {
		Flight temp = new Flight(uniqueId, status, priority, timestamp, runwayNumber);
		if(tail == null) {
			head = temp; 
			tail = temp;
		}
		else {
			tail.next = temp; 
			temp.prev = tail; 
			tail = temp;
		}
		size++; 
		
	}
	
	// method that adds to the beginning position of the linked list
	private void addFirst(String uniqueId, boolean status, boolean priority, int timestamp) {
		// Adds first Flight Node to Linked List
		Flight temp = new Flight(uniqueId, status, priority, timestamp, runwayNumber);
		if(head == null) {
			this.head = temp; 
			this.tail = temp;
		}
		else {						// Else statement to add Flight Node to beginning if needed
			temp.next = head;
			head.prev = temp; 
			head = temp; 
		}
		size++; 
	}
	
	// remove method
	public void remove(String uniqueId) {
		if(head == null) {
			return; 				// Remove on empty linked list
		}
		
		int position = getPosition(uniqueId);
		// if statement to check if flight with inputted ID exists 
		if(position == -1) {
			System.out.println("No Flight with ID:" + uniqueId + " found on schedule!"); 
			return;
		}
		
		if(position == 1) {
			removeFirst(); 
			return;
		}
		
		Flight search = head; 
		for(int i = 1; i < position; i++) {
			search = search.next; 
		}
			
		if(search == tail) {
			removeEnd();
			return; 
		}
		
		search.prev.next = search.next;
		search.next.prev = search.prev;
		search.prev = null; 
		search.next = null;
		size--;
		
	}

	// Method to remove at the end of the linked list
	private void removeEnd() {
		// checks validity of remove operation
		if(tail == null) {
			return; 
		}
		
		// removes if there is only one flight on the list 
		if(head == tail) {
			head = null;
			tail = null; 
			size--;
			return; 
		}
		
		Flight temp = tail; 
		tail = tail.prev;
		tail.next = null;
		temp.prev = null; 
		size--;
	}

	private void removeFirst() {
		// Method to check Validity of remove operation
		if(head == null) {
			return;
		}
		
		if(head == tail) {
			head = null;
			tail = null;
			size--;
			return;
		}
		
		Flight temp = head; 
		head = head.next;
		head.prev = null;
		temp.next = null; 
		size--;
		
	}

	// Overloading Method to get position of flight with certain ID
	private int getPosition(String uniqueId) {
		String tempId = uniqueId; 
		int position = 0;
		Flight search = head; 
		
		for(int i = 0; i < size; i++) {
			if(tempId == search.getUniqueId()) {
				position = i; 
				return position; 
			}
			search = search.next;
			position = i; 
		}
		
		return -1; 
	}
	
	// toString for printing out the schedule
	public String toString() {
		String s = "";
		Flight p = head; 
		String action = null; 
		
		if(p != null) {
			for(int i = 0; i < size; i++) {
				
				if(p.getStatus()) {
					action = "Arriving"; 
				}
				else {
					action = "Departing"; 
				}
				s += "Flight " + i + "\n"; 
				s += "ID: " + p.getUniqueId() + " " + action + "  at" + p.getTimestamp() + " hours\n"; 
				
			}
		}
		return s;
	}
}