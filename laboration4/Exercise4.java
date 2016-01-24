package laboration4;

public class Exercise4 {
	
	int counter = 0;
	
	public void testSorting(double[] array) {
		
		 insertionsortDesc(array);
		 printAndResetCounter();
		 bubbleSortDesc(array);
		 printAndResetCounter();
		
	}
	
	public void printAndResetCounter() {
		System.out.println(counter);
		counter = 0;
	}

	public void insertionsortDesc(double[] array) {
		for(int i = 1; i < array.length; i++) {
			for(int j = i; (j > 0 ) && (array[j-1] > array[j]); j-- ) {
				Utility.swap(array, j-1, j);
				counter++;
				
			}
		}
	}
	
	public void bubbleSortDesc(double[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = array.length - 1; j > i; j--) {
				if(array[j] > array[j-1]) {
					Utility.swap(array, j, j-1);
					counter++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Exercise4 prog = new Exercise4();
		prog.testSorting(Exercise1.randomArray(50, 10, 20));
	}
}
