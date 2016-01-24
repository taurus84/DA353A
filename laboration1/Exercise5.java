package laboration1;

public class Exercise5 {
	
	public void reverse(int min, int max) {
		if(min <= max) {
			reverse(min + 1, max);
			System.out.println(min + "");
		}
		
	}

	public static void main(String[] args) {
		Exercise5 prog = new Exercise5();
		prog.reverse(4, 10);
		System.out.println();
		prog.reverse(5,2);
		System.out.println();
		prog.reverse(-2, 1);
	}
}
