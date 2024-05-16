package lab13;

public class Score {
	private int math;
	private int english;
	
	public Score(int math, int english) //constructor
	{
		this.math = math;
		this.english = english;
	}
	
	public void setMath(int math) // sets math score
	{
		this.math = math;
	}
	
	public void setEnglish(int english) // sets english score
	{
		this.english = english;
	}
	
	public int getMath() //returns math score
	{
		return math;
	}
	public int getEnglish() // return english score
	{
		return english;
	}
}
