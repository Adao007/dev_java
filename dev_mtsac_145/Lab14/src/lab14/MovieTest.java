package lab14;

import java.util.ArrayList;

public class MovieTest {
	
	//compares the years of movies in list and returns oldest
	public static Movie findOldest(ArrayList<Movie> list)
	{
		Movie oldest = list.get(0);
		int count = 0;
		
		for(int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getYear() < oldest.getYear())
			{
				oldest = list.get(i);
			}
			
		}
		return oldest;
	}
	
	public static void main(String[] args) 
	{
		ArrayList<Movie> movie = new ArrayList<Movie>();
		movie.add(new Movie("Avengers", 2019));
		movie.add(new Movie("The Lion King", 1994));
		movie.add(new Movie("Toy Story 3", 2010));
		movie.add(new Movie("Zootopia", 2016));
		movie.add(new Movie("Frozen", 2013));
		
		Movie old = findOldest(movie);
		
		System.out.println("The oldest movie is \"" + old+ '.');
		System.out.println("It was released in " + old.getYear());
			
		
			
	}
}
