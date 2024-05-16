package arraylist;

public class ArrayListDriver {
	// Here we create ArrayList Object and test the methods
	public static void main(String[] args) {
		DHArrayList<Integer> list = new DHArrayList<>(); 
		//We have an arrayList created
		list.add(10);
		System.out.println(list); // the toString() method is called
		list.add(20);
		System.out.println(list);
		list.add(30);
		System.out.println(list);
		list.add(40);
		System.out.println(list);
		list.add(50);
		System.out.println(list);
		list.add(100, 4);
		System.out.println(list);
		list.remove(15);
		System.out.println(list);
		Integer value = list.get(0); 
		System.out.println("The value at location 0 is " + value);
		System.out.println(value);
		list.set(99, 0);
		System.out.println(list);
		list.indexOf(100); 
		Integer index = list.indexOf(101); 
		if(index >= 0)
			System.out.println("The value was found on index " + index);
	}

}
