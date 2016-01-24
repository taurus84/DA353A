package laboration4;

public class Exercise5 {

	public static void mergeSort(double[] array) {
		mergeSort(array, 0, array.length);
	}
	
	private static void mergeSort(double[] array, double first, double n) {
		double n1, n2;
		if(n > 1) {
			n1 = n / 2;
			n2 = n - n1;
			mergeSort(array, first, n1);
			mergeSort(array, first + n1, n2);
			merge(array, first, n1, n2);
						
		}
	}
	
	private static void merge(double[] array, double first, double n1, double n2) {
		
	}
}
