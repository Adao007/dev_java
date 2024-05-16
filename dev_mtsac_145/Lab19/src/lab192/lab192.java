package lab192;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class lab192 {
	public static void main(String[] args)
	{
		File file = new File("book.txt");
		ArrayList<book> books = new ArrayList<book>();
		Scanner scin;

		if (file.exists()) {
			try {
				scin = new Scanner(file);
				while (scin.hasNext()) {
					int code = scin.nextInt();
					String title = scin.next();
					int price = scin.nextInt();
					books.add(new book(code, title, price)); 
				
					for(int i = 0; i < books.size() - 1; i++) {
						if(books.get(i).equals(books.get(books.size() - 1)))
							books.remove(books.size() - 1); 
				}
				}
		} catch (IOException e) { }
	} 
	else { System.out.println("book.txt" + " does not exist!!"); }
	
	Iterator iter = books.iterator();
	while(iter.hasNext())
		System.out.println(iter.next()); 
}

}
