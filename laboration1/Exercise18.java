package laboration1;

public class Exercise18 {

	public void mystery7(int[] arr) {
		mystery7(arr, 0);
	}

	private void mystery7(int[] arr, int pos) {
		if ((pos >= 0) && (pos < arr.length)) {
			mystery7(arr, pos + 1);				//REKURSIV METOD INNAN UTSKRIFT GER BAKLÄNGES TÄNK
			System.out.print(arr[pos] + " ");			
		}
	}
	
	public static void main(String[] args) {
		Exercise18 prog = new Exercise18();
		int[] arr = { 3, 7, -2, 6, 9 };
		prog.mystery7(arr);
	}

	/*
	 * UTSKRIFT: 9 6 -2 7 3
	 */
}
