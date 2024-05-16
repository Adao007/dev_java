
public class flight {

	private int flightID; // Using an increasing integer-type range for unique IDs.
	private int status;
	private boolean priority; // true to determine if flight is priority.
	private int timestamp;

	public flight(int flightID, int status, boolean priority, int timestamp) {
			
		this.flightID = flightID;
		this.status = status;
		this.priority = priority;
		this.timestamp = timestamp;

	}

	public void setFlightID(int flightID) {

		this.flightID = flightID;

	}

	public void setStatus(int status) {
		this.status = status;

	}

		public void setPriority(boolean priority) {

			this.priority = priority;

		}

		// Method to change time if schedule changes

		public void setTimestamp(int timestamp) {

			this.timestamp = timestamp;

		}

		public int getFlightID() {

			return this.flightID;
		
		}

		public int getStatus() {

			return this.status;

		}

		public boolean getPriority() {

			return this.priority;

		}

		public int getTimestamp() {

			return this.timestamp;

		}

	}

