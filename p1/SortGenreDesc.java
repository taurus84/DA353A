package p1;

import java.util.Comparator;

public class SortGenreDesc implements Comparator {

	public int compare(Object obj1, Object obj2) {
		Movie m1 = (Movie) obj1;
		Movie m2 = (Movie) obj2;
		String genre1 = m1.getGenre();
		String genre2 = m2.getGenre();
		
		if(genre1 == null) {
			return -1;
		} else if( genre2 == null) {
			return 1;
		}
		
		int result = genre2.compareTo(genre1);
		
		//if same genre, should be sorted by title
		if(result == 0) {
			return m2.getTitle().compareTo(m1.getTitle());
		}
		
		return result;
	}
}
