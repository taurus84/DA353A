package laboration3;

import java.util.Arrays;

public class Exercise9 {

	public void action() {

		Laboration3 l3 = new Laboration3();
		int[] array = l3.randomIntArray(100000);

		Arrays.sort(array);
		BinarySearch search = new BinarySearch();
		LinearSearch line = new LinearSearch();
		
		
		long start = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			//for(int j = 0; j < array.length; j++) {
				int index = search.binarySearch(array, i);
				//}
			
		}
				
		long stopp = System.currentTimeMillis();
		System.out.println(stopp - start);
		
		start = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			int index = line.indexOf(array, i);
		}
		stopp = System.currentTimeMillis();
		System.out.println(stopp - start);
		
		
	}
	

	public static void main(String[] args) {
		Exercise9 prog = new Exercise9();
		prog.action();
	}

}
