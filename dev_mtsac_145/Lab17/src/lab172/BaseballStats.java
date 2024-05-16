package lab172;

public class BaseballStats extends PlayerStats {
	protected int hits; 
	protected int errors; 
	
	public BaseballStats(String player, String team)
	{
		super(player, team);
	}
	
	public void score()
	{
		score += 1; 
	}
	
	public void getHit() {
		hits += 1; 
	}
	public void commitError() {
		errors += 1;
	}
	public int getHits()
	{
		return hits;
	}
	public int getErrors()
	{
		return errors; 
	}
	public String toString()
	{
		return super.toString() + "Hits: " + hits + "\nErrors: " + errors; 
	}
}
