package p1;

import java.util.Comparator;

public class SortRating implements Comparator {

	public int compare(Object obj1, Object obj2) {
		Movie m1 = (Movie) obj1;
		Movie m2 = (Movie) obj2;
		double rating1 =  m1.getRating();
		double rating2 =  m2.getRating();
		if (rating1 < rating2) {
			return -1;
		} else if (rating1 > rating2) {
			return 1;
		} else {
			return 0;
		}
		
	}
}

