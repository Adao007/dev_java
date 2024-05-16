package airportcontroller;

import java.util.Scanner; 

public class RSDriver {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in); 
		RunwayScheduler scheduler = new RunwayScheduler();  		// Makes an instance of RunwayScheduler class 
		boolean breaker = true;										// Bool Variable for controlling switch statement 
		
		System.out.println("Welcome the the Runway Scheduler!"); 
		
		
		//System.out.print("Would you like to load any files to the Scheduler? Press 1 for Yes! Press 2 for No!: "); 
		//while(true) {
			
			//int input = obj.nextInt(); 
			
			//if(input == 1) {
				//System.out.println("Enter name of file you would like to read: "); 
				//String name = obj.nextLine(); 
				//scheduler.readFromFile(name); 
			//}
			//else if (input == 2) {
				//break; 
			//}
			//else {
				//System.out.println("Please try again, enter Yes or No to continue!"); 
			//}
		
		// Temp readFromFile Code
		System.out.println("READING FROM FILES!"); 
		scheduler.readFromFile("existingschedule.txt");
		
		while(breaker) {
			System.out.println("Press 1 to Schedule a Flight"); 
			System.out.println("Press 2 to Cancel a Flight"); 
			System.out.println("Press 3 to Display the current schedule"); 
			System.out.println("Press 4 to Print out the current schedule"); 
			System.out.println("Press 5 to exit"); 
		
			int option = obj.nextInt(); 
		
			// Switch controlflow for options chosen by user
			switch(option) {
				case 1: scheduling(scheduler); 
					break; 
				case 2: cancelling(scheduler); 
					break; 
				case 3: displaying(scheduler); 
					break;
				case 4: printing(scheduler);
					break; 
				case 5: breaker = false; 
					break;
				default: System.out.println("Invalid option!"); 
			}
		}
		obj.close(); 
	}

	// Calls RunwayScheduler's writeToFile method
	private static void printing(RunwayScheduler schedule) {
		Scanner scan = new Scanner(System.in); 
		System.out.print("What would you like to name the schedule?: ");
		String name = scan.nextLine(); 
		schedule.writeToFile(name); 
		scan.close();
		
	}
	
	// Calls RunwayScheduler's displaySchedule method
	private static void displaying(RunwayScheduler schedule) {
		schedule.displaySchedule(); 
		
	}
	
	//Calls RunwayScheduler's cancelFlight method
	private static void cancelling(RunwayScheduler schedule) {
		Scanner scan = new Scanner(System.in);
		System.out.print("What is the ID of the Flight you would like to cancel?: ");
		String name = scan.nextLine();
		schedule.cancelFlight(name);
		scan.close();
		
	}
	
	// Calls RunwayScheduler's scheduleFlight method
	private static void scheduling(RunwayScheduler schedule) {
		Scanner scan = new Scanner(System.in); 
		System.out.print("First, what is the name of the Flight?: ");
		String uniqueId = scan.nextLine(); 
		System.out.print("Is your Flight Arriving? Enter(true/false): ");
		boolean status = scan.nextBoolean(); 
		System.out.print("Is your Flight a priority Flight? Enter(true/false): "); 
		boolean priority = scan.nextBoolean(); 
		System.out.print("What time does your flight need to use the runway?(Enter between [0000 - 2400] hours): "); 
		int timestamp = scan.nextInt(); 
		
		schedule.scheduleFlight(uniqueId, status, priority, timestamp); 
		scan.close(); 
		
		
		
	}
}
	


