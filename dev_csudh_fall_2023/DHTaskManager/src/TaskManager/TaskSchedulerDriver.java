package TaskManager;
/* 
 * 		Lines: 163 - 187 SCANNER READFROMFILE CODE WRITTEN WITH HELP OF 
 * 		https://www.youtube.com/watch?v=i9FGIlqUEtw - Dr. Andy Wicks
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner; 

public class TaskSchedulerDriver {

	public static void main(String[] args) {
		// CREATE SCHEDULER of CLASS TASKSCHEDULER THAT MANAGES DATA STRUCTURES 
		// SCHEDULER CONTAINS "TO-DO-LIST" Queue, "COMPLETED-TASK" LinkedList, "UNDO" Stack
		TaskScheduler scheduler = new TaskScheduler(); 
		Boolean running = true; 														// Boolean Variable for control system for Task Scheduler program
		Scanner scan = new Scanner(System.in); 
		int option; 
		// 1. CREATE A LINKED LIST THAT INITIALIZE FROM A PRE-POPULATED FILE
		// Then, LINKED LIST used to populate the "To Do List" Queue. 
		scheduler = loadToDoList(scheduler);
		System.out.println("Welcome to the DH Task Scheduler!"); 
		
		while(running) {
			displayOptions(); 
			option = scan.nextInt(); 
			
			// SWITCH CONTROL HANDLES OPTION SELECTION 
			switch(option) {
				case 01:	// ADDS TASK
					System.out.print("Enter task name: "); 
					String Name = scan.next(); 
					System.out.print("Enter priority level: ");
					int priority = scan.nextInt(); 
					System.out.print("Enter due date: ");
					String dueDate = scan.next();
					scheduler.addTask(new Task(Name, priority, dueDate));
					System.out.println("ADDED TASK!!!"); 
					break; 
					
				case 02: 	// REMOVES FRONT TASK OR SEARCHES FOR
					System.out.print("Enter 01: to Remove Queued Task || Enter 02: Remove by Name: ");
					option = scan.nextInt(); 
					if (option == 1) {
						scheduler.removeTask();
						System.out.println("REMOVED TASK");
						} 
					else if(option == 2) {
						System.out.print("Enter Name of Task to be removed: ");
						String name = scan.next();
						scheduler.removeTask(name);
						System.out.println("REMOVED TASK");
					}
					else {
						System.out.println("ERROR: INVALID INPUT!!!!"); 
					}
					break; 
					
				case 03:	// COMPLETES TASK IN FRONT OF QUEUE(TO-DO-LIST) ADDS TO COMPLETED-LIST
					scheduler.completeTask(); 
					break; 
				case 04:	// UNDOS PREVIOUS OPTIONS (O1 - 02 - 03)
					scheduler.undoTask();
					break; 
				case 05: 	// SORTS TO-DO-LIST
					scheduler.sortTasks(); 
					break; 
				case 06: 	// DISPLAY TO-DO-LIST, COMPLETED-LIST, OR BOTH
					System.out.println("Enter 01: Display To-Do-List || Enter 02: Display Completed-List || Enter 03: Display Both "); 
					option = scan.nextInt(); 
					if(option == 1 || option == 2) {
						System.out.println(scheduler.displayTask(option)); 
					}
					else if(option == 3) {
						System.out.println(scheduler.displayTask(1));
						System.out.println(scheduler.displayTask(2)); 
					}
					else {
						System.out.println("INVALID INPUT!!!!");
					}
					break; 
				case 07: 	// ENDS TASK SCHEDULER
					running = false; 
					break; 
				default: 
					System.out.println("Invalid Option! Input an option 01 - 07!"); 
			}
	
		}
		
		
		
		
	}

/*
 * 			FUNCTIONAL PROGRAMMING COMMENTED OUT
 * 			ERROR WITH SCANNER 
 * 			IMPLEMENT ANOTHER TIME
 * 
	private static void exit() {
		// TODO Auto-generated method stub
		
	}

	private static void displayLists() {
		// TODO Auto-generated method stub
		
	}

	private static void sortList() {
		// TODO Auto-generated method stub
		
	}

	private static void undoOption() {
		// TODO Auto-generated method stub
		
	}

	private static void completeTask() {
		// TODO Auto-generated method stub
		
	}

	private static void removeTask() {
		// TODO Auto-generated method stub
		
	}
*/

