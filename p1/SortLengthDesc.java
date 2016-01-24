package p1;

import java.util.Comparator;

public class SortLengthDesc implements Comparator {
	
	public int compare(Object obj1, Object obj2) {
		Movie m1 = (Movie) obj1;
		Movie m2 = (Movie) obj2;
		
		return m2.getLength() - (m1.getLength());
	}

}
