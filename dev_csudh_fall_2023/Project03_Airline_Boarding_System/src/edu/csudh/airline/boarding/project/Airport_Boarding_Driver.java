/* 
 * 			REFERENCES 
 * 			METHOD - getTime() learned from the following sources: 
 * 				- https://stackoverflow.com/questions/833768/java-code-for-getting-current-time
 * 				- https://en.wikipedia.org/wiki/List_of_tz_database_time_zones
 * 				- https://www.baeldung.com/java-format-zoned-datetime-string
 * 
 * 			Hashtable Code - learned from the following source: 
 * 				- https://docs.oracle.com/javase/8/docs/api/java/util/Hashtable.html
 * 
 * 			METHOD - loadCheckInLine() was learned from the following source
 * 				- https://www.youtube.com/watch?v=klCmA2Eeu70&t=425s
 */

package edu.csudh.airline.boarding.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
//import java.util.Hashtable;
import java.util.Scanner;

public class Airport_Boarding_Driver {
	
	public static void main(String[] args) {
		String startTime = getTime(); // Gets Real-Time PST
		int time[] = {getHour(startTime.substring(13, 15)), getMins(startTime.substring(16, 18)), getSecs(startTime.substring(19, 21))};  
		int checkingInTime = 0;			// Variable for checking in timer
		int boardingTime = 0; 			// Variable for boarding timer
		int arrivalOrder = 0;			// Logs order that passengers check in (arrived) 
		Passengers checkingIn = null; 	// Boolean Variable for checking if there are passengers still checking in 
		Passengers boarding = null;  	// Boolean Variable for checking if there are passengers still boarding
		// DATA STRUCTURES 
		PriorityQueue<Passengers> boardingQueue =  new PriorityQueue<Passengers>(15);				// Orders arriving passengers for boarding based on priority
		CircularQueue<Passengers> checkInLine = new CircularQueue<Passengers>(15);  				// Queue for line of arriving passengers.
		HashTable<String, Passengers> passengerList = new HashTable<String, Passengers>(61); 		// Hash-table for searching for passengers on plane. 
		
		checkInLine = loadCheckInLine("passengers.txt");	// Loads checkInLine from readfromfile method
		boardingStart(); 	// Output Message for program start 
		
		while(true) {
			// Passengers are checking in 
			if(!checkInLine.isEmpty() || checkingIn != null) {	// If check in line is not empty or checkIn has a passenger still checking in. 
				if(checkingInTime == 0 && !checkInLine.isEmpty()) { // If checkInTime is 0 (no one is checking in) AND the Line is not empty
					checkingIn = checkInLine.poll(); // Passenger in the front of the line is removed from line to be checked in
					System.out.println(checkingIn.getName() + " is checking in...."); // Logs passenger removal from check-in line
				}
				
				checkingInTime++;  // Updates time ticks for time it takes to help someone check in
				
				if(checkingInTime == 10) {	// Once check in time equals 10 - Check In Completed
					System.out.println();
					System.out.println("--- Passenger has completed check-in ---"); // Logs passenger check in completed
					checkInComplete(checkingIn, boardingQueue, arrivalOrder++, time); // adds checked in passenger to boading queue 
					checkingInTime = 0; // Reset checkingin Timer
					checkingIn = null;  // Set checkingIn variable to null (checkin help complete, ready for next passenger)
				}
			}
			
			// Passengers are boarding 
			if(!boardingQueue.isEmpty() || boarding != null) {	// If boardingQueue is not empty OR someone is still boarding 
				if(boardingTime == 0 && !boardingQueue.isEmpty()) {	// If boarding timer is 0 AND boarding queue is not empty
					boarding = boardingQueue.poll(); // remove passenger from boarding queue to boarding variable 
					System.out.println(boarding.getName() + " is boarding...."); // Logs passengers that are currently boarding
				}
				boardingTime++;	// Updates time ticks - for passenger boarding
				if(boardingTime == 20) { // Boarding takes 20 seconds to complete - Boarding Completed
					System.out.println();
					System.out.println("--- Passenger has completed boarding ---"); // Logs passenger boarding completed
					boardingComplete(boarding, passengerList, time); // adds boarded passenger to hashtable for searching
					boardingTime = 0; // Resets boarding time
					boarding = null; // Set boarding variable to null (boarding complete, ready for next passenger to board
				}
			}
			// Once check-in line and boarding queue is empty, end boarding  
			if(checkInLine.isEmpty() && boardingQueue.isEmpty()) {
				if(boarding == null) {	// Makes one last check to see if there is a passenger still boarding 
					break; // END PLANE CHECK IN AND PLANE BOARDING 
				}
			}
		}
		boardingEnd(); // Outputs boarding ending message and asks user if they would like to search plane 
		airlineSearch(passengerList); 	// Calls airline Search method 
	}
	
	private static void airlineSearch(HashTable<String, Passengers> passengerList) {
		Scanner s = new Scanner(System.in); 
		// While loop: Asking user if they want to search for passengers on the plane
		while(true) {
			String input = s.nextLine(); // Takes in user-input
			if(yes(input)) { // Checks for yes values
				//s.close(); // Closes scanner 
				search(passengerList); // Call search method if yes
				break; // end while loop
			}
			else if(no(input)) { // Takes in user-input
				//s.close(); // Closes scanner
				System.out.println("Airline Boarding Program exiting!"); // Outputs programming exiting message 
				break; // end while loop
			}
			else { // Invalid user input, ask user for valid input
				System.out.print("Invalid input: Please enter valid input. Would you like to search PassengerList?(Yes/No): "); 
			}
		}
	}

