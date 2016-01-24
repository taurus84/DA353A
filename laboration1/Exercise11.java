package laboration1;

public class Exercise11 {

	public int mystery4(int[] array, int pos) {
		if (pos >= array.length)
			return 0;
		else if (array[pos] < 0)
			return 1 + mystery4(array, pos + 1);
		else
			return mystery4(array, pos + 1);
	}
	
	public static void main(String[] args) {
		Exercise11 prog = new Exercise11();
		int[] arr = { 23, -45, -20, 10, 8 };
		System.out.println( prog.mystery4( arr, 0 ) );		//returnerar antalet negativa tal, start från pos 0
	}

}
