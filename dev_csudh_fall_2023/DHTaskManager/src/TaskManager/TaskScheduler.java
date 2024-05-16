package TaskManager;
/*	
 * 
 *  LINES: 236 - 258 
 * 	Quicksort code creating from using Quicksort guide from 
 * 	geeksforgeeks.org/quick-sort/ 
 * 	Adjusted for sorting priority data inside Task Objects 
 * 			
 */


// TaskScheduler Class handles and manages data structures 
public class TaskScheduler {
	
	// Data Node for Stack Undo Option 
	private class StackNode {
		private Task item; 
		private int position; 
		private undo marker;
		
		// Constructor for empty StackNode
		public StackNode() { }
		
		// Constructor for node with marker only 
		public StackNode(undo marker) {
			this.marker = marker; 
		}
		
		// Constructor for add methods 
		public StackNode(Task item, undo marker) {
			this(marker); 
			this.item = item; 
		}
		
		// Constructor for (UNDO) removeSearchedTask and completedTask
		public StackNode(Task item, int position, undo marker) {
			this(item, marker); 
			this.position = position; 
		}
		// CONSTRUCTORS END
		
		// GET METHODS FOR STACKNODE 
		public Task getItem() { return this.item; }
		public int getPosition() { return this.position; }
		public undo getMarker() { return this.marker; }
		// SET METHOD FOR Position variables - for undo removes and undo completed(s) actions
		public void setItem(Task item)  { this.item = item; } 
		public void setMarker(undo marker) { this.marker = marker; }
		public void setPosition(int position) { this.position = position; 
		}
	}
	
	// Private Data Structures
	private CircularQueue<Task> toDoList;										// Queue for toDoList
	private SingleLinkedList<Task> completedList; 								// Linked List for completedList		
	private UndoStack<StackNode> undoStack; 									// Stack for undoStack (holds Tasks 
	//private UndoStack<undo> undoMarker;										// Stack for calling undo operations 
	// Variable for user-defined markers for undo method?
	private static final int DEFAULT_CAPACITY = 20;								// DEFAULT CAPACITY set to project defined capacity of [20] 
															
	
	// Default Constructor with DEFAULT CAPACITY
	public TaskScheduler() {
		this.toDoList = new CircularQueue<Task>(this.DEFAULT_CAPACITY);
		this.completedList = new SingleLinkedList<Task>(); 
		this.undoStack = new UndoStack<StackNode>(this.DEFAULT_CAPACITY); 
		//this.undoMarker = new UndoStack<undo>(this.DEFAULT_CAPACITY);
	}
	
	// Constructor with User Defined Capacity
	public TaskScheduler(int capacity) {
		this.toDoList = new CircularQueue<Task>(capacity); 
		this.completedList = new SingleLinkedList<Task>(); 
		this.undoStack = new UndoStack<StackNode>(capacity); 
		//this.undoMarker = new UndoStack<undo>(capacity); 
	}
	
	// ADDS E to "to-do-list"
	public void addTask(Task Task) { 
		StackNode temp = new StackNode(Task, undo.ADD); 
		toDoList.enqueue(Task);													// adds Tasks to the back of toDoList Queue
		undoStack.push(temp);													// pushes Task onto the stack for undo option 
		//undoMarker.push(undo.ADD); 											// pushes marker for undo operation option
	} 

	// REMOVES Task from "to-do-list" 
	public void removeTask() {
		if(toDoList.isEmpty()) {												// Checks to see if to-do-list is empty
			System.out.println("ERROR: To-Do-List is currently empty!"); 
			return; 
		}
		frontRemove(); 															
	}
	
	// Overloaded Method for removing Task based on name
	public void removeTask(String taskName) {
		if(toDoList.isEmpty()) {												// Checks to see if to-do-list is empty
			System.out.println("ERROR: To-Do-List is currently empty!"); 
			return; 
		}
		idRemove(taskName); 
	}
	
	private void idRemove(String taskName) {
		StackNode tempNode = new StackNode(undo.IDREMOVE);						// Create StackNode with marker for undo ID REMOVE
		Task tempTask; 															// Create tempTask to evaluate tasks in "To Do List" 
		Boolean found = false; 													// Variable to set if task is found or not
		
		for(int i = 0; i < toDoList.getSize(); i++) {							// For Loop searches "To Do List" 
			tempTask = toDoList.dequeue(); 
			if(tempTask.getName().equals(taskName)) {								// If task is found: continue setting StackNode with data
				tempNode.setItem(tempTask);
				tempNode.setPosition(i + 1);									// Sets Position to i (+ 1 to adjust the post increment). 
				found = true; 													// Set boolean found to true
			}
			else { toDoList.enqueue(tempTask); }								// add task back into queue // If task found skip enqueue task step
		}
		
		if(found == true) {	undoStack.push(tempNode); }							// If remove task is found -> Push StackNode onto undoStack
		else { System.out.println("ERROR: Task not found!"); }					// Return Error not found message if Task not found
	}

	private void frontRemove() {
		Task tempTask = toDoList.dequeue(); 									// Removes Task in front of the "to-do-list" Queue
		StackNode tempNode = new StackNode(tempTask, undo.FRONTREMOVE); 		
		undoStack.push(tempNode);												// Stores Removed Task for undo option 
		//undoMarker.push(undo.FRONTREMOVE);									// Stores marker for undo operation
		
	}

	public void completeTask() {
		StackNode tempNode = new StackNode(toDoList.dequeue(), undo.COMPLETE);	// Creates a StackNode with the COMPLETE marker and task in front of the queue
		completedList.add(0, tempNode.getItem());								// Adds Task from the front of the queue(To Do List) to the completed list
		undoStack.push(tempNode);												// Push StackNode on undoStack
	}
	
