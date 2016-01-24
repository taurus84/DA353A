package p1;

public class Movie {
	
	private String type;
	private String title;
	private String genre;
	private int length;
	private String director;
	private double rating;
	private String[] actors;
	
	public Movie(String title, boolean bluray, String director, int length, String genre, double rating) {
		this.setType(bluray);
		this.title = title;
		this.genre = genre;
		this.length = length;
		this.director = director;
		this.rating = rating;
		this.actors = actors;
	}
	
	public Movie(String title, String type, String director, int length, String genre, double rating) {
		this.type = type;
		this.title = title;
		this.genre = genre;
		this.length = length;
		this.director = director;
		this.rating = rating;
		this.actors = actors;
	}
	
	public Movie(String title, String director) {
		this.title = title;
		this.director = director;
		this.genre = "Hej";
	}
	
	public String getType() {
		return type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getDirector() {
		return director;
	}
	
	public double getRating() {
		return rating;
	}
	
	public String[] getActors() {
		return actors;
	}
	
	public void setType(boolean bool) {
		if(bool) {
			this.type = "Bluray";
		} else {
			this.type = "DVD";
		}
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setLength(int minutes) {
		this.length = minutes;
	}
	
	public void setDirector(String director) {
		this.director = director;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@Override
	public boolean equals(Object object) {
	
		Movie mov = (Movie) object;
		if(this.title.equals(mov.getTitle()) && this.type.equals(mov.getType())) {
			return true;
		} else {
			return false;
		}
	}
			
	public String toString() {

//		return String.format( "%1$-15s %2$-10s %3$-13s %4$-11s %5$-10s %6$5s", this.title, this.type, this.director, this.length, this.genre, this.rating );
		return String.format( "%1$-20s %2$-7s %3$-17s %4$-7s %5$-10s %6$4s", this.title, this.type, this.director, this.length, this.genre, this.rating );
    }
	
//	public static void main(String[] args) {
//		Movie mov = new Movie("Big Hero", "Disney");
//		System.out.println(String.format( "%-25s%-25s%-25s%-25s%-25s%-25s", "TYPE", "TITLE", "DIRECTOR", "LENGTH (MIN)", "GENRE", "RATING" ));
//		System.out.print(mov.toString());
//		
//	}
	
	
	
	

}
