/*
 * 		REFERENCES 
 * 		METHOD - equals was formatted with the help of the following sources: 
 * 			- https://www.geeksforgeeks.org/overriding-equals-method-in-java/
 */
package edu.csudh.airline.boarding.project;

public class Passengers implements Comparable {
	// Data Members Start 
	
	private String firstName; 						// First Name of the Passenger 
	private String lastName; 						// Last Name of the Passenger 
	private String dateOfBirth; 					// Date of Birth of Passenger (Tells age, Defines Priority for Elderly) 
	private String boardingCategory;				// Higher Boarding Category reflects Lower Priority 
	private int arriveTime; 						// Notes the order of arrival time of passengers in the queue 
	private int priority; 							// Higher Priority given to Lower int number (1 is highest and 20 is lowest) 
	
	// Data Members End 
	
	// Constructor 
	public Passengers(String firstName, String lastName, String dateOfBirth, String boardingCategory) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.dateOfBirth = dateOfBirth; 
		this.boardingCategory = boardingCategory;  
		this.priority = determinePriority(boardingCategory); 
	}
	public Passengers(String firstName, String lastName, String dateOfBirth, String boardingCategory, int arriveTime) {
		this(firstName, lastName, dateOfBirth, boardingCategory); 
		this.arriveTime = arriveTime; 
	}
	
	public int determinePriority(String boardCategory) {
		int tempPriority; 
		
		// Control Statements to determine priority (sets tempPriority)
		if(boardingCategory.equals("Traveling With Infant")) { tempPriority = 1; }
		else if(boardingCategory.equals("Elderly")) { tempPriority = 5; }
		else if(boardingCategory.equals("Military")) { tempPriority = 10; }
		else if(boardingCategory.equals("First Class")) { tempPriority = 15; } 
		else { tempPriority = 20; } 
		
		return tempPriority;	// Return tempPriority to set Priority in Constructor
	}
	
	// SET METHODS START 
	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth; 
	}
	public void setBoardingCategory(String boardingCategory) {
		this.boardingCategory = boardingCategory; 
	}
	public void setArriveTime(int arriveTime) {
		this.arriveTime = arriveTime; 
	}
	public void setPriority(int priority) {
		this.priority = priority; 
	}
	// SET METHODS END
	
	// GET METHODS START 
	public String getFirstName() {
		return firstName; 
	}
	public String getLastName() {
		return lastName; 
	}
	public String getName() {
		return firstName + " " + lastName; 
	}
	public String getDateOfBirth() {
		return dateOfBirth; 
	}
	public String getBoardingCategory() {
		return boardingCategory; 
	}
	public int getArriveTime() {
		return arriveTime; 
	}
	public int getPriority() {
		return priority; 
	}
	// GET METHODS END 
	
	// ToString Method for printing out Passenger Information 
	public String toString() {
		String s = firstName + " " + lastName + ", Date of Birth: " + dateOfBirth; 
		return s; 
	}
	
	// equals Method for comparisons 
	public boolean equals(Object o) {
		// Checks if object is compared to itself
		if(o == this) { return true; }
		// Checks if object is of type Passenger
		if(!(o instanceof Passengers)) { return false; }
		// Variable that is set to o casted to Passengers 
		Passengers that = (Passengers) o; 
		// Tests First Name, Last Name, and DOB
		return this.firstName.equals(that.firstName) && this.lastName.equals(that.lastName) && this.dateOfBirth.equals(that.dateOfBirth); 
	}

	@Override
	public int compareTo(Object o) {
		// Checks if object is compared to itself
		if(o == this) { return 0; }
		// Checks if object is of type Passenger, if not return -1 for not equals
		if(!(o instanceof Passengers)) { return -1; }
		// Variable "that" is set to o casted to Passengers 
		Passengers that = (Passengers) o; 
		// Compares priority of passengers, returns positive int if greater than, 0 if equals, neg int if less than
		if(this.priority > that.priority) {
			return 1; 
		}
		else if(this.priority < that.priority) {
			return -1; 
		}
		else {
			if(this.arriveTime > that.arriveTime) {
				return 1;
			}
			else if(this.arriveTime < that.arriveTime) {
				return -1; 
			}
			else {
				return 0; 
			}
		}
	}
}

	
