package driver;

class Sum {
	private int sum;
	
	public int get() {
		return sum;
	}
	public void set(int sum) {
		this.sum = sum; 
	}
}

class Summation implements Runnable {
	private int upper;
	private Sum sumValue;
	
	public Summation(int upper, Sum sumValue) {
		if (upper < 0)
			throw new IllegalArgumentException();
		
		this.upper = upper;
		this.sumValue = sumValue;
	}
	
	public void run() {
		int sum = 0; 
		
		for(int i = 0; i <= upper; i++)
			sum += i;
		
		sumValue.set(sum); 
	}
}


public class Driver {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("Usage Driver <integer>: " + args[0]);
			System.exit(0);
		}
		
		Sum sumObject = new Sum();
		int upper = Integer.parseInt(args[0]);
		
		Thread work = new Thread(new Summation(upper, sumObject)); 
		work.start();
		
		try {
			work.join();
		} catch (InterruptedException ie) { }
		
		System.out.println("The sum of " + upper + " is " + sumObject.get());
	}
}
