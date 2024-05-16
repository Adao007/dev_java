package lab15;

public class Hospital {

	public static void main(String[] args)
	{
	HospitalEmployee vito = new HospitalEmployee("Vito", 123);
	Doctor steve = new Doctor("Steve", 234, "Heart");
	Nurse sonny = new Nurse("Sonny", 789, 6);
	Administrator luca = new Administrator("Luca", 375, "Business");
	Receptionist tom = new Receptionist("Tom", 951, "Talking", true);
	Janitor anthony = new Janitor("Anthony", 123, "Maintenence", false);
	System.out.println("Employees information");
	System.out.println("-------------------------------------");
	System.out.println(vito);
	System.out.println(steve);
	System.out.println(sonny);
	System.out.println(luca);
	System.out.println(tom);
	System.out.println(anthony);
	System.out.println("\nInvoking the specific methods");
	System.out.println("-------------------------------------");
	vito.work();
	steve.diagnose();
	sonny.assist();
	luca.administrate();
	tom.answer();
	anthony.sweep();
	}
}
