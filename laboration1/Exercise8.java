package laboration1;

public class Exercise8 {
	
	public long factorial(long n) {
		if(n <= 1) {
			return 1;
		} else {
			return n * factorial(n-1);	
		}
	}
			
		
	
	public static void main(String[] args) {
		Exercise8 prog = new Exercise8();
		System.out.println( prog.factorial( 3 ) );	// Resultat: 6
		System.out.println( prog.factorial( -3 ) ); // Resultat: 1
		System.out.println( prog.factorial( 6 ) ); // Resultat: 720
		
	}

}
