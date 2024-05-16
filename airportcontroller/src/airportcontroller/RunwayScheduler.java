package airportcontroller;

/* 
 * REFERENCES: 
 *  
 * CODE FOR READING AND WRITING METHODS was learned from the following websites: 
 * https://www.w3schools.com/java/java_files_create.asp
 * https://www.w3schools.com/java/java_files_read.asp
 * https://www.w3schools.com/java/java_user_input.asp
 *  
 *  
 * CODE FOR CONVERTING STRINGS TYPE TO BOOL AND INT TYPES were learned from the following websites: 
 * https://www.javatpoint.com/java-string-to-boolean
 * https://www.javatpoint.com/java-string-to-int
 * 
 */

import java.io.File;
import java.util.Scanner; 			// Imported Scanner for User Input
import java.io.FileWriter; 

public class RunwayScheduler {
	private RSLinkedList Scheduler; 
	
	// Constructor for building the RunwayScheduler object!
	public RunwayScheduler() {
		Scheduler = new RSLinkedList(); 
	}
	
	// RunwayScheduler add method
	public void scheduleFlight(String uniqueId, boolean status, boolean priority, int timestamp) {
		Scheduler.add(uniqueId, status, priority, timestamp);
	}
	
	// RunwayScheduler remove method
	public void cancelFlight(String uniqueId) {
		Scheduler.remove(uniqueId);
	}
	
	// RunwayScheduler display method
	public void displaySchedule() {
		Scheduler.toString(); 
	}
	
	// RunwayScheduler readFromFile method
	public void readFromFile(String textFile) {
		try {
			File obj = new File(textFile);
			Scanner read = new Scanner(obj);
			while(read.hasNextLine()) {
				String uniqueId = read.nextLine(); 
				boolean status = Boolean.parseBoolean(read.nextLine()); 
				boolean priority = Boolean.parseBoolean(read.nextLine()); 
				int timestamp = Integer.parseInt(read.nextLine()); 
				scheduleFlight(uniqueId, status, priority, timestamp); 
			}
			read.close(); 
		} 
		catch(Exception e) {
			System.out.println("File not found!"); 
		}
		
	}
	
	// Runway Scheduler writeToFile method
	public void writeToFile(String textFile) {
		try {
			File obj = new File(textFile); 
			if(obj.createNewFile()) {
				System.out.println("Schedule created: " + obj.getName());
			}
			else {
				System.out.println("Schedule already exists");
			}
			
		}
		catch(Exception e) {
			System.out.println("An error occured while trying to write to file"); 
		}
		
		try {
			FileWriter writer = new FileWriter(textFile); 
			writer.write(Scheduler.toString());
			writer.close(); 
			System.out.println("Successfully wrote to the file"); 
		} 
		catch (Exception e) {
			System.out.println("An error occured!"); 
		}
	}
}
