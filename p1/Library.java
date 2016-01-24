package p1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import readWrite.Person;
import readWrite.ReadWriteLines;

public class Library {

	private List<Movie> movies = new ArrayList<Movie>();
	private List<Movie> tempList = new ArrayList<Movie>();
	private HumanGUI gui;
	private Sorter sorterare = new Sorter();;
	private EditMovie em = new EditMovie(this);
	private JFrame frameAddMovie = new JFrame("Add Movie");
	private JFrame frameEditMovie = new JFrame("Edit Movie");
	private JFrame frameSearch = new JFrame("Search");
	private int pos;

	public Library() {
		initializeFrames();
	}

	public void setHumanGUI(HumanGUI gui) {
		this.gui = gui;
	}

	public void initializeFrames() {
		frameAddMovie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameAddMovie.add(new InputMovie(this));
		frameAddMovie.pack();
		frameAddMovie.setLocation(650, 350);
		frameAddMovie.setVisible(false);
		frameAddMovie.setResizable(false);

		frameEditMovie.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameEditMovie.add(em);
		frameEditMovie.pack();
		frameEditMovie.setLocation(650, 350);
		frameEditMovie.setVisible(false);
		frameEditMovie.setResizable(false);

		frameSearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSearch.add(new SearchPanel(this));
		frameSearch.pack();
		frameSearch.setLocation(650, 200);
		frameSearch.setVisible(false);
		frameSearch.setResizable(false);

	}

	public void addMovie() {
		frameAddMovie.setVisible(true);
	}

	public void addMovie(Movie movie) {
		if(checkDuplicate(movie, 0)) {
			JOptionPane.showMessageDialog(null, "This movie already exists!");
		} else {
			movies.add(movie);
		}
		
		gui.update();
	}

	public void replaceMovie(Movie movie) {
		// if (movies.contains(movie)) {
		// JOptionPane.showMessageDialog(null, "This movie already exists!");
		// } else {
		// movies.remove(pos);
		// movies.add(pos, movie);
		// }
		if(checkDuplicate(movie, 0)) {
			JOptionPane.showMessageDialog(null, "You are trying to add a movie that already exists in library");
		} else {
			movies.remove(pos);
			movies.add(pos, movie);
			gui.update();
		}
		
	}

	/**
	 * Edit a movie in a specified position in list
	 * 
	 * @param pos
	 *            the movie in this position will be edited
	 */
	public void editMovie(int pos) {
		em.editValues(pos);
		frameEditMovie.setVisible(true);
		this.pos = pos;
	}

	/**
	 * Edit a specified Movie object
	 * 
	 * @param obj
	 *            the Movie object to be edited
	 */
	public void editMovie(Object obj) {
		Movie mov = (Movie) obj;
		int pos = movies.indexOf(mov);
		editMovie(pos);
	}

	/**
	 * Sorting the List<Movie>
	 * 
	 * @param quickSelected
	 *            if true, the list will be sorted with quicksort method. Else
	 *            it will be sorted with bubblesort
	 * @param sortWhat
	 *            By what the list will be sorted. Title, type, director,
	 *            length, genre, rating
	 */
	public void sort(boolean quickSelected, int sortWhat) {
		sorterare.sort(movies, quickSelected, sortWhat);
		gui.update();
	}

	/**
	 * Shuffles the List movies and updates the GUI
	 */
	public void shuffle() {
		Random rand = new Random();
		for (int i = 0; i < movies.size(); i++) {
			Movie temp = movies.get(i);
			int pos = rand.nextInt(movies.size());
			movies.set(i, movies.get(pos));
			movies.set(pos, temp);
		}
		gui.update();
	}

	/**
	 * Checks if the Movie object exists in the list. If not the Movie will be
	 * added
	 * 
	 * @param mov
	 */
//	public void checkDuplicate(Movie mov) {
//		if (movies.contains(mov)) {
//			JOptionPane.showMessageDialog(null, "This movie already exists!");
//		} else {
//			movies.add(mov);
//		}
//	}
	
	public boolean checkDuplicate(Movie mov, int pos) {
		if(pos < 0 || pos >= movies.size()) {
			return false;
		} else if (mov.equals(movies.get(pos))) {
			return true;
		} else {
			return checkDuplicate(mov, pos + 1);
		}
		
	}

	/**
	 * Removes a Movie object in a specified posistion
	 * 
	 * @param pos
	 */
	public void remove(int pos) {
		int reply = JOptionPane.showConfirmDialog(null,
				"Do you want to remove " + movies.get(pos).getTitle(),
				"Remove", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			movies.remove(pos);
		}
		gui.update();
	}

