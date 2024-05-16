package lab172;

public class FootballStats extends PlayerStats {
	protected int yards;
	
	public FootballStats(String player, String team)
	{
		super(player, team); 
	}
	
	public void score()
	{
		score += 6; 
	}
	
	public void gainYards(int yards)
	{
		this.yards += yards; 
	}
	
	public int getYards()
	{
		return yards; 
	}
	
	public String toString()
	{
		return super.toString() + "Score: " + score + "\nYards: " + yards; 
	}

}
