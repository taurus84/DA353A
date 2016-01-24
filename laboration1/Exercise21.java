package laboration1;

public class Exercise21 {
	
	public long fib(int n) {
		if(n <= 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return fib(n - 1) + fib(n-2);
		}
	}
	
	public static void main(String[] args) {
		Exercise21 prog = new Exercise21();
		System.out.println( prog.fib(1));		// Resultat: 1
		System.out.println( prog.fib(4));		// Resultat: 3
		System.out.println( prog.fib(8));	// Resultat: 21
			
				
				
				
				
	}

}
