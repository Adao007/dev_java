package lab12;

public class lab122 {
	public static int compareAge(Dog[] D)
	{
		int old = 0;

		for(int i = 0; i < D.length; i++)
		{
			if (D[i].getAge() > old)
				old = D[i].getAge();
		}
		return old;
	}
	public static void getOldDogs(int a, Dog[] D)
	{
		System.out.println("List of oldest Dogs");
		System.out.println("-----------------------------------");
		for(int i = 0; i < D.length; i++)
		{
			if (D[i].getAge() == a)
				System.out.println(D[i].getName() + " is " + D[i].getAge() + " years old " +
									"(breed : " + D[i].getBreed() + ")");
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
		dogs[8] = new Dog("Louie", 5, "Shepherd");
		dogs[9] = new Dog("Teddy", 3, "Maltese");
		int oldestAge = 0;
		
		for (int i = 0; i < dogs.length; i++)
		{
			oldestAge = compareAge(dogs);
		}
		
		getOldDogs(oldestAge, dogs);
	}
}
