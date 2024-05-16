package lab16;

public class Professor extends Person{
	private String degree;
	private int career;
	
	public Professor(String id, String name, String email, String degree, int career)
	{
		super(id, name, email);
		this.degree = degree;
		this.career = career;
	}
	
	public void setDegree(String degree)
	{
		this.degree = degree;
	}
	public void setCareer(int career)
	{
		this.career = career;
	}
	public String getDegree()
	{
		return degree;
	}
	public int getCareer()
	{
		return career;
	}
	
	public String toString()
	{
		return super.toString() + "    " + degree + " " + career; 
	}
}
