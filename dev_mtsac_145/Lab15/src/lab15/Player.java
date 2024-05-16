package lab15;

import java.util.Scanner;

public class Player {
	
	private String name; 
	private String team; 
	private int jerseyNumber; 
	
	public Player() {};
	
	public Player (String name, String team, int jerseyNumber)
	{
		this.name = name;
		this.team = team;
		this.jerseyNumber = jerseyNumber; 
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getTeam()
	{
		return team;
	}
	
	public int getjerseyNumber()
	{
		return jerseyNumber;
	}	
	
	public void readPlayer()
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Name : ");
		this.name = scan.next();
		
		System.out.print("Team: ");
		this.team = scan.next();
		
		System.out.print("Jersey Number: ");
		this.jerseyNumber = scan.nextInt();
		
	}
	
	public String toString()
	{
		String s = "Name : " + name + '\n'
				+ "Team : " + team + '\n'
				+ "Jersey number : " + jerseyNumber;
	
	return s; 
	}
}
