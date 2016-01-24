package laboration4;

import java.util.Random;

public class Exercise1 {

	public static double[] randomArray(int n, double min, double max) {
		Random rand = new Random();
		double[] res = new double[n];
		for (int i = 0; i < n; i++) {
			res[i] = rand.nextDouble() * (max - min) + min;
		}
		return res;
	}
	
	public static void printArray(double[] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public void insertionsortDesc(double[] array) {
		for(int i = 1; i < array.length; i++) {
			for(int j = i; (j > 0 ) && (array[j-1] > array[j]); j-- ) {
				Utility.swap(array, j-1, j);
			}
		}
	}
	
	public void bubbleSortDesc(double[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = array.length - 1; j > i; j--) {
				if(array[j] > array[j-1]) {
					Utility.swap(array, j, j-1);
				}
			}
		}
	}
	
	public void mergeSort(double[] array) {
		
	}
	
	public static void main(String[] args) {
		Exercise1 prog = new Exercise1();
		int arrSize = 10;
		double[] array = new double[arrSize];
		array = prog.randomArray(arrSize, 10, 20);
		printArray(array);
		System.out.println();
//		prog.insertionsortDesc(array);
		prog.bubbleSortDesc(array);
		printArray(array);
	}
		

}
