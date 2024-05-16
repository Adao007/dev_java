package lab173;

public class Flute extends Instrument {
	public Flute(int volume)
	{
		super(volume);
	}
	public void print()
	{
		System.out.println("Flute volume : " + this.volume);
	}
	public void volumeUp()
	{
		this.volume += 2;
	}
	public void volumeDown()
	{
		this.volume -= 2;
	}
	
}

