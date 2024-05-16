package runwayScheduler;

public class RunwayScheduler <A> {
	
	private int uniqueCounter; 
	private RSLinkedList<Flight> schedule;
	
	public RunwayScheduler() {
		uniqueCounter = 0;
		schedule = new RSLinkedList<Flight> (); 
	}
	
	public void scheduleFlight(boolean status, boolean priority, int timestamp) {
		int runway = checkRunway(); 
		Flight flight = new Flight(uniqueCounter, status, priority, timestamp, runway); 
		this.schedule.add(uniqueCounter, flight); 
		uniqueCounter++; 
	};
	
	private int checkRunway() {
		return 0; 
	}
}
