package laboration4;

public class Exercise7 {
	
	public static void swap(Object[] array, int i, int j ) {
		Object temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
		Exercise7 prog = new Exercise7();
		double[] array = Exercise1.randomArray(10, 10, 20);
		Exercise1.printArray(array);
		System.out.println();
		Exercise7.swap(array, 1, 2);
		Exercise1.printArray(array);
		
		
	}
}
