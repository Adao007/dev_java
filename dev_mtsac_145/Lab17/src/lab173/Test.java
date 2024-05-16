package lab173;

public class Test {
	public static void main(String[] args)
	{
		Piano p1 = new Piano(10);
		Piano p2 = new Piano(20);
		Flute f = new Flute(100);
		
		p1.volumeUp();
		p2.volumeUp();
		f.volumeUp();
		p1.volumeUp();
		f.volumeUp();
		f.volumeUp();
		p2.volumeDown();
		
		p1.print();
		p2.print();
		f.print();
		
	}
}
