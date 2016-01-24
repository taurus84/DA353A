package laboration4;

import java.util.Comparator;
import java.util.List;

import p1.Movie;


public class QuickSort {
	
	private static void quickSort(List<Movie> movies, int left, int right, Comparator<Movie> comp) {
		int pivot;
		if (left < right) {
			pivot = partition(movies, left, right, (left + right) / 2, comp);
			quickSort(movies, left, pivot - 1, comp);
			quickSort(movies, pivot + 1, right, comp);
		}
	}

	private static int partition(List<Movie> movies, int left, int right, int index, Comparator<Movie> comp) {
		Movie ranking = movies.get(index);
		int save = left;
		swap(movies, index, right);
		for (int i = left; i < right; i++) {
			if (comp.compare(movies.get(i), ranking) <0) {
				swap(movies, i, save);
				save++;
			}
		}
		swap(movies, save, right);
		return save;
	}

	
	
	public static void quickSort(List<Movie> movies, Comparator<Movie> comp) {
		quickSort(movies, 0, movies.size() - 1, comp);
	}
	
	private static void swap(List<Movie> movies, int i, int change) {
		Movie temp = movies.get(i);
		movies.set(i, movies.get(change));
		movies.set(change, temp);		
	}
	
//    public static int Partition(Movie[] movies, int left, int right) {
//      Movie pivot = movies[left];
//      while (true)
//      {
//          while (movies[left] < pivot)
//              left++;
//
//          while (movies[right] > pivot)
//              right--;
//
//          if (left < right)
//            {
//              Movie temp = movies[right];
//              movies[right] = movies[left];
//              movies[left] = temp;
//            }
//            else
//            {
//                  return right;
//            }
//      }
//  }
//
//    public static void QuickSort_Recursive(Movie[] arr, int left, int right)
//  {
//      // For Recusrion
//      if(left < right)
//      {
//          int pivot = Partition(arr, left, right);
//
//          if(pivot > 1)
//              QuickSort_Recursive(arr, left, pivot - 1);
//
//          if(pivot + 1 < right)
//              QuickSort_Recursive(arr, pivot + 1, right);
//      }
//  }
//	
}
