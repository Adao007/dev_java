package Lab18;

public class Student {
	private String name; 
	private String id;
	private int javaScore;
	private int cppScore;
	private int pythonScore;
	private double average; 
	
	public Student(String name, String id, int javaScore, int cppScore, int pythonScore)
	{
		this.name = name;
		this.id = id;
		this.javaScore = javaScore;
		this.cppScore = cppScore;
		this.pythonScore = pythonScore; 
		this.average = (javaScore + cppScore + pythonScore) / 3.0; 
	}
	
	public double getAverage()
	{
		return average; 
	}
	
	public String toString()
	{
		return String.format("%10s %2s : %3.2f", name, id, average);
	}
}
