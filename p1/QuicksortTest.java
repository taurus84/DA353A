package p1;

import java.util.ArrayList;
import java.util.List;

public class QuicksortTest {
	
	
	
	public static void main(String[] args) {
//		Movie[] movies = new Movie[5];
//		movies[0] = new Movie("David", "Tran");
//		movies[1] = new Movie("Helen","Grönvall");
//		movies[2] = new Movie("Benjamin","Tran");
//		movies[3] = new Movie("Rudolf","Black");
//		movies[4] = new Movie("Jespter","Falk");
//		
//		for (int i = 0; i < movies.length; i++) {
//		      System.out.println(movies[i].getTitle());
//		 }
		
		List<Movie> movies = new ArrayList<Movie>();
		System.out.println();
		movies.add(new Movie("David", "Tran"));
		movies.add(new Movie("Helen","Grönvall"));
		movies.add(new Movie("Benjamin","Tran"));
		movies.add(new Movie("Rudolf","Black"));
		movies.add(new Movie("Jespter","Falk"));
		

		for (int i = 0; i < movies.size(); i++) {
		    System.out.println(movies.get(i).getTitle());
		}
		System.out.println();
		Sorter sort = new Sorter();
		sort.quickSort(movies, new SortTitle());
		
		for (int i = 0; i < movies.size(); i++) {
		    System.out.println(movies.get(i).getTitle());
		}
		
		
	}

}
