package laboration1;

public class Exercise2 {

	public void everySecondReverse(String txt, int pos) {
		if(pos >= 0 && pos < txt.length()) {
			System.out.print(txt.charAt(pos));
			everySecondReverse(txt, pos-2);
		}
	}

	public static void main(String[] args) {
		Exercise2 prog = new Exercise2();
		prog.everySecondReverse( "Student", 6 ); // Resultat: teuS 
		prog.everySecondReverse( "L�rare", 3 ); // Resultat: a� 
		prog.everySecondReverse( "F�r�lder", 17 ); // Resultat: 
		prog.everySecondReverse( "Barn", -2 ); // Resultat:
		
		
	}
}


