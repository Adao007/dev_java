package lab15;

public class lab151 {
	
	public class ComparePlayers {
		public static boolean equalPlayer(Player p1, Player p2)
		{
			if (p1.getName().equals(p2.getName()) && p1.getTeam().equals(p2.getTeam()) 
					&& p1.getjerseyNumber() == p2.getjerseyNumber())
				return true;
			else 
				return false;
		}
		
		public static void main(String[] args)
		{
			Player player1 = new Player();
			Player player2 = new Player();
			
			System.out.println("Input Player1 Information");
			player1.readPlayer();
			System.out.println("\nInput Player2 Information");
			player2.readPlayer();
			
			if (equalPlayer(player1, player2))
				System.out.println("\nsame player");
			else
				System.out.println("\ndifferent player");
			
			System.out.println("\nPlayer1 Information");
			System.out.println("--------------------");
			System.out.println(player1);
			
			System.out.println("\nPlayer2 Information");
			System.out.println("--------------------");
			System.out.println(player2);
		}
		}
}
