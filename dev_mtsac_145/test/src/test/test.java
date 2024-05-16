package test;

import java.util.Arrays;

public  abstract class test { //an abstract test can have everything. But if you want to use this class, you will need a child test.
	 
	private int data; 
	
	public test(int data) {
		this.data = data; 
	}

	public void setData(int data) {
		this.data = data; 
	}
	
	}

