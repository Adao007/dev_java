package Lab18;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class lab182 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter filename : ");
		String filename = scan.next();
		File file = new File(filename);
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		Scanner scin;
		
		System.out.println("---------------------------------");
		System.out.println("        Data from file"); 
		System.out.println("---------------------------------");
		if (file.exists()) {
			try {
				scin = new Scanner(file);
				while (scin.hasNext()) {
					String name = scin.next();
					String id = scin.next();
					int javaScore = scin.nextInt();
					int cppScore = scin.nextInt();
					int pythonScore = scin.nextInt();
					students.add(new Student(name, id, javaScore, cppScore, pythonScore)); 
					System.out.printf("%10s %2s : %3d %2d %2d \n",  name, id, javaScore, cppScore, pythonScore);
				}
			} catch (IOException e) { }
		} 
		else { System.out.println(filename + " does not exist!!"); }
	

		
		for(int i = 0; i < students.size(); ++i)
		{
			for(int j = 0; j < students.size(); ++j)
			{
				if (students.get(i).getAverage() < students.get(j).getAverage())
				{
					Student temp = students.get(i); 
					students.set(i, students.get(j)); 
					students.set(j, temp); 
				}
			}
		}
		System.out.println();
		System.out.println("====== After sorting by average ======");
		
		Iterator iter = students.iterator();
		while(iter.hasNext())
			System.out.println(iter.next()); 
	}
	
	
	
}

