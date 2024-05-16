package lab12;

public class lab121 {
	
	
	
	public static void findAndPrint(Dog[] D, String br)
	{
		for(int i = 0; i < D.length; i++)
		{
			if (D[i].getBreed().equals(br)) {
				System.out.println("   " + D[i].getName() + "  " + D[i].getAge() + " years old" );
			}
		}
		
	}
	
	public static void main(String[] args)
	{	
		Dog[] dogs = new Dog[10];
		dogs[0] = new Dog("Buddy", 3, "Beagle");
		dogs[1] = new Dog("Max", 2, "Shepherd");
		dogs[2] = new Dog("Milo", 1, "Beagle");
		dogs[3] = new Dog("Daisy", 4, "Poodle");
		dogs[4] = new Dog("Rusty", 5, "Bulldog");
		dogs[5] = new Dog("Rocky", 2, "Bulldog");
		dogs[6] = new Dog("Coco", 3, "Maltese");
		dogs[7] = new Dog("Benji", 5, "Bulldog");
		dogs[8] = new Dog("Louie", 2, "Shepherd");
		dogs[9] = new Dog("Teddy", 3, "Maltese");
		String[] breeds = {"Beagle", "Shepherd", "Poodle", "Bulldog", "Maltese"};
		
		for (int i=0; i<breeds.length; i++) 
		{
			System.out.println("\n=======================");
			System.out.println("List of " + breeds[i]);
			System.out.println("-----------------------");
			findAndPrint(dogs, breeds[i]);
		}
	}
}