	// UNDO METHODS START 
	public void undoTask() {
		StackNode analysis = undoStack.pop(); 									// Creates a StackNode variable that evaluates node for undo method
 
		switch (analysis.getMarker()) {
			case ADD: 															// Case 1: Calls for undo ADD method
				undoADD(); 
				break; 
			
			case FRONTREMOVE: 													// Case 2: Calls for undo REMOVE (from front of queue) method
				undoFrontRemove(analysis.getItem()); 
				break; 
				
			case IDREMOVE:														// Case 3: Calls for undo REMOVE (from found position in queue) method
				undoIdRemove(analysis.getItem(), analysis.getPosition()); 
				break; 
				
			case COMPLETE: 														// Case 4: Calls for undo COMPLETE method
				undoCompleteTask(analysis.getItem()); 												
				break; 
		}
		
	}
	
	// UNDOTask HELPER METHODS START 
	private void undoADD() {
		Task current = null; 
		int queueSize = toDoList.getSize(); 
		
		for(int i = 0; i < queueSize - 1; i++) {								// For Loop with toDoList's size to dequeue and enqueue all elements besides the last element. 
				current = toDoList.dequeue(); 
				toDoList.enqueue(current);
			}
			toDoList.dequeue(); 												// Last element (now in front of the queue) is dequeued out
	}
	
	
	private void undoFrontRemove(Task Task) {
		Task current = null; 
		int queueSize = toDoList.getSize(); 
		
		toDoList.enqueue(Task); 												// Re-adds item to the queue 
		for(int i = 0; i < queueSize; i++) {									// For loop positions item back to the front of the queue. 
			current = toDoList.dequeue();
			toDoList.enqueue(current); 
		}
		
	}
	
	private void undoIdRemove(Task task, int position) {
		Task reAddTask = task; 													// Sets to task for re-adding 
		Task tempTask; 
		
		if(toDoList.isEmpty()) { toDoList.enqueue(reAddTask); }					// Handles case if To Do List is empty 
			
		for(int i = 0; i < toDoList.getSize(); i++) {							// For Loop cycles thru To Do List
			tempTask = toDoList.dequeue();
			if(i == position) {	toDoList.enqueue(reAddTask); }					// Re adds Task at correct position
			toDoList.enqueue(tempTask); 										// Adds back Cycled Tasks
		}
	}
	
	private void undoCompleteTask(Task task) {
		completedList.remove(0); 												// Removes Task Recently Completed
		undoFrontRemove(task); 													// Calls undoFrontRemove to re add task to front of the queue
	}
	// UNDOTask METHODS END
	
	// SORTING METHODS 
	public void sortTasks() {
		Task [] sortArray;														// Declared array to be sorted
		int size; 																// Get size of toDoList
		if(toDoList.isEmpty()) {												// Checks to see if To Do List is empty
			System.out.println("To-Do-List is currently empty!"); 
			return; 
		}
		System.out.println("SORTING TO-DO-LIST!!!"); 
		sortArray = queueToArray(); 
		size = sortArray.length; 
		quickSort(sortArray, 0, size - 1); 
		arrayToQueue(sortArray); 
		System.out.println("To-Do-List Sorted"); 
	}
	
	// Places to-do-list tasks into array for sorting
	private Task[] queueToArray() {												
		Task[] tempArray = new Task[toDoList.getSize()]; 
		int size = toDoList.getSize();
		for(int i = 0; i < size; i++) {
			tempArray[i] = toDoList.dequeue();
		}
		return tempArray; 
	}
	
	// After array is sorted, Re-add sorted tasks to the "To-Do-List" 
	private void arrayToQueue(Task[] array) {
		Task[] tempArray = array; 
		for(int i = 0; i < array.length; i++) {
			toDoList.enqueue(tempArray[i]);
		}
	}
	
	private void quickSort(Task array[], int lowest, int highest) { 
		if(lowest < highest) {													// Base case to end recursive call - end when lowest is > highest 
			int pivot = partition(array, lowest, highest); 						// Set pivot variable to function call (partition)
			
			quickSort(array, lowest, pivot - 1); 								// Sorts 
			quickSort(array, pivot + 1, highest); 
		}
	}
	
	private int partition(Task[] array, int lowest, int highest) {				
		int pivot = array[highest].getPriority(); 								// Chooses a Median Pivot 
																				// Set pivot to item's priority 
		int i = lowest - 1; 													// Set for smaller priority tasks 
		
		for(int j = lowest; j <= highest - 1; j++) {							// Compares priority between tasks
			if (array[j].getPriority() < pivot) { 
				i++;
				swap(array, i, j); 												// If task is < pivot swap to smaller
			}
		}
		swap(array, i + 1, highest); 											// If task is > pivot swap to larger
		return(i + 1); 
	}

	// HELPER FUNCTION - SWAPS TASKS 
	private void swap(Task[] array, int i, int j) {
		Task tempTask = array[i]; 
		array[i] = array[j]; 
		array[j] = tempTask; 
	}

	// Method to display lists: TO-DO-LIST, COMPLETED-LIST, OR BOTH
	public String displayTask(int list) {
		switch(list) {
			case 1 : 															// input "1" returns TO-DO-LIST
				if(toDoList.isEmpty()) {
					return "To-Do-List is currently empty!"; 
				}
				System.out.println("TO-DO-LIST"); 
				return toDoList.toString(); 
			case 2 : 															// input "2" returns COMPLETED-LIST
				if(completedList.size() == 0) {
					return 	"No Tasks completed yet! Completed-List is empty!"; 
				}
				System.out.println("COMPLETED-LIST"); 
				return completedList.toString(); 
			default : 															// invalid input given! 
				return "ERROR: input not found!"; 
		}
	}
	
}
