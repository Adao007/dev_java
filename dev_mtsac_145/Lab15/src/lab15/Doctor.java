package lab15;

public class Doctor extends HospitalEmployee {
		
		protected String specialty;
		
		public Doctor(String name, int number, String specialty)
		{
			super(name, number);
			this.specialty = specialty;
		}
		public void setSpecialty(String specialty)
		{
			this.specialty = specialty;
		}
		public String getSpecialty()
		{
			return specialty;
		}
		public String toString()
		{
			return super.toString() + " " + specialty;
		}
		public void diagnose()
		{
			System.out.println(this.name + "is a(n) " + specialty + " doctor.");
		}
}
