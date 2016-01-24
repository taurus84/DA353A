package laboration1;

public class Exercise12 {

	public int sum(int min, int max) {
		if (min > max) {
			return 0;
		} else if (min == max) {				//basfall ska inte vara med?? 
			return min;
		} else {
			return min + sum(min + 1, max);
		}

	}

	public static void main(String[] args) {
		Exercise12 prog = new Exercise12();
		System.out.println( prog.sum( 4, 8 ) ); // Resultat: 30
		System.out.println(prog.sum(5, 2)); // Resultat: 0
		System.out.println( prog.sum( -2, 1 ) ); // Resultat: -2
	}

}
