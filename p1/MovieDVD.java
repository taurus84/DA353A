package p1;

public class MovieDVD extends Movie {

	private boolean bluray = true;
	
	public MovieDVD(String title, String director, int length,
			String genre, double rating) {
		super(title, true, director, length, genre, rating);
		
	}
	
	public String toString() {

		return super.toString();
  }

}
