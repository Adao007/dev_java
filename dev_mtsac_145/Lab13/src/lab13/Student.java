package lab13;

public class Student {
	private String name;
	private Score score;
	
	public Student(String name, Score score) // constructor
	{
		this.name = name;
		this.score = score;
	}
	public Score getScore() //returns score
	{
		return score;
	}
	public String getName() //returns name
	{
		return name;
	}
	public String toString() //toString method
	{
		return this.name + " got " + this.getScore().getMath() + " in math and " + this.getScore().getEnglish() + " in english.";
	}
}
