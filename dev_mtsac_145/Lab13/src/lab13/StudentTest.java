package lab13;


	public class StudentTest {
		public static void main(String[] args)
		{
		Score debbieScore = new Score(90, 88);
		Student debbie = new Student("Debbie", debbieScore);
		Score steveScore = new Score(88, 93);
		Student steve = new Student("Steve", steveScore);
		System.out.println(debbie);
		System.out.println(steve);
		if (debbie.getScore().getMath() > steve.getScore().getMath()) 
		System.out.println(debbie.getName() + "'s math score is better than " + steve.getName());
		else if (debbie.getScore().getMath() == steve.getScore().getMath())
		System.out.println(debbie.getName() + "'s math score is the same as " + steve.getName() + "'s score.");
		else
		System.out.println(steve.getName() + " has better math score than " + debbie.getName());
		}
		}

