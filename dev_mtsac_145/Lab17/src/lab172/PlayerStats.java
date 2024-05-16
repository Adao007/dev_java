package lab172;

public abstract class PlayerStats {
	protected String player;
	protected String team; 
	protected int score; 
	
	public PlayerStats(String player, String team)
	{
		this.player = player;
		this.team = team;  
	}

	public int getScore()
	{
		return score; 
	}
	public abstract void score();
	
	public String toString()
	{
		return "Player: " + player + "\nTeam: " + team + "\n"; 
	}
}
