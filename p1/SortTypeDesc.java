package p1;

import java.util.Comparator;

public class SortTypeDesc implements Comparator {
	
	public int compare(Object obj1, Object obj2) {
		Movie m1 = (Movie) obj1;
		Movie m2 = (Movie) obj2;
		
		int result = m2.getType().compareTo(m1.getType());
		//if same kind, sort by title
		if (result == 0) {
			return m2.getTitle().compareTo(m1.getTitle());
		}
		
		return result;
	}

	

}
