package runwayScheduler;

public class Flight {

	private int flightID; // Using an increasing integer-type range for unique IDs.
	private boolean status;
	private boolean priority; // true to determine if flight is priority.
	private int timestamp;
	private int runway;

	public Flight(int flightID, boolean status, boolean priority, int timestamp, int runway) {

	this.flightID = flightID;
	this.status = status;
	this.priority = priority;
	this.timestamp = timestamp;
	this.runway = runway;

	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	// Method to change time if schedule changes
	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setRunway(int runway) {
		this.runway = runway;
	}

	public int getFlightID() {
		return this.flightID;
	}

	public boolean getStatus() {
		return this.status;
	}

	public boolean getPriority() {
		return this.priority;
	}

	public int getTimestamp() {
		return this.timestamp;	
	}
	
	public int getRunway() {
		return this.runway; 
	}

}