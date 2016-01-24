package p1;

import java.util.Comparator;

public class SortDirectorDesc implements Comparator {

	public int compare(Object obj1, Object obj2) {
		Movie m1 = (Movie) obj1;
		Movie m2 = (Movie) obj2;
		
		String dir1 = m1.getDirector();
		String dir2 = m2.getDirector();
						
		if(dir1 == null) {
			return -1;
		} else if( dir2 == null) {
			return 1;
		}
		int result = dir2.compareTo(dir1);
		// if same director, should be sorted by title
		if (result == 0) {
			return m2.getTitle().compareTo(m1.getTitle());
		}

		return result;
	}
}
