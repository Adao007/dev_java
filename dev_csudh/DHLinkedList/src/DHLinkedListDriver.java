// Class to create and test the LL

public class DHLinkedListDriver {

	public static void main(String[] args) {
		// Create a LL object 
		DHSingleLinkedList <Integer> list = new DHSingleLinkedList<Integer> (); 
		
		list.add(0, 10); System.out.println(list); 
		
		list.add(0, 20); System.out.println(list); 
		
		list.add(0, 30); System.out.println(list); 
		
		list.add(0, 100); System.out.println(list);
		
		list.add(1, 99); System.out.println(list); 
		
		list.remove(2); list.remove(2); 
		
		System.out.println(list);
		
		list.set(0, 30); System.out.println(list);
		
		list.set(1, 20); System.out.println(list); 
		
		System.out.println(list.get(0) - list.get(1) - list.get(2)); 
		
	}
}
