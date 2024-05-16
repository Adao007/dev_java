package lab17;

public class Demographics {
	public static void main(String[] args)
	{
		Person[] demos = new Person[4]; 
		
		demos[0] = new Person(8, "Utah");
		demos[1] = new Student(25, "New Mexico", "University of New Mexico"); 
		demos[2] = new ForeignStudent(19, "Ohio", "Ohio State", "India"); 
		demos[3] = new Worker(38, "Delaware", "Tile Setter", 40000); 
		
		for(int i = 0; i < demos.length; i++)
			System.out.println(demos[i] + "\n---------------------------------\n");
	}
}
