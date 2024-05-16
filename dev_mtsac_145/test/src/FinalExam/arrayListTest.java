package FinalExam;

import java.util.ArrayList;
import java.util.Iterator;

public class arrayListTest {
	static public void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(5);
		A.add(7);
		A.add(1);
		A.set(1, 8);
		A.add(2);
		A.add(3);
		A.remove(2); 
		
		Iterator<Integer> iter = A.iterator(); 
		while(iter.hasNext())
		{
			Integer t = iter.next();
			System.out.println(t);
			
		}
		System.out.println(A);
	}
}
