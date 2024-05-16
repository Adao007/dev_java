package Lab213;

public class Score {
	private int score; 
	private int count; 
	
	public Score(int score, int count)
	{
		this.score = score; 
		this.count = count; 
	}
	
	public String toString()
	{
		return String.format(" %17d %15s", score, count);
	}
}