	/**
	 * Removes a specified Movie object.
	 * 
	 * @param obj
	 */
	public void remove(Object obj) {
		Movie mov = (Movie) obj;
		int reply = JOptionPane.showConfirmDialog(null,
				"Do you want to remove " + mov.getTitle() + " " + mov.getType()
						+ "?", "Remove", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			movies.remove(mov);
			gui.update();
		}
	}

	public void search() {
		frameSearch.setVisible(true);
	}

	/**
	 * Uses a linear search, though with a maximum of 1 result
	 * 
	 * @param str
	 */
	public void search(String str) {
		for (int i = 0; i < movies.size(); i++) {
			if (str.equalsIgnoreCase(movies.get(i).getTitle()))
				tempList.add(movies.get(i));
		}
		if (tempList.size() == 0) {
			JOptionPane.showMessageDialog(null, "Movie not found");
		} else {
			gui.updateWithSearchResults();
		}
	}
	
	/**
	 * Creates an iterator to search the whole list which contains the
	 * (sub)string value.
	 * 
	 * @param str
	 */
	public void searchWithIter(String str) {
		Movie movie;
		Iterator<Movie> iter1 = movies.iterator();
		while (iter1.hasNext()) {
			movie = iter1.next();
			if (movie.getTitle().toLowerCase().contains(str) && 
				movie.getTitle().toLowerCase().charAt(0) == str.toLowerCase().charAt(0)) {
				tempList.add(movie);
			}
		}
		if (tempList.size() == 0) {
			JOptionPane.showMessageDialog(null, "Movie not found");
		} else {
			gui.updateWithSearchResults();
		}
	}

	public void searchBinary() {
		Collections.sort(movies, new SortTitle());
		String str = JOptionPane.showInputDialog("Which movie do you want to search for?");
		int res = searchBinary(str);
		if (res < 0) {
			System.out.println("Movie not found");
		} else {
			tempList.add(movies.get(res));
			System.out.println("Movie found!!");
			gui.updateWithSearchResults();
		}
	}

	public int searchBinary(String key) {
		int res = -1, min = 0, max = movies.size() - 1, pos;
		while ((min <= max) && (res == -1)) {
			pos = (min + max) / 2;
			if (key.compareToIgnoreCase(movies.get(pos).getTitle()) == 0) {
				res = pos;
			} else if (key.compareToIgnoreCase(movies.get(pos).getTitle()) < 0) {
				max = pos - 1;
			} else {
				min = pos + 1;
			}
		}
		return res;
	}

	

	/**
	 * searching if the title exists in the movies list
	 * 
	 * @param str
	 *            the movie to find
	 * @return position of the movie. -1 if movie not found
	 */
	public int findTitle(String str) {
		int pos = -1;
		for (int i = 0; i < movies.size(); i++) {
			if (str.equalsIgnoreCase(movies.get(i).getTitle())) {
				pos = i;
			}
		}
		return pos;
	}

	/**
	 * Converts the List to an array and returns it
	 * 
	 * @return movs array with Movie objects
	 */
	public Movie[] getMovies() {
		Movie[] movs = movies.toArray(new Movie[movies.size()]);
		return movs;
	}

	public Movie[] getTempMovies() {
		Movie[] movs = tempList.toArray(new Movie[tempList.size()]);
		return movs;
	}

	public Movie getMovie(int pos) {
		return movies.get(pos);
	}

	public void printList() {
		String res = "";
		for (int i = 0; i < movies.size(); i++) {
			System.out.println(movies.get(i).toString());
			res += movies.get(i).toString();
		}
	}

	/**
	 * Reads a file containing info about movies.
	 */
	public void readFromFile() {
		ReadWriteLines rw = new ReadWriteLines();
		String[] arr = null;
		try {
			arr = rw.OpenFile("src/p1/movies.txt");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Movie[] m = new Movie[arr.length];

		for (int i = 0; i < arr.length; i++) {
			String[] splitter = arr[i].split(",");

			m[i] = new Movie(splitter[0], splitter[1], splitter[2],
					Integer.parseInt(splitter[3]), splitter[4],
					Double.parseDouble(splitter[5]));
		}

		for (int i = 0; i < m.length; i++) {
			addMovie(m[i]);
		}
		gui.update();
	}

	public void hideAddMovieFrame() {
		frameAddMovie.setVisible(false);
	}

	public void hideEditMovieFrame() {
		frameEditMovie.setVisible(false);
	}

	public void setupEditFrame(EditMovie editMovie) {
		this.em = editMovie;

	}

	public void hideSearchPanel() {
		frameSearch.setVisible(false);

	}

	public void clearTempList() {
		tempList.clear();
	}

	public void testing() {
		sorterare.doSome();
	}
}
