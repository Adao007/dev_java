package lab172;

public class Players {
	public static void main(String[]args)
	{
		BaseballStats player1; 
		FootballStats player2; 
		
		player1 = new BaseballStats("Sal Runner", "Phillies");
		player2 = new FootballStats("Mel Rogers", "Redskins");
		
		player1.score();
		player2.score();
		player1.getHit();
		player2.gainYards(15);
		
		System.out.println(player1);
		System.out.println();
		System.out.println(player2);
	}
}
