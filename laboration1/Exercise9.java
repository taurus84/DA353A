package laboration1;

public class Exercise9 {

	public boolean member(int nbr, int[] array, int pos) {
		if(pos < 0 || pos >= array.length) {
			return false;
		} else if (nbr == array[pos]) {
			return true;
		} else {
			return member(nbr, array, pos + 1);
		}
		
	}
	
	public static void main(String[] args) {
		Exercise9 prog = new Exercise9();
		int[] arr = { 23, -45, -20, 10, 8 };
		System.out.println( prog.member( 17, arr, 0 ) ); // Resultat: false
		System.out.println( prog.member( 23, arr, 0 ) ); // Resultat: true
		System.out.println( prog.member( 23, arr, 2 ) ); // Resultat: false 
		System.out.println( prog.member( 10, arr, 0 ) ); // Resultat: true
	}
}
