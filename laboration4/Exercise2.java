package laboration4;

public class Exercise2 {
	
	public void insertionsortDesc(double[] array) {
		for(int i = 1; i < array.length; i++) {
			for(int j = i; (j > 0 ) && (array[j-1] > array[j]); j-- ) {
				Utility.swap(array, j, j-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Exercise2 prog = new Exercise2();
		
	}

}
