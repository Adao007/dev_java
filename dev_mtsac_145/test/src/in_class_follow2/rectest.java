package in_class_follow2;

public class rectest {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(); //default constructor
		Rectangle r2 = new Rectangle(2, 7); 
		r1.setLength(3);
		r1.setWidth(5);
		
		r1.print(); 
		r2.print();
	}
}
