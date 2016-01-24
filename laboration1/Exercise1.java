package laboration1;

public class Exercise1 {
	
	public void print(int min, int max) {
		if(min <= max) {
			System.out.println(min + "");
			print(min + 1, max);
		}
	}

	public static void main(String[] args) {
		Exercise1 prog = new Exercise1();
		prog.print( 10, 15 ); // Resultat: 10 11 12 13 14 15 
		prog.print( 15, 10 ); // Resultat: 
		prog.print( -3, 4 ); // Resultat: -3 -2 -1 0 1 2 3 4
	}
}

