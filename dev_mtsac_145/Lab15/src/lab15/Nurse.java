package lab15;

public class Nurse extends HospitalEmployee {
	
	protected int numPatients;
	
	public Nurse(String name, int number, int numPat)
	{
		super(name, number);
		this.numPatients = numPat;
	}
	public void setNumPatients(int pat)
	{
		this.numPatients = pat;
	}
	public int getNumPatients()
	{
		return numPatients;
	}
	public String toString()
	{
		return super.toString() + " has " + numPatients + " patients.";
	}
	public void assist()
	{
		System.out.println(this.name + " has " + numPatients + " patients.");
	}
}
