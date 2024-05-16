package edu.csudh.airline.boarding.project;
// We list all the methods that we need in AL here

public interface BareBonesArrayList <E> {
	public void add(E a); // this method adds to the end of the list
	public void add(E a, int index); //Adds at specified index
	public E remove(int index); // Delete the element at index
	public E get(int index); // Returns element at index 
	public void set(E a, int index); // Update the element 
	public int getSize();	//Tells how many elements are there
	public int indexOf(E a); //Search for element, return -1 if not found
}
