package test;
	
	public abstract class Data {
		public void show() {
			System.out.println("I am parent show");
			
		}
		public abstract void call();
	}
	class Child extends Data{
		public void print() {
			System.out.println("I am child print");
		}
		public void call() //the child class must override the abstract method without the abstract keyword
		{
			System.out.println("Call method");
		}
	}
	
	//now you can use the polymorphism (Parent p = new Child(); 
	//p.show() "I am parent show" 
	//p.print() is an error because there is no print method in the Data class.
	//p.call() "Call method" 
	
	//First the object will check the parent class for an method. There must be a method in the parent class. 
	//If there is the method in the parent class and no overriding method, it will use the parent class method.
	//If there is the method in the parent class and in the method in the child class (overriding method) then the 
	//the call will use the child method. 
	
	
	//4 characteristic of oop 
	// encapulation (private)
	//inheritance (code reuse)
	//polymorphism
	//abstraction 
	
	