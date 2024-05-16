package Lab213;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	
		public static ArrayList<Integer> readDataFromFile(File file) throws IOException
		{
			ArrayList<Integer> scoreList = new ArrayList<>();
			Scanner scan; 
			
			if(file.exists())
				try
				{
					scan = new Scanner(file);
					while(scan.hasNext())
					{
						int score = scan.nextInt(); 
						scoreList.add(score);
					}
				}
				catch(IOException e) { }
			
			System.out.print("Original Score List: [");
			for(int i = 0; i < scoreList.size(); i++)
				System.out.print(scoreList.get(i) + ", ");
			System.out.print("]");
			System.out.println();
			
			return scoreList;
		}
		
		public static ArrayList<Score> createSortedList (ArrayList<Integer> list) 
		{
		
			ArrayList<Score> sortedList = new ArrayList<>();
			
			for(int i = 0; i < list.size(); i++)
			{
				for(int j = i; j < list.size(); j++)
				{
					int temp = list.get(i); 
					if(temp > list.get(j))
					{
						list.set(i, list.get(j));
						list.set(j, temp); 
					}
				}
				
			}
			
			System.out.println();
			
			int scan = 0; 
			for(int i = 0; i < list.size(); i += scan)
			{
				int count = 0; 
				int temp = (int)list.get(i);
				
				for(int j = i; j < list.size(); j++)
				{ 
					if(temp == (int)list.get(j))
					{
						scan++;
						count++; 
					}
					
					
					if(temp != (int)list.get(j))
						break; 
				}
			
				Score score = new Score(temp, count); 
				sortedList.add(score);
				i = 0;
				
			}
					
			return sortedList;
		}
		
		public static void main(String[] args)
		{
			ArrayList<Score> sortedList = new ArrayList<>(); 
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter name of file: ");
			File file = new File(scan.next()); 
			
			try {
				sortedList = createSortedList(readDataFromFile(file));
			}
			catch(IOException e) {}
		
			System.out.println("=================================================");
			System.out.println(String.format("%20s %20s", "Score", "Number of Students"));
			System.out.println("=================================================");
			for(int i = 0; i < sortedList.size(); i++)
			{
				System.out.println(sortedList.get(i)); 
			}
		}
		
}
