package edu.csudh.airline.boarding.project;
/*
 * 	Queue interface from 
 * 		Trees_Part1: Slide 102
 * 		URL: https://canvas.csudh.edu/courses/69964/files/2978924?module_item_id=2639469
 */

public interface Queue<E> {
	boolean offer(E item); 
	
	E remove();
	
	E poll(); 
	
	E peek(); 
	
	E element(); 
}
