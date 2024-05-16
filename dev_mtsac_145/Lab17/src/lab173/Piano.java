package lab173;

public class Piano extends Instrument {
	public Piano(int volume)
	{
		super(volume);
	}
	public void print()
	{
		System.out.println("Piano volume : " + this.volume);
	}
	public void volumeUp()
	{
		this.volume += 1;
	}
	public void volumeDown()
	{
		this.volume -= 1;
	}
	
}