/*
 * 			FUNCTIONAL PROGRAMMING ERRORS!!! 
 * 			COMMENTED OUT
 * 
	private static TaskScheduler addTask(TaskScheduler scheduler) {
		Scanner scan = new Scanner(System.in); 
		int count; 
		System.out.print("Enter a Name for Task: "); 
		String name = scan.next(); 
		System.out.print("Enter a priority level 01 - 100 (Lower number is higher priority): ");
		int priority = Integer.parseInt(scan.next()); 
		System.out.print("Enter the due date for task: ");
		String dueDate = scan.next(); 
		scan.reset();
		scan.close();
		scheduler.addTask(new Task(name, priority, dueDate));
		return scheduler; 
	}
	
*/	
	// METHOD PASSING IN NAME OF FILE TO READ FROM 
	// UPDATE FOR FUTURE USE
	public static TaskScheduler loadToDoList(TaskScheduler scheduler) { 
		SingleLinkedList <Task> loadList = readFromFile("listoftasks.txt"); 	
		System.out.println("LOADING TASKS FROM FILE!!!");
		for(int i = 0; i < loadList.size(); i++) {
			scheduler.addTask(loadList.get(i));
		}
		return scheduler;
	}
	
	// READ FROM FILE METHOD
	public static SingleLinkedList readFromFile(String textFile) {
		SingleLinkedList <Task> loadList = new SingleLinkedList(); 						// Linked List for reading in Tasks from a pre-populated file. 
		String taskName; 
		int priority;
		String dueDate; 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(textFile)); 
			String line = null; 
			
			while ((line = reader.readLine()) != null) {								// Reads while text file has lines to read 
				String temp[] = line.split("\t"); 										// Array of different string that uses tab as a delimiter
				taskName = temp[0]; 													// Stores taskName 
				priority = Integer.parseInt(temp[1]); 									// Stores priority level after changing it to an integer
				dueDate = temp[2];														// Stores dueDate 
				
				Task loadTask = new Task(taskName, priority, dueDate); 					// creates a task with read in data
				loadList.add(0, loadTask);												// adds task to linked list for loading "To-Do-List" 
			}
			reader.close(); 
	} catch(IOException e) {
		e.printStackTrace();
		}
		
		return loadList; 
	}
	
	// USER INTERFACE METHODS START
	public static void displayOptions() {
		System.out.printf("--------------------------------------------------%n"); 
		System.out.printf("| CSUDH Project 02: Task Scheduler Options       |%n"); 
		System.out.printf("| Select an options below                        |%n");
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("| %-6s | %-37s |%n", "OPTION", "SELECT"); 
		System.out.printf("--------------------------------------------------%n");
		System.out.printf("| %-6s | %-37s |%n", "01", "ADD TASK");
		System.out.printf("| %-6s | %-37s |%n", "02", "REMOVE TASKS");
		System.out.printf("| %-6s | %-37s |%n", "03", "COMPLETE TASK");
		System.out.printf("| %-6s | %-37s |%n", "04", "UNDO PREVIOUS OPTION(01, 02, or 03)");
		System.out.printf("| %-6s | %-37s |%n", "05", "SORT TO-DO-LIST");
		System.out.printf("| %-6s | %-37s |%n", "06", "DISPLAY LIST(S)");
		System.out.printf("| %-6s | %-37s |%n", "07", "EXIT SCHEDULER");
		System.out.printf("--------------------------------------------------%n");
		
	}
}