	private static void search(HashTable<String, Passengers> passengerList) {
		Scanner s = new Scanner(System.in);  
		System.out.println("Welcome to the Airline Passenger Search List! If you would like to exit out -> enter exit."); 
		
		while(true) {
			System.out.print("Please enter full name of passenger to search for: ");	// Asks user for name to be searched for 
			String name = s.nextLine(); // Takes in user-input
			
			if(passengerList.containsKey(name)) { // If hashtable contains name: return true.
				System.out.println(name + " is currently boarded!"); 
			}
			else if(exitCheck(name)) { // If user inputs exit, exit
				System.out.println("Exiting Airline Searching Program! Goodbye!"); 
				break; 
			}
			else { // invalid user input, try again
				System.out.println(name + " was not found on passenger-list!"); 
			}
		}
	}

	// checks for exit values
	private static boolean exitCheck(String searchName) {
		switch(searchName) {
			case "exit": 
			case "Exit": 
			case "EXIT": 
			case "e": 
				return true; 
			default: 
				return false;
		}
	}

	// checks for no values
	private static boolean no(String searchName) {
		switch(searchName) {
		case "no":
		case "No": 
		case "n": 
		case "N": 
			return true;
		default:  
			return false; 
	}
	}

	// Method for taking in yes values
	private static boolean yes(String searchName) {
		switch(searchName) {
			case "yes":
			case "Yes": 
			case "y": 
			case "Y": 
				return true;
			default:  
				return false; 
		}
	}

	private static <E extends Comparable> void boardingComplete(Passengers boarding, HashTable<String, Passengers> passengerList, int[] time) {
		String passenger = boarding.getName(); 								// Set passenger key for hashtable 
		System.out.println(boarding.toString() + " boarded at " + checkTime(time, 20)); 
		System.out.println("---------------------------------------------------------\n");
		passengerList.put(passenger, boarding); 							// Inputs passengers in Hash-table 
		
	}

	private static <E extends Comparable> void checkInComplete(Passengers checkIn, PriorityQueue<Passengers> boardingQueue, int arrivalOrder, int[] time) {
		checkIn.setArriveTime(arrivalOrder);													// Set Arrival Time 
		System.out.println(checkIn.toString() + " arrived at " + checkTime(time, 10));			// Logs passengers in order arrived 
		System.out.println("------------------------------------------------------------\n");
		boardingQueue.offer(checkIn); 																// Adds checked-in passengers to PriorityQueue 
	}

	// getTime Method calls ZoneId, ZoneDateTime, and format.DateTimeFormatter from the java.time import 
	public static String getTime() {
		
		ZoneId zoneId = ZoneId.of("America/Los_Angeles"); 													// Sets Time Zone ID to LA time 
		ZonedDateTime zdt = ZonedDateTime.now(zoneId); 														// Gets Current Time of Zone ID		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss z"); 				// Formats Date Time to Pattern
		String formattedString = zdt.format(formatter); 													// Converts objects to String 
		return formattedString; 																			// Returns String 
	}
	
	// SUBSTRING OF HOUR (13, 15)
	public static int getHour(String time) {
		int hour = Integer.parseInt(time); 		// Converts hour of startTime to int 
		return hour; 
	}
	
	// SUBSTRING OF MINS(16, 18)
	public static int getMins(String time) {	// Converts mins of startTime to int
		int mins = Integer.parseInt(time); 
		return mins; 
	}
	
	// SUBSTRING OF SECS(19, 21)
	public static int getSecs(String time) {	// Converts secs of startTime to int
		int secs = Integer.parseInt(time); 
		return secs; 
	}
	
	// Sets for new time for program's passed time
	public static String checkTime(int [] time, int passed) {
		time[2] += passed;
		if(time[2] >= 60) {
			time[2] -= 60; 
			time[1] += 1; 
		}
		if(time[1] >= 60) {
			time[1] -= 60; 
			time[0] += 1;
		}
		if(time[0] > 24) {
			time[0] -= 25; 
		}
		
		String s = time[0] + ":" + time[1] + ":" + time[2]; 
		return s; 
	}
	
	// Loads check in line from readinfile. 
	public static CircularQueue<Passengers> loadCheckInLine(String fileName) {
		CircularQueue<Passengers> checkInLine = new CircularQueue<Passengers>(15); 
		
		try {
			File file = new File(fileName); 
			Scanner s = new Scanner(file); 
		
			while(s.hasNextLine()) {
				String line = s.nextLine(); 
			
				String[] items = line.split("\\|");	// Splits the characters on the | 
			
				String firstName = items[0]; 
				String lastName = items[1]; 
				String dateOfBirth = items[2]; 
				String boardingCategory = items[3]; 
				
				Passengers p = new Passengers(firstName, lastName, dateOfBirth, boardingCategory); 
				checkInLine.offer(p); 
			}
		} catch(FileNotFoundException e) {
			System.err.println("ERROR: File not found!"); 
		}
		
		return checkInLine; 
	}
	
	// BOARDING MESSAGES 
	public static void boardingStart() {
		System.out.println("Welcome to Airline Boarding Program! Prepare for boarding, please form a line for check-in!!!"); 
		System.out.println("System Log: Passengers arriving and boarding as follows ---\n");
	}
	
	public static void boardingEnd() {
		System.out.println("Check-in and Boarding have now completed! Closing Cabin Doors!"); 
		System.out.print("Would your like to check flight for passengers?(Yes/No): "); 
	}

}
