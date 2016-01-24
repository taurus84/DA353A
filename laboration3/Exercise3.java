package laboration3;

import java.util.Arrays;

public class Exercise3 {

	public void action() {
		
		Laboration3 l3 = new Laboration3();
		int[] array = l3.randomIntArray(100000);
		BinarySearch search = new BinarySearch();
		Arrays.sort(array);
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < 100000; i++) {
			for(int j = 0; j < array.length; j++) {
				if(array[j] == i) {
					break;
				}
			}
		}
		long stopp = System.currentTimeMillis(); 
		System.out.println( stopp - start );	
		
		long start2 = System.currentTimeMillis();
		
		for (int i = 0; i < 100000; i++) {
			//for(int j = 0; j < array.length; j++) {
				int index = search.binarySearch(array, i);
				//}
			
		}
		long stopp2 = System.currentTimeMillis(); 
		System.out.println( stopp2 - start2 );	
	}
	public static void main(String[] args) {
		Exercise3 prog = new Exercise3();
		prog.action();
	}
}

