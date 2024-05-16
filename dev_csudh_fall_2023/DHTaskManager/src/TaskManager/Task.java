package TaskManager;

public class Task {

	private String taskName;				// Unique identifier for the task
	private int priority; 					// Priority level (lower value indicates higher priority level)
	private String dueDate; 				// Indicating a date when the task is due. (Month - Day - Year) 
	
	// Constructor for task class 
	public Task () { }; 
	
	public Task(String taskName) {
		this.taskName = taskName; 
	}
	
	public Task(String taskName, int priority) {
		this(taskName);
		this.priority = priority; 
		
	}
	
	public Task (String taskName, int priority, String dueDate) {
		this(taskName, priority);
		this.dueDate = dueDate; 
	}
	
	// GET METHODS for taskName, priority, and dueDate
	public String getName() {
		return this.taskName; 
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public String getdueDate() {
		return this.dueDate; 
	}
	
	// GET METHODS END
	
	// SET METHODS 
	public void setName(String taskName) {
		this.taskName = taskName; 
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate; 
	}
	
	// SET METHODS END
	
	// Comparing METHODS 

	// Implement toString method to print out task class content
	public String toString() {
		//Set s equal to TaskName, Priority, and DueDate 
		String s = "Task:" + this.taskName + " \tPriority-Level:" + 
					this.priority + " \tDue:" + this.dueDate;  
		
		return s; 
	}
}
