package laboration3;

import java.util.Random;

public class Exercise4 {
	

	public static void shuffle(Object[] obj) {

		Random rand = new Random();
		for(int i = 0; i < obj.length; i++) {
			Object temp = obj[i];
			int pos = rand.nextInt(obj.length);
			obj[i] = obj[pos];
			obj[pos] = temp;
			
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Integer(i);
		}
		Exercise4.shuffle(arr);
		for (Integer elem : arr)
			System.out.println(elem);
	}

}
