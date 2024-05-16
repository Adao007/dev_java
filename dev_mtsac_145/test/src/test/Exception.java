package test;

public class Exception {
		public static void main(String[] args)
		{
			int a =  5, b =0, c; 
			int A[] = {1, 2, 3, 4, 5};
			
			//When you first write the code. 
			//run the code first and see if there is a compile error.
			//then if the program runs and there is an exception.
			//then write the try and catch blocks. 
			
			System.out.println("This is the first line of the code!");
			try {
				System.out.println("hello");
				System.out.println("world");
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Lmao I'm comming for you dawg");
			}
			//If there are no errors then the catch block will be ignored. 
			
			try {
				A[2] = 1000;
				A[3] = 3000;
				A[6] = 4000;
				A[1] = 100;
			}
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("It has been handled");
			}
			
			try {
				c = a / b; 
				System.out.println("c : " + c); 
				A[10] = 10000; 
			} //you should write the exception catches as they occur in the code. 
			catch(ArithmeticException e) {
				System.out.println("Exception occured!!!!"); 
			}
			catch(IndexOutOfBoundsException e)
			{
				System.out.println("The second exception has occured!"); 
			}
			finally {
				System.out.println("The finally statement will always be written. In blood it shall remain.");
			}
			//you must write the child class first and then the parent class. 
			//there is an exception hierarchy. 
			
			System.out.println("The end of the program has been reached. Excellent!"); 

		
		}
}
