package Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	
	public class ReadFromFile {
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter filename : ");
	String filename = scan.next();
	File file = new File(filename);
	Scanner scin;
	if (file.exists()) {
	try {
	scin = new Scanner(file);
	while (scin.hasNext()) {
	String name = scin.next();
	int grade = scin.nextInt();
	double gpa = scin.nextDouble();
	System.out.printf("%10s %2d %5.1f\n",  name, grade, gpa);
	}
	} catch (IOException e) { }
	} 
	else { System.out.println(filename + " does not exist!!"); }
	}
	}
}

