package edu.csudh.airline.boarding.project;

// Simple Hashtable with only adding and searching
public class HashTable <E, F>{
	
	// Data Members 
	private DHArrayList<DHSingleLinkedList<F>> array;
	private int length; 
	private final int DEFAULT_CAPACITY = 107; 
	
	// Constructors 
	public HashTable() {
		array = new DHArrayList<DHSingleLinkedList<F>>(DEFAULT_CAPACITY);
		this.length = DEFAULT_CAPACITY; 
		for(int i = 0; i < this.length; i++) {
			array.add(new DHSingleLinkedList<F>());
		}
	}
	// Constructors that sets arraylist of linked list 
	public HashTable(int capacity) {
		array = new DHArrayList<DHSingleLinkedList<F>>(capacity); 
		this.length = capacity; 
		for(int i = 0; i < this.length; i++) {
			array.add(new DHSingleLinkedList<F>());
		}
	}
	
	// Adds to hashtable 
	public void put(E key, F value) { 
		int hashcode = hashCode((String)key) % this.length; 
		array.get(hashcode).add(0, value); 
	}
	
	// Returns variables if key given has value
	public boolean containsKey(E key) {
		int hashcode = hashCode((String)key) % this.length;
		return array.get(hashcode).size() != 0; 
	}
	
	// put new linked list into arraylist

	// NOTE: SLIDE HASH CODE METHOD WAS RETURNING MAX INT. TEMP FIX FOR PROJECT
	// hashcode for strings 
	private int hashCode(String key) {
		int code = 0; 
		for(int i = 0; i < key.length(); i++) {
			code = code + key.charAt(i) * (i * 31 / 3); 	// Random Hashing function that works with program
		}
		return code; 
	}
	
}
