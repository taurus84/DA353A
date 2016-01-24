package p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import laboration4.Utility;

public class Sorter {
	
	private boolean boolTitle, boolType, boolDirector, boolLength, boolGenre, boolRating;
	
	public void sort(List<Movie> movies, boolean quickSelected) {
		if(quickSelected) {
			if(boolTitle) {
				quickSort(movies, new SortTitleDesc());
				boolTitle = false;
			} else {
				quickSort(movies, new SortTitle());
				boolTitle = true;
			}
		} else {
			if(boolTitle) {
				bubblesort(movies, new SortTitleDesc());
				boolTitle = false;
			} else {
				bubblesort(movies, new SortTitle());
				boolTitle = true;
			}
		}
	}
	
	public void sort(List<Movie> movies, boolean quickSelected, int sortWhat) {
		switch (sortWhat) {
		case 0:
			if(quickSelected) {
				if(boolTitle) {
					quickSort(movies, new SortTitleDesc());
					boolTitle = false;
				} else {
					quickSort(movies, new SortTitle());
					boolTitle = true;
				}
			} else {
				if(boolTitle) {
					bubblesort(movies, new SortTitleDesc());
					boolTitle = false;
				} else {
					bubblesort(movies, new SortTitle());
					boolTitle = true;
				}
			} break;
		case 1:
			if(quickSelected) {
				if(boolType) {
					quickSort(movies, new SortTypeDesc());
					boolType = false;
				} else {
					quickSort(movies, new SortType());
					boolType = true;
				}
			} else {
				if(boolType) {
					bubblesort(movies, new SortTypeDesc());
					boolType = false;
				} else {
					bubblesort(movies, new SortType());
					boolType = true;
				}
			} break;
		case 2:
			if(quickSelected) {
				if(boolDirector) {
					quickSort(movies, new SortDirectorDesc());
					boolDirector = false;
				} else {
					quickSort(movies, new SortDirector());
					boolDirector = true;
				}
			} else {
				if(boolDirector) {
					bubblesort(movies, new SortDirectorDesc());
					boolDirector = false;
				} else {
					bubblesort(movies, new SortDirector());
					boolDirector = true;
				}
			} break;
		case 3:
			if(quickSelected) {
				if(boolLength) {
					quickSort(movies, new SortLengthDesc());
					boolLength = false;
				} else {
					quickSort(movies, new SortLength());
					boolLength = true;
				}
			} else {
				if(boolLength) {
					bubblesort(movies, new SortLengthDesc());
					boolLength = false;
				} else {
					bubblesort(movies, new SortLength());
					boolLength = true;
				}
			} break;
		case 4:
			if(quickSelected) {
				if(boolGenre) {
					quickSort(movies, new SortGenreDesc());
					boolGenre = false;
				} else {
					quickSort(movies, new SortGenre());
					boolGenre = true;
				}
			} else {
				if(boolGenre) {
					bubblesort(movies, new SortGenreDesc());
					boolGenre = false;
				} else {
					bubblesort(movies, new SortGenre());
					boolGenre = true;
				}
			} break;
		case 5:
			if(quickSelected) {
				if(boolRating) {
					quickSort(movies, new SortRatingDesc());
					boolRating = false;
				} else {
					quickSort(movies, new SortRating());
					boolRating = true;
				}
			} else {
				if(boolRating) {
					bubblesort(movies, new SortRatingDesc());
					boolRating = false;
				} else {
					bubblesort(movies, new SortRating());
					boolRating = true;
				}
			}
		}
	}
	

	public void quickSort(List<Movie> movies, Comparator<Movie> comp) {
		quickSort(movies, 0, movies.size() - 1, comp);
	}

	public void quickSort(List<Movie> movies, int left, int right,
			Comparator<Movie> comp) {

		int pivot;
		if (left < right) {
			pivot = partition(movies, left, right, (left + right) / 2, comp);
			quickSort(movies, left, pivot - 1, comp);
			quickSort(movies, pivot + 1, right, comp);
		}
	}

	private int partition(List<Movie> movies, int left, int right, int index,
			Comparator<Movie> comp) {

		Movie partitionValue = movies.get(index);

		int store = left;
		swap(movies, index, right);

		for (int i = left; i < right; i++) {
			if (comp.compare(movies.get(i), partitionValue) < 0) {
				swap(movies, i, store);
				store++;
			}
		}
		swap(movies, store, right);

		return store;

	}

	private static void swap(List<Movie> movies, int i, int j) {
		Movie temp = movies.get(i);
		movies.set(i, movies.get(j));
		movies.set(j, temp);
	}

	public void bubblesort(List<Movie> movies, Comparator<Movie> comp) {
		for (int i = 0; i < movies.size() - 1; i++) {
			for (int j = movies.size() - 1; j > i; j--) {
				if (comp.compare(movies.get(j), movies.get(j - 1)) < 0)
					exchange(j, j - 1, movies);
			}
		}
	}

	public void exchange(int i, int j, List<Movie> movies) {
		Movie temp = movies.get(i);
		movies.set(i, movies.get(j));
		movies.set(j, temp);

	}

	public void doSome() {
		System.out.print("Hej");

	}
}
