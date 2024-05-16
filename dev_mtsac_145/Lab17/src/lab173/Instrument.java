package lab173;

public abstract class Instrument {
	protected int volume; 
	
	public Instrument(int volume)
	{
		this.volume = volume; 
	}
	
	public abstract void print();
	public abstract void volumeUp();
	public abstract void volumeDown(); 
	
}
