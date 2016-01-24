package laboration1;

public class Exercise10 {

	public int mystery3(int[] array, int pos) {
		if (pos >= array.length) {
			return 0;
		} else {
			return array[pos] + mystery3(array, pos + 2);
		}
	}
	
	public static void main(String[] args) {
		Exercise10 prog = new Exercise10();
		int[] arr = { 23, -45, -20, 10, 8 };
		System.out.println( prog.mystery3( arr, 0 ) );  //adderar elementen från pos 0 och varannat element
		System.out.println( prog.mystery3( arr, 1 ) );	//adderar elementen från pos 1 och varannat element
	}

}
