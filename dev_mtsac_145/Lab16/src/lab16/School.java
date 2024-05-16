package lab16;

public class School {
	public static void main(String[] args)
	{
		Person[] ps = new Person[10];
		ps[0] = new Professor("A1113", "Sam", "sam@mtsac.edu", "PhD", 10);
		ps[1] = new Students("A4367", "Paul", "paul@mtsac.edu", "Math", 3.75);
		ps[2] = new Students("A2254", "Carla", "carla@mtsac.edu", "Physics", 3.6);
		ps[3] = new Staffs("A1213", "Steve", "steve@mtsac.edu", "Executive assistant", 15);
		ps[4] = new Staffs("A7723", "Norm", "norm@mtsac.edu", "Curriculum Specialist", 13);
		ps[5] = new Staffs("A8372", "Lisa", "lisa@mtsac.edu", "Assistant Director", 9);
		ps[6] = new Professor("A5536", "Cliff", "cliff@mtsac.edu", "MS", 21);
		ps[7] = new Staffs("A4324", "Linda", "linda@mtsac.edu", "Program Director", 8);
		ps[8] = new Students("A1882", "June", "june@mtsac.edu", "Computer Science", 3.9);
		ps[9] = new Students("A7283", "Tom", "tom@mtsac.edu", "Math", 3.4);
		
		System.out.println("            Professors              ");
		System.out.println("-------------------------------------");
		for(int i = 0; i < ps.length; i++)
			if(ps[i] instanceof Professor)
			{
				System.out.println(ps[i]);
			}
		System.out.println();
		
		System.out.println("            Staffs              ");
		System.out.println("------------------------------------------------------------");
		for(int i = 0; i < ps.length; i++)
			if(ps[i] instanceof Staffs)
			{
				System.out.println(ps[i]);
			}
		System.out.println();
		
		System.out.println("            Students              ");
		System.out.println("-----------------------------------------------------------");
		for(int i = 0; i < ps.length; i++)
			if(ps[i] instanceof Students)
			{
				System.out.println(ps[i]);
			}
		System.out.println();
	}
}
