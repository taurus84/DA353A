package laboration1;

public class Exercise20 {

	public int digits(int nbr) {
		
		if(nbr == 0) {
			return 0;
		} else {
			return 1 + digits(nbr/10);
		}
	}
	public static void main(String[] args) {
		Exercise20 prog = new Exercise20();
		System.out.println( prog.digits( 95004 ) );		// Resultat: 5
		System.out.println( prog.digits( 32 ) );			// Resultat: 2
		
		
	}
}
