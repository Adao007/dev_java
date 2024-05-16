package edu.csudh.airline.boarding.project;

public class HashTableDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable<String, Integer> table = new HashTable<>(61); 
		table.put("Anthony Dao", 1);
		System.out.println(table.containsKey("Anthony Dao")); 
	}

}
